<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
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
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 40px 20px;
}

.welcome {
    font-size: 26px;
    margin-bottom: 30px;
    color: #003366;
}

.card {
    background: #fff;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
    width: 350px;
    margin-bottom: 25px;
    text-align: center;
}

.card h3 {
    margin-top: 0;
    color: #005bbb;
}

.card p {
    color: #555;
}

.btn {
    display: inline-block;
    margin-top: 15px;
    padding: 10px 20px;
    font-size: 18px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    background-color: #005bbb;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s;
}

.btn:hover {
    background-color: #004199;
}

    </style>
</head>
<body>
    <div class="header">
        <h2>Online Exam System</h2>
        <div>
             Welcome, <%
             String username=(String) session.getAttribute("user");
             if(username!=null)
            	 out.print(username);
             %>
            <a href="logout.jsp" style="color: white; margin-left: 15px;">Logout</a>
        </div>
    </div>
    
    <div class="container">
        <div class="welcome">Welcome to Student Dashboard</div>
        
        <div class="card">
            <h3>Take an Exam</h3>
            <p>Select a subject and start your exam</p>
            <a href="TestServlet?action=select" class="btn">Start Exam</a>
        </div>
        
        <div class="card">
            <h3>View Results</h3>
            <p>Check your previous exam results</p>
            <a href="student/results.jsp" class="btn">View Results</a>
        </div>
    </div>
</body>
</html>