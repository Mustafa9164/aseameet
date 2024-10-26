package com.lti.appl.aseameet.dao;


import java.util.List;
//import com.lti.appl.Aseameet.beans.Product;

import com.lti.appl.aseameet.beans.User;

public interface UserDao {
	
	public User adduser(User newuser);
	
	public User getuserById(int userId);
	
	public User getuserByEmail(String userEmail);
    
	public List<User> showAllUsers();

	public boolean loginUser(User login);

			
    
}
