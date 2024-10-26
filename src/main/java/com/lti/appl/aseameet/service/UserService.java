package com.lti.appl.aseameet.service;

import java.util.List;

import com.lti.appl.aseameet.beans.User;

public interface UserService {
	
	public User addUser(User newUser);

	public boolean loginUser(User login);

	public User getuserById(int userId);

	public User getuserByEmail(String userEmail);
	
	public List<User> findshowAllUsers();

}