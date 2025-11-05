<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        .header { background-color: #333; color: white; padding: 10px 20px; }
        .container { padding: 20px; max-width: 800px; margin: 0 auto; }
        .question { margin-bottom: 20px; }
        .options { margin-left: 20px; }
        .option { margin-bottom: 10px; }
        .progress { margin-bottom: 20px; }
        .btn { padding: 10px 15px; background-color: #5cb85c; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .btn:hover { background-color: #4cae4c; }
    </style>
</head>
<body>
    <div class="header">
        <h2>Online Exam System</h2>
    </div>
    
    <div class="container">
        <div class="progress">
            Question ${currentQuestion + 1} of ${questions.size()}
        </div>
        
        <form action="TestServlet" method="post">
            <div class="question">
                <h3>${questions[currentQuestion].questionText}</h3>
                
                <div class="options">
                    <div class="option">
                        <input type="radio" name="answer" id="option1" value="1">
                        <label for="option1">${questions[currentQuestion].option1}</label>
                    </div>
                    
                    <div class="option">
                        <input type="radio" name="answer" id="option2" value="2">
                        <label for="option2">${questions[currentQuestion].option2}</label>
                    </div>
                    
                    <div class="option">
                        <input type="radio" name="answer" id="option3" value="3">
                        <label for="option3">${questions[currentQuestion].option3}</label>
                    </div>
                    
                    <div class="option">
                        <input type="radio" name="answer" id="option4" value="4">
                        <label for="option4">${questions[currentQuestion].option4}</label>
                    </div>
                </div>
            </div>
            
            <button type="submit" class="btn">Next Question</button>
        </form>
    </div>
</body>
</html>