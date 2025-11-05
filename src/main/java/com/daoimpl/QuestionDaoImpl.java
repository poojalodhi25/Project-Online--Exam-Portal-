package com.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.QuestionDao;
import com.pojo.Question;

public class QuestionDaoImpl implements QuestionDao{
       Connection con=null;

	public QuestionDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam_system","root","root");
		} catch (Exception e) {
			System.out.println("Error int Driver loading and making connection");
		}
	}

	@Override
	public List<Question> getQuestionsBySubject(int subject_id) {
		 List<Question>lst=new ArrayList<Question>();
		try {
			PreparedStatement ps=con.prepareStatement("select*from questions where subject_id=?");
			ps.setInt(1, subject_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Question q=new Question();
				q.setQue_id(rs.getInt("que_id"));
				q.setSubject_id(rs.getInt("subject_id"));
				q.setQue_text(rs.getString(" que_text "));
				q.setOption1(rs.getString("option1"));
				q.setOption2(rs.getString("option2"));
				q.setOption3(rs.getString("option3"));
				q.setOption4(rs.getString("option4"));
				q.setCorrect_option(rs.getInt("correct_option"));
				lst.add(q);
			}
		} catch (Exception e) {
			lst.clear();
			return lst;
		}
		return lst;
	}

	@Override
	public Question getQuestionById(int que_id) {
		Question q=new Question();
		try {
			PreparedStatement ps=con.prepareStatement("select*from question where que_id=?");
			ps.setInt(1, que_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				q.setQue_id(rs.getInt("que_id"));
				q.setSubject_id(rs.getInt("subject_id"));
				q.setQue_text(rs.getString("que_text"));
				q.setOption1(rs.getString("option1"));
				q.setOption2(rs.getString("option2"));
				q.setOption3(rs.getString("option3"));
				q.setOption4(rs.getString("option4"));
				q.setCorrect_option(rs.getInt("correct_option"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return q;
	}

	@Override
	public boolean addQuetion(Question q) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into quetions values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, q.getSubject_id());
			ps.setString(2, q.getQue_text());
			ps.setString(3, q.getOption1());
			ps.setString(4, q.getOption2());
			ps.setString(5, q.getOption3());
			ps.setString(6, q.getOption4());
			ps.setInt(7, q.getCorrect_option());
			ps.setString(8, q.getCreated_by());
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateQuestion(Question q) {
		boolean b=false;
		try {
			PreparedStatement ps =con.prepareStatement("update questions set que_text=?,option1=?, option2=?, option3=?, option4=?, correct_option=? where que_id=?");
			
			ps.setString(1, q.getQue_text());
			ps.setString(2, q.getOption1());
			ps.setString(3, q.getOption2());
			ps.setString(4, q.getOption3());
			ps.setString(5, q.getOption4());
			ps.setInt(6, q.getCorrect_option());
			ps.setString(7, q.getCreated_by());
			
			int x=ps.executeUpdate();
			if(x>0) {
				b=true;
			}
			
		} catch (Exception e) {
			b=false;
		}
		return b;
	}

	@Override
	public boolean deleteQuestion(int que_id) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("delete from questions where que_id=?" );
			ps.setInt(1, que_id);
			int x=ps.executeUpdate();
			if(x>0)
			{
				b=true;
			}
		} catch (Exception e) {
			b=false;
		}
		return b;
	}
       
}
