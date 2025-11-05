package com.pojo;

public class Exam {
   private int exam_id;
   private int subject_id;
   private String exam_name;
   private int duration_minutes;
   private int total_marks;
   private boolean is_active;
   private String created_by;
public Exam() {
	super();
	// TODO Auto-generated constructor stub
}
public Exam(int exam_id, int subject_id, String exam_name, int duration_minutes, int total_marks, boolean is_active,
		String created_by) {
	super();
	this.exam_id = exam_id;
	this.subject_id = subject_id;
	this.exam_name = exam_name;
	this.duration_minutes = duration_minutes;
	this.total_marks = total_marks;
	this.is_active = is_active;
	this.created_by = created_by;
}
public int getExam_id() {
	return exam_id;
}
public void setExam_id(int exam_id) {
	this.exam_id = exam_id;
}
public int getSubject_id() {
	return subject_id;
}
public void setSubject_id(int subject_id) {
	this.subject_id = subject_id;
}
public String getExam_name() {
	return exam_name;
}
public void setExam_name(String exam_name) {
	this.exam_name = exam_name;
}
public int getDuration_minutes() {
	return duration_minutes;
}
public void setDuration_minutes(int duration_minutes) {
	this.duration_minutes = duration_minutes;
}
public int getTotal_marks() {
	return total_marks;
}
public void setTotal_marks(int total_marks) {
	this.total_marks = total_marks;
}
public boolean getIs_active() {
	return is_active;
}
public void setIs_active(boolean is_active) {
	this.is_active = is_active;
}
public String getCreated_by() {
	return created_by;
}
public void setCreated_by(String string) {
	this.created_by = string;
}
   
   
}
