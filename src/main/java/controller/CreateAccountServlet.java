package controller;

import model.User;
import repository.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="CreateAccountServlet",urlPatterns = "/createAccount")
public class CreateAccountServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/loginView/createAccount.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String displayName = request.getParameter("displayName");
        String email = request.getParameter("email");
        if(userDAO.checkLogin(username)){
            request.setAttribute("message","Username already exists");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/loginView/createAccount.jsp");
            dispatcher.forward(request,response);
        }else{
            userDAO.insertUser(new User(username,password,displayName,email));
            HttpSession session = request.getSession();
            session.setAttribute("user",username);
            response.sendRedirect("/game");
        }
    }
}
