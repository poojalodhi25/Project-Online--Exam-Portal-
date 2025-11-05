package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dao.SubjectDao;
import com.daoimpl.ExamDaoImpl;
import com.daoimpl.SubjectDaoImpl;
import com.pojo.Exam;
import com.pojo.Subject;
import com.pojo.User;

@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ExamDaoImpl examDao = new ExamDaoImpl();
        SubjectDao subjectDao = new SubjectDaoImpl();
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");  // Ensure this is a User object
        if (user.getRole().equals("FACULTY")) {
            Exam exam = new Exam();
            try {
                exam.setSubject_id(Integer.parseInt(request.getParameter("subject")));
                exam.setExam_name(request.getParameter("examName"));
                exam.setDuration_minutes(Integer.parseInt(request.getParameter("duration")));
                exam.setTotal_marks(Integer.parseInt(request.getParameter("totalMarks")));
                exam.setIs_active(true);
                exam.setCreated_by(request.getParameter(user.getUsername()));

                if (examDao.createdExam(exam)) {
                    request.setAttribute("message", "Exam created successfully");
                } else {
                    request.setAttribute("error", "Failed to create exam");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Invalid input format");
            }

            List<Subject> subjects = subjectDao.getAllSubject();
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("createExam.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SubjectDao subjectDao = new SubjectDaoImpl();
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");  // Ensure this is a User object
        if (user.getRole().equals("FACULTY")) {
            List<Subject> subjects = subjectDao.getAllSubject();
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("createExam.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
