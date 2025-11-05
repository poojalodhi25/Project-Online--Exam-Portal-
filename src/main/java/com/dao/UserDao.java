package com.dao;

import com.pojo.User;

public interface UserDao {
	   boolean registerUser(User user);
	    User getUserByUsername(String username);
	    boolean validateUser(String username, String password);
}
