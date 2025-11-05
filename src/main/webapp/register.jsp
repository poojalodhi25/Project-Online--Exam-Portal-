<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Exam System - Register</title>
<style>
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

.register-container {
	background: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
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
	margin-bottom: 5px;
}

input[type="text"], input[type="password"], input[type="email"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #ddd;
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
	font-size:20px;
	background-color: blue;
	font-family: Georgia, 'Times New Roman', Times, serif;
	border: none;
	color: white;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #3D90D7;
}

.error {
	color: red;
	text-align: center;
	margin-bottom: 10px;
}

.login-link {
	text-align: center;
	margin-top: 15px;
}
</style>
</head>
<body>
	<div class="register-container">
		<h2>Register</h2>

		<%
		if (request.getAttribute("error") != null) {
		%>
		<div class="error"><%=request.getAttribute("error")%></div>
		<%
		}
		%>

		<form action="RegisterServlet" method="post">
			<div class="form-group">
				<label for="fullname">Full Name:</label> <input type="text"
					id="fullname" name="fullname" required>
			</div>

			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" required>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required>
			</div>

			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>

			<div class="radio-group">
				<label><input type="radio" name="role" value="STUDENT"
					checked> Student</label>
			</div>

			<button type="submit">Register</button>
		</form>

		<div class="login-link">
			Already have an account? <a href="login.jsp">Login here</a>
		</div>
	</div>
</body>
</html>