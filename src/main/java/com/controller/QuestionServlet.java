package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.apache.coyote.Request;

import com.dao.QuestionDao;
import com.dao.SubjectDao;
import com.daoimpl.QuestionDaoImpl;
import com.daoimpl.SubjectDaoImpl;
import com.pojo.Question;
import com.pojo.Subject;
import com.pojo.User;


@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {   
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    SubjectDao subjectDao = new SubjectDaoImpl();
	    HttpSession session = request.getSession(false);

	    if (session == null || session.getAttribute("user") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    User user = (User) session.getAttribute("user");

	    if (user != null && "FACULTY".equals(user.getRole())) {
	        List<Subject> subjects = subjectDao.getAllSubject();
	        request.setAttribute("subjects", subjects);
	        request.getRequestDispatcher("addQuestion.jsp").forward(request, response);
	    } else {
	        response.sendRedirect("login.jsp");
	    }
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDao questionDao=new QuestionDaoImpl();
		SubjectDao subjectDao=new SubjectDaoImpl();
		
		  HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user");
	        String action = request.getParameter("action");
	        
	        if(user != null && user.getRole().equals("FACULTY")) {
	            if("add".equals(action)) {
	                Question question = new Question();
	                question.setSubject_id(Integer.parseInt(request.getParameter("subjectId")));
	                question.setQue_text(request.getParameter("questionText"));
	                question.setOption1(request.getParameter("option1"));
	                question.setOption2(request.getParameter("option2"));
	                question.setOption3(request.getParameter("option3"));
	                question.setOption4(request.getParameter("option4"));
	                question.setCorrect_option(Integer.parseInt(request.getParameter("correctOption")));
	                question.setCreated_by(user.getUsername());
	                
	                if(questionDao.addQuetion(question)) {
	                    request.setAttribute("message", "Question added successfully!");
	                } else {
	                    request.setAttribute("error", "Failed to add question");
	                }
	                
	                List<Subject> subjects = subjectDao.getAllSubject();
	                request.setAttribute("subjects", subjects);
	                request.getRequestDispatcher("addQuestion.jsp").forward(request, response);
	            }
	        } else {
	            response.sendRedirect("login.jsp");
	        }
		}
	}


