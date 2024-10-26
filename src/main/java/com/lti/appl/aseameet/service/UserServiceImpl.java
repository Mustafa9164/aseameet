package com.lti.appl.aseameet.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.appl.aseameet.beans.User;
import com.lti.appl.aseameet.dao.UserDao;

@Service("userservice")
@Scope(scopeName = "singleton")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;
	
	public int adduser(User newuser) {
		int id = 0;
		try {
			User user = this.userdao.getuserByEmail(newuser.getUserEmail());
			if (user == null) {
				userdao.adduser(newuser);
			}
		} catch (NullPointerException e) {
			System.out.println("100");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			userdao.adduser(newuser);
		}
		return id;
	}
	
	@Override
	@Transactional
	public User addUser(User newUser) {
		return userdao.adduser(newUser);
	}

	@Override
	public boolean loginUser(User login) {
		userdao.loginUser(login);
		return true;
	}

	@Override
	public User getuserById(int userId) {
		return userdao.getuserById(userId);
	}

	@Override
	public User getuserByEmail(String userEmail) {
		return userdao.getuserByEmail(userEmail);
	}

	@Override
	public List<User> findshowAllUsers() {
		return userdao.showAllUsers();
	}

	

}