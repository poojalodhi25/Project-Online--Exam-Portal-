<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam Result</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        .header { background-color: #333; color: white; padding: 10px 20px; }
        .container { padding: 20px; max-width: 800px; margin: 0 auto; }
        .result-card { background: #fff; border-radius: 5px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); padding: 20px; margin-bottom: 20px; }
        .result-item { margin-bottom: 10px; }
        .btn { display: inline-block; padding: 10px 15px; background-color: #5cb85c; color: white; text-decoration: none; border-radius: 4px; }
        .btn:hover { background-color: #4cae4c; }
    </style>
</head>
<body>
    <div class="header">
        <h2>Online Exam System</h2>
    </div>
    
    <div class="container">
        <h2>Exam Result</h2>
        
        <div class="result-card">
            <h3>${exam.examName}</h3>
            
            <div class="result-item">
                <strong>Score:</strong> ${score} out of ${exam.totalMarks}
            </div>
            
            <div class="result-item">
                <strong>Correct Answers:</strong> ${correctAnswers}
            </div>
            
            <div class="result-item">
                <strong>Wrong Answers:</strong> ${wrongAnswers}
            </div>
            
            <div class="result-item">
                <strong>Percentage:</strong> ${(score/exam.totalMarks)*100}%
            </div>
        </div>
        
        <a href="student/home.jsp" class="btn">Back to Dashboard</a>
    </div>
</body>
</html>