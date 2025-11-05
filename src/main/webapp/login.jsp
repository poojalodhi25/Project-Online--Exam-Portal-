<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Exam System - Login</title>
    <style>
       /* login.css */
body {
    font-family: Georgia, 'Times New Roman', Times, serif;
    background-color: #7AC6D2;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-container {
    background: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    width: 320px;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 6px;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

.radio-group {
    display: flex;
    justify-content: space-around;
    margin: 15px 0;
}

button {
    width: 100%;
    padding: 10px;
    font-size: 18px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    background-color: #005bbb;
    border: none;
    color: white;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #004199;
}

.error {
    color: red;
    text-align: center;
    margin-bottom: 10px;
}

.success {
    color: green;
    text-align: center;
    margin-bottom: 10px;
}

.register-link {
    text-align: center;
    margin-top: 15px;
}

    </style>
</head>
<body>
    <div class="login-container">
        <h2>Online Exam System</h2>
        
        <% if(request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <% if(request.getAttribute("message") != null) { %>
            <div class="success"><%= request.getAttribute("message") %></div>
        <% } %>
        
        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="radio-group">
                <label><input type="radio" name="role" value="STUDENT" checked> Student</label>
                <label><input type="radio" name="role" value="FACULTY"> Faculty</label>
            </div>
            
            <button type="submit">Login</button>
        </form>
        
        <div class="register-link">
            Don't have an account? <a href="register.jsp">Register here</a>
        </div>
    </div>
</body>
</html>