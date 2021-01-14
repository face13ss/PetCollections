package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = "/game")
public class GameLogicFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = ((HttpServletRequest) request).getSession();
        RequestDispatcher dispatcher;
        String username = (String) session.getAttribute("user");
        if(username != null){
            dispatcher = req.getRequestDispatcher("/game");
            dispatcher.forward(req,resp);
        }else{
            session.invalidate();
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
