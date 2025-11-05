package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;
import com.pojo.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        if(userDao.validateUser(username, password)) {
            User user = userDao.getUserByUsername(username);
           
            if (user != null && user.getRole().trim().equalsIgnoreCase(role.trim())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);  // Store the whole User object, not just username.

                if ("STUDENT".equalsIgnoreCase(role.trim())) {
                    response.sendRedirect("studentHome.jsp");
                } else {
                    response.sendRedirect("FacultyHome.jsp");
                }
                return;
            } else {
                request.setAttribute("error", "Invalid role selection or user not found");
            }
        } else {
            request.setAttribute("error", "Invalid username or password");
        }
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
