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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	 

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	    	UserDao userDao = new UserDaoImpl();
	        
	        User user = new User();
	        user.setUsername(request.getParameter("username"));
	        user.setPassword(request.getParameter("password"));
	        user.setEmail(request.getParameter("email"));
	        user.setFullname(request.getParameter("fullname"));
	        user.setRole(request.getParameter("role"));
	        
	        if(userDao.registerUser(user)) {
	            request.setAttribute("message", "Registration successful! Please login.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        } else {
	            request.setAttribute("error", "Registration failed. Username or email already exists.");
	            request.getRequestDispatcher("register.jsp").forward(request, response);
	        }
    }

}
