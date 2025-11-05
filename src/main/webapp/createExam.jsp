<%@page import="java.util.List"%>
<%@page import="com.pojo.Subject"%>
<%@page import="com.daoimpl.SubjectDaoImpl"%>
<%@page import="com.dao.SubjectDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Exam</title>
    <style>
       body {
    font-family: Georgia, 'Times New Roman', Times, serif;
    background-color: #7AC6D2;
    margin: 0;
    padding: 0;
}

.header {
    background-color: #005bbb;
    color: white;
    padding: 15px 30px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header h2 {
    margin: 0;
}

.user-info {
    font-size: 16px;
}

.logout-link {
    color: white;
    margin-left: 20px;
    text-decoration: underline;
}

.container {
    max-width: 600px;
    margin: 40px auto;
    padding: 40px;
    background: #ffffff;
    border-radius: 10px;
    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
}

.welcome {
    text-align: center;
    font-size: 24px;
    margin-bottom: 30px;
    color: #003366;
}

.form-group {
    margin-bottom: 20px;
}

label {
    font-weight: bold;
    display: block;
    margin-bottom: 8px;
}

input[type="text"], input[type="number"], select {
    width: 100%;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

.btn {
    display: block;
    width: 100%;
    padding: 12px;
    font-size: 16px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    background-color: #005bbb;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 10px;
}

.btn:hover {
    background-color: #004199;
}

.message {
    color: green;
    margin-bottom: 15px;
    text-align: center;
}

.error {
    color: red;
    margin-bottom: 15px;
    text-align: center;
}

    </style>
</head>
<body>
    <div class="header">
        <h2>Online Exam System</h2>
    </div>
    
    <div class="container">
        <h2>Create New Exam</h2>
        
        <% if(request.getAttribute("message") != null) { %>
            <div class="message"><%= request.getAttribute("message") %></div>
        <% } %>
        
        <% if(request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <form action="ExamServlet" method="post">
            <div class="form-group">
                <label for="subject">Subject:</label>
                <select id="subject" name="subject" required>
                    <option value="">-- Select Subject --</option>
                    <% 
                       SubjectDao subjectDao = new  SubjectDaoImpl();
                        List<Subject> subjects = subjectDao.getAllSubject();
                        for(Subject subject : subjects) {
                    %>
                        <option value="<%= subject.getSubject_id() %>"><%= subject.getSubject_name() %></option>
                    <% } %>
                </select>
            </div>
            
            <div class="form-group">
                <label for="examName">Exam Name:</label>
                <input type="text" id="examName" name="examName" required>
            </div>
            
            <div class="form-group">
                <label for="duration">Duration (minutes):</label>
                <input type="number" id="duration" name="duration" min="1" required>
            </div>
            
            <div class="form-group">
                <label for="totalMarks">Total Marks:</label>
                <input type="number" id="totalMarks" name="totalMarks" min="1" required>
            </div>
            
            <button type="submit" class="btn">Create Exam</button>
            <a href="FacultyHome.jsp">Back to Home Page</a>
        </form>
    </div>
</body>
</html>