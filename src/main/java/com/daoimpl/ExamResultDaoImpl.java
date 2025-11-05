package com.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ExamResultDao;
import com.pojo.ExamResult;

public class ExamResultDaoImpl implements ExamResultDao{
    Connection con=null;
     public ExamResultDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam_system","root","root");
		} catch (Exception e) {
			System.out.println("error int loading Driver and making connection");
		}
	}
	@Override
	public boolean saveExamResult(ExamResult r) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into exam_results values(?,?,?,?,?,?)");
			ps.setInt(1, r.getExam_id());
			ps.setInt(2, r.getUser_id());
			ps.setInt(3, r.getScore());
			ps.setInt(4, r.getTotal_questions());
			ps.setInt(5, r.getCorrect_answers());
			ps.setInt(6, r.getWrong_answers());
			
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
	public ExamResult getExamResult(int exam_id, int user_id) {
		ExamResult res=new ExamResult();
		try {
			PreparedStatement ps=con.prepareStatement("select*from exam_result where exam_id=? and user_id=?");
			ps.setInt(1, exam_id);
			ps.setInt(2, user_id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res.setResult_id(rs.getInt("result_id"));
				res.setExam_id(rs.getInt("exam_id"));
				res.setUser_id(rs.getInt("user_id"));
				res.setScore(rs.getInt("score"));
				res.setTotal_questions(rs.getInt("total_questios"));
				res.setCorrect_answers(rs.getInt("correct_answers"));
				res.setWrong_answers(rs.getInt("wrong_answers"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public List<ExamResult> getExamResultsByUser(int user_id) {
		List<ExamResult>lst=new ArrayList<ExamResult>();
		try {
			PreparedStatement ps =con.prepareStatement("select * from exam_results where user_id=?");
			ps.setInt(1, user_id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ExamResult res=new ExamResult();
				res.setResult_id(rs.getInt("result_id"));
				res.setExam_id(rs.getInt("exam_id"));
				res.setUser_id(rs.getInt("user_id"));
				res.setScore(rs.getInt("score"));
				res.setTotal_questions(rs.getInt("total_questions"));
				res.setCorrect_answers(rs.getInt("correct_answers"));
				res.setWrong_answers(rs.getInt("wrong_answers"));
			}
		} catch (Exception e) {
            lst.clear();
		}
		return lst;
	} 
		
	
}
