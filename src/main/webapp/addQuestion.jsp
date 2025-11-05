<%@page import="com.pojo.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.daoimpl.SubjectDaoImpl"%>
<%@page import="com.dao.SubjectDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Question</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        .header { background-color: #333; color: white; padding: 10px 20px; }
        .container { padding: 20px; max-width: 600px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], select, textarea { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        textarea { height: 100px; }
        .btn { padding: 10px 15px; background-color: #5cb85c; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .btn:hover { background-color: #4cae4c; }
        .message { color: green; margin-bottom: 15px; }
        .error { color: red; margin-bottom: 15px; }
    </style>
</head>
<body>
    <div class="header">
        <h2>Online Exam System</h2>
    </div>
    
    <div class="container">
        <h2>Add New Question</h2>
        
        <% if(request.getAttribute("message") != null) { %>
            <div class="message"><%= request.getAttribute("message") %></div>
        <% } %>
        
        <% if(request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <form action="QuestionServlet" method="post">
            <input type="hidden" name="action" value="add">
            
            <div class="form-group">
                <label for="subjectId">Subject:</label>
                <select id="subjectId" name="subjectId" required>
                    <option value="">-- Select Subject --</option>
                    <% 
                        SubjectDao subejcDao=new SubjectDaoImpl();
                        List<Subject> sub=subejcDao.getAllSubject();
                        for(Subject subject : sub) {
                    %>
                        <option value="<%= subject.getSubject_id() %>"><%= subject.getSubject_name() %></option>
                    <% } %>
                </select>
            </div>
            
            <div class="form-group">
                <label for="questionText">Question:</label>
                <textarea id="questionText" name="questionText" required></textarea>
            </div>
            
            <div class="form-group">
                <label for="option1">Option 1:</label>
                <input type="text" id="option1" name="option1" required>
            </div>
            
            <div class="form-group">
                <label for="option2">Option 2:</label>
                <input type="text" id="option2" name="option2" required>
            </div>
            
            <div class="form-group">
                <label for="option3">Option 3:</label>
                <input type="text" id="option3" name="option3" required>
            </div>
            
            <div class="form-group">
                <label for="option4">Option 4:</label>
                <input type="text" id="option4" name="option4" required>
            </div>
            
            <div class="form-group">
                <label for="correctOption">Correct Option:</label>
                <select id="correctOption" name="correctOption" required>
                    <option value="">-- Select Correct Option --</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                    <option value="4">Option 4</option>
                </select>
            </div>
            
            <button type="submit" class="btn">Add Question</button>
        </form>
    </div>
</body>
</html>