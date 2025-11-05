package com.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ExamDao;
import com.pojo.Exam;

public class ExamDaoImpl implements ExamDao{
    Connection con=null;
    
	public ExamDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam_system","root","root");
			
		} catch (Exception e) {
			System.out.println("Error in Driver loading");
		}
	}

	@Override
	public List<Exam> getExamsBySubject(int subject_id) {
		List<Exam> lst=new ArrayList<Exam>();
		try {
			PreparedStatement ps=con.prepareStatement("select*from exams where subject_id=?");
			ps.setInt(1, subject_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Exam e=new Exam();
				e.setExam_id(rs.getInt("exam_id"));;
				e.setSubject_id(rs.getInt("subject_id"));
				e.setExam_name(rs.getString("exam_name"));
				e.setDuration_minutes(rs.getInt("duration_minutes"));
				e.setTotal_marks(rs.getInt("total_marks"));
				e.setIs_active(rs.getBoolean("is_active"));
			    lst.add(e);	
			}
		} catch (Exception e) {
			lst.clear();
			return lst;
		}
		return lst;
	}

	@Override
	public Exam getExamById(int exam_id) {
		Exam e=new Exam();
		try {
			PreparedStatement ps=con.prepareStatement("select*from exams where exam_id=?");
			ps.setInt(1, exam_id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				e.setExam_id(rs.getInt("exam_id"));
				e.setSubject_id(rs.getInt("subject_id"));
				e.setExam_name(rs.getString("exam_name"));
				e.setDuration_minutes(rs.getInt("duration_minutes"));
				e.setTotal_marks(rs.getInt("total_marks"));
				e.setIs_active(rs.getBoolean("is_active"));
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;
	}

	@Override
	public boolean createdExam(Exam e) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into exams values(?,?,?,?,?,?)");
			ps.setInt(1, e.getSubject_id());
			ps.setString(2, e.getExam_name());
			ps.setInt(3, e.getDuration_minutes());
			ps.setInt(4, e.getTotal_marks());
			ps.setBoolean(5, e.getIs_active());
			ps.setString(6, e.getCreated_by());
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				b=true;
			}
			else
				b=false;
		} catch (Exception e2) {
			e2.printStackTrace();
			b=false;
		}
		return b;
	}

	@Override
	public boolean updatedExam(Exam e) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("update exams set exam_name=?, duration_minutes=? total_marks=? is_active=? where exam_id=?");
			ps.setString(1, e.getExam_name());
			ps.setInt(2, e.getDuration_minutes());
			ps.setInt(3, e.getTotal_marks());
			ps.setBoolean(4, e.getIs_active());
			ps.setInt(5, e.getExam_id());
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				b=true;
			}
		} catch (Exception e2) {
			b=false;
		}
		return b;
	}

	@Override
	public boolean deleteExam(int exam_id) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("delete from exams where exam_id=?");
			ps.setInt(1, exam_id);
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
