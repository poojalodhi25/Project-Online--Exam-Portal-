package com.pojo;

public class Question {
     private int que_id;
     private int subject_id;
     private String  que_text;
     private String option1;
     private String option2;
     private String option3;
     private String option4;
     private int correct_option;
     private String created_by;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int que_id, int subject_id, String que_text, String option1, String option2, String option3,
			String option4, int correct_option, String created_by) {
		super();
		this.que_id = que_id;
		this.subject_id = subject_id;
		this.que_text = que_text;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correct_option = correct_option;
		this.created_by = created_by;
	}
	public int getQue_id() {
		return que_id;
	}
	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getQue_text() {
		return que_text;
	}
	public void setQue_text(String string) {
		this.que_text = string;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public int getCorrect_option() {
		return correct_option;
	}
	public void setCorrect_option(int correct_option) {
		this.correct_option = correct_option;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String string) {
		this.created_by = string;
	}
     
     
}
