package com.lab12.controller;

import com.lab12.model.User;
import com.lab12.model.UserDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = "/login"
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        UserDataset userDataset = new UserDataset();
        List<User> userList = userDataset.getUserList();
        System.out.println(req.getRequestURI());

        for(User usr: userList) {
            if (username.equals((usr.getUsername())) && password.equals(usr.getPassword())) {
                req.getSession().setAttribute("user_info", username);
                if("yes".equals(remember)) {
                    Cookie c = new Cookie("user", username);
                    c.setMaxAge(30 * 24 * 60 * 60);
                    resp.addCookie(c);
                }else{
                    Cookie c = new Cookie("user", null);
                    c.setMaxAge(0);
                    resp.addCookie(c);
                }
                req.getRequestDispatcher("welcome.jsp").forward(req, resp);
            } else{
                req.getSession().setAttribute("error_msg", "Username or password invalid");
                req.getRequestDispatcher("login.jsp").forward(req, resp);;
            }
        }
    }
}
