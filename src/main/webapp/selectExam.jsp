<%@page import="com.pojo.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.daoimpl.SubjectDaoImpl"%>
<%@page import="com.dao.SubjectDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Exam</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        .header { background-color: #333; color: white; padding: 10px 20px; }
        .container { padding: 20px; }
        .exam-form { max-width: 500px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        select, input { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        .btn { padding: 10px 15px; background-color: #5cb85c; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .btn:hover { background-color: #4cae4c; }
    </style>
</head>
<body>
    <div class="header">
        <h2>Online Exam System</h2>
    </div>
    
    <div class="container">
        <h2>Select Exam</h2>
        
        <div class="exam-form">
            <form action="TestServlet" method="get">
                <input type="hidden" name="action" value="start">
                
                <div class="form-group">
                    <label for="subject">Select Subject:</label>
                    <select id="subject" name="subject" onchange="loadExams(this.value)">
                        <option value="">-- Select Subject --</option>
                        <% 
                            SubjectDao subjectDao=new SubjectDaoImpl();
                            List<Subject>sub=subjectDao.getAllSubject();
                            for(Subject subject : sub) {
                        %>
                            <option value="<%= subject.getSubject_id() %>"><%= subject.getSubject_name() %></option>
                        <% } %>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="exam">Select Exam:</label>
                    <select id="exam" name="examId" disabled>
                        <option value="">-- Select Exam --</option>
                    </select>
                </div>
                
                <button type="submit" class="btn">Start Exam</button>
            </form>
        </div>
    </div>
    
    <script>
        function loadExams(subjectId) {
            if(subjectId) {
                fetch('ExamServlet?subjectId=' + subjectId)
                    .then(response => response.json())
                    .then(exams => {
                        const examSelect = document.getElementById('exam');
                        examSelect.innerHTML = '<option value="">-- Select Exam --</option>';
                        
                        exams.forEach(exam => {
                            const option = document.createElement('option');
                            option.value = exam.examId;
                            option.textContent = exam.examName;
                            examSelect.appendChild(option);
                        });
                        
                        examSelect.disabled = false;
                    });
            }
        }
    </script>
</body>
</html>