package com.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.UserDao;
import com.pojo.User;

public class UserDaoImpl implements UserDao {

    private Connection con;

    public UserDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/online_exam_system", "root", "root"
            );
        } catch (Exception e) {
            System.out.println("Error loading driver or connecting to database: " + e.getMessage());
        }
    }

    @Override
    public boolean registerUser(User user) {
        boolean isRegistered = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username, password, email, full_name, role) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setString(1, user.getUsername().trim());
            ps.setString(2, user.getPassword().trim());
            ps.setString(3, user.getEmail().trim());
            ps.setString(4, user.getFullname().trim());
            ps.setString(5, user.getRole().trim());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                isRegistered = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRegistered;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE TRIM(username) = ?"
            );
            ps.setString(1, username.trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("full_name"));  // Corrected here
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean validateUser(String username, String password) {
        boolean isValid = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE TRIM(username) = ? AND TRIM(password) = ?"
            );
            ps.setString(1, username.trim());
            ps.setString(2, password.trim());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
