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
@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/loginView/login.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher;
        if(userDAO.checkLogin(username)){
            User user = userDAO.selectUser(username);
            if(user!= null && user.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("user",username);
                response.sendRedirect("/game");
//                dispatcher = request.getRequestDispatcher("/game");
//                dispatcher.forward(request,response);
            }
        }else{
            dispatcher = request.getRequestDispatcher("/loginView/login.jsp");
            dispatcher.forward(request,response);
        }
    }
}
