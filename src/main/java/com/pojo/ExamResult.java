package com.pojo;

public class ExamResult {
    private int result_id;
    private int exam_id;
    private int user_id;
    private int score;
    private int total_questions;
    private int correct_answers;
    private int wrong_answers;
	public ExamResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamResult(int result_id, int exam_id, int user_id, int score, int total_questions, int correct_answers,
			int wrong_answers) {
		super();
		this.result_id = result_id;
		this.exam_id = exam_id;
		this.user_id = user_id;
		this.score = score;
		this.total_questions = total_questions;
		this.correct_answers = correct_answers;
		this.wrong_answers = wrong_answers;
	}
	public int getResult_id() {
		return result_id;
	}
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotal_questions() {
		return total_questions;
	}
	public void setTotal_questions(int total_questions) {
		this.total_questions = total_questions;
	}
	public int getCorrect_answers() {
		return correct_answers;
	}
	public void setCorrect_answers(int correct_answers) {
		this.correct_answers = correct_answers;
	}
	public int getWrong_answers() {
		return wrong_answers;
	}
	public void setWrong_answers(int wrong_answers) {
		this.wrong_answers = wrong_answers;
	} 
    
    
}
