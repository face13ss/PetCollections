package controller;

import model.Friend;
import model.Pet;
import model.User;
import service.FriendDAO;
import service.PetDAO;
import service.PetTypeDAO;
import service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="GameLogicServlet",urlPatterns = "/game")
public class GameLogicServlet extends HttpServlet {
    private  UserDAO userDAO = new UserDAO();
    private  PetDAO petDAO = new PetDAO();
    private User user;
    private int userid;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        petDAO = new PetDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        if(session != null){
            user = userDAO.selectUser(username);
            userid = user.getId();
        }
        String action = request.getParameter("action");
        request.setAttribute("user",user);
        if (action == null){
            action ="";
        }
        switch (action){
            case "house":
                showPet(request, response);
                break;
            case "dungeon":
                showDungeon(request, response);
                break;
            case "forest":
                showForest(request,response);
                break;
            case "changePassword":
                changePasswordForm(request,response);
                break;
            case "shop":
                showShop(request,response);
                break;
            case "friendList":
                showFriends(request,response);
                break;
            case "logout":
                response.sendRedirect("/login");
                session.invalidate();
                break;
            default:
                showMain(request, response);
                break;
        }
    }

    private void showMain(HttpServletRequest request ,HttpServletResponse response)throws ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameView/mainRoom.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> petList = petDAO.selectAllPetByUserId(userid);
        request.setAttribute("petList",petList);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("/gameView/house.jsp");
        dispatcher.forward(request,response);

    }

    private void showDungeon(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameView/dungeon.jsp");
        dispatcher.forward(request,response);
    }

    private void showForest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameView/forest.jsp");
        dispatcher.forward(request,response);
    }

    private void  changePasswordForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/loginView/changePassword.jsp");
        dispatcher.forward(request,response);
    }

    private void showShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameView/shop.jsp");
        dispatcher.forward(request,response);
    }

    private void showFriends(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameView/friends.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        if(session != null){
            user = userDAO.selectUser(username);
            userid = user.getId();
        }
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "house":
                petControl(request, response);
                break;
            case "dungeon":
                showDungeon(request, response);
                break;
            case "shop":
                break;
            case "changePassword":
                changePassword(request,response);
                break;
            case "friendList":
                searchFriend(request,response);
                break;
            case "logout":
                session.invalidate();
                response.sendRedirect("/login");
                break;
            default:
                showMain(request, response);
                break;
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String repeatPassword = request.getParameter("repeatPassword");
        if(user.getPassword() .equals(oldPassword) && newPassword.equals(repeatPassword)){
            request.setAttribute("messagesPassword", "Password has changed");
            user.setPassword(newPassword);
            userDAO.updatePassword(user);
            response.sendRedirect("/game");


        }else{
            request.setAttribute("messagesPassword","Old Password or new password not matched!");
            response.sendRedirect("/game?action=changePassword");

        }

    }
    private void petControl(HttpServletRequest request, HttpServletResponse response){
        String trigger = request.getParameter("trigger");
        if(trigger == null){
            trigger = "";
        }
        switch (trigger){
            case "delete":
                int id = Integer.parseInt(request.getParameter("idDelete"));
                petDAO.deletePet(id);
                user.setMoney(user.getMoney() + 500);
                userDAO.updateUserMoney(user);
                break;
            case "healer":
                break;
            case "eggOpen":
                PetTypeDAO petTypeDAO = new PetTypeDAO();
                int count = user.getEggs();
                while (user.getEggs() > 1){
                    petTypeDAO.randomPet(userid);
                    user.setEggs(count--);
                    System.out.println(user.getEggs());
                }
                userDAO.updateUserEggs(user);
                break;
        }
        try {
            response.sendRedirect("/game?action=house");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String friendList = request.getParameter("friendList");
        if(friendList == null){
            friendList ="";
        }
        switch (friendList){
            case "search":
                String searchName = request.getParameter("searchName");
                FriendDAO friendDAO = new FriendDAO();
                List<Friend> peopleList = friendDAO.showPeople(searchName);
                request.setAttribute("user",user);
                request.setAttribute("peopleList",peopleList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/gameView/friends.jsp");
                dispatcher.forward(request,response);
                break;
        }
    }
}
