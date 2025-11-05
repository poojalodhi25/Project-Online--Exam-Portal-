<%@page import="com.pojo.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.daoimpl.QuestionDaoImpl"%>
<%@page import="com.dao.QuestionDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Questions</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        .header { background-color: #333; color: white; padding: 10px 20px; }
        .container { padding: 20px; }
        .question-list { margin-top: 20px; }
        .question-item { background: #fff; border-radius: 5px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); padding: 20px; margin-bottom: 20px; }
        .question-text { font-weight: bold; margin-bottom: 10px; }
        .options { margin-left: 20px; }
        .option { margin-bottom: 5px; }
        .correct { color: green; font-weight: bold; }
        .actions { margin-top: 10px; }
        .btn { padding: 5px 10px; text-decoration: none; border-radius: 4px; }
        .edit-btn { background-color: #f0ad4e; color: white; }
        .edit-btn:hover { background-color: #ec971f; }
        .delete-btn { background-color: #d9534f; color: white; }
        .delete-btn:hover { background-color: #c9302c; }
        .back-btn { display: inline-block; margin-top: 20px; padding: 10px 15px; background-color: #5cb85c; color: white; text-decoration: none; border-radius: 4px; }
        .back-btn:hover { background-color: #4cae4c; }
    </style>
</head>
<body>
    <div class="header">
        <h2>Online Exam System</h2>
    </div>
    
    <div class="container">
        <h2>Manage Questions</h2>
        
        <div class="question-list">
            <% 
                int subjectId = Integer.parseInt(request.getAttribute("subjectId").toString());
                 QuestionDao questionDao=new QuestionDaoImpl();
                List<Question> questions = questionDao.getQuestionsBySubject(subjectId);
                
                for(Question question : questions) {
            %>
                <div class="question-item">
                    <div class="question-text"><%= question.getQue_text() %></div>
                    
                    <div class="options">
                        <div class="option <%= question.getCorrect_option() == 1 ? "correct" : "" %>">
                            1. <%= question.getOption1() %>
                        </div>
                        <div class="option <%= question.getCorrect_option() == 2 ? "correct" : "" %>">
                            2. <%= question.getOption2() %>
                        </div>
                        <div class="option <%= question.getCorrect_option() == 3 ? "correct" : "" %>">
                            3. <%= question.getOption3() %>
                        </div>
                        <div class="option <%= question.getCorrect_option() == 4 ? "correct" : "" %>">
                            4. <%= question.getOption4() %>
                        </div>
                    </div>
                    
                    <div class="actions">
                        <a href="editQuestion.jsp?questionId=<%= question.getQue_id() %>" class="btn edit-btn">Edit</a>
                        <a href="DeleteQuestionServlet?questionId=<%= question.getQue_id() %>" class="btn delete-btn">Delete</a>
                    </div>
                </div>
            <% } %>
        </div>
        
        <a href="FacultyHome.jsp" class="back-btn">Back to Dashboard</a>
    </div>
</body>
</html>