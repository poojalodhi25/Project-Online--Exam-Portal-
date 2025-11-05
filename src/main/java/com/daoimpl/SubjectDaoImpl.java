package com.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.SubjectDao;
import com.pojo.Subject;

public class SubjectDaoImpl implements SubjectDao {
     Connection con=null;
     
	public SubjectDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam_system","root","root");
		} catch (Exception e) {
			System.out.println("Error in Driver loading");
		}
	}

	@Override
	public List<Subject> getAllSubject() {
		List<Subject>lst=new ArrayList<Subject>();
		try {
			PreparedStatement ps=con.prepareStatement("select*from subjects");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Subject s=new Subject();
				s.setSubject_id(rs.getInt("subject_id"));
				s.setSubject_name(rs.getString("subject_name"));
				s.setDescription(rs.getString("description"));
				lst.add(s);
			}
		} catch (Exception e) {
			lst.clear();
			return lst;
		}
		return lst;
	}

	@Override
	public Subject getSubjectById(int subject_id){
		Subject s=new Subject();
		try {
			PreparedStatement ps=con.prepareStatement("select * from subjects where subject_id=?");
			ps.setInt(1, subject_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				s.setSubject_id(subject_id);
				s.setSubject_name(rs.getString("subject_name"));
				s.setDescription(rs.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return s;
	}

	@Override
	public boolean add_Subject(Subject s) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into subjects values(?,?)");
			ps.setString(1, s.getSubject_name());
			ps.setString(2, s.getDescription());
			
			int x=ps.executeUpdate();
			if(x>0) {
				b=true;
			}
			else {
				b=false;
			}
		} catch (Exception e) {
			b=false;
		}
		return b;
	}

	
   
    
}
