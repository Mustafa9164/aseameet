package com.lti.appl.aseameet.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.aseameet.beans.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED)
	public int addUser(User newUser) {
		User User = new User();
		User.setUserName(newUser.getUserName());
		User.setUserContact(newUser.getUserContact());
		User.setUserEmail(newUser.getUserEmail());
		User.setUserPassword(newUser.getUserPassword());
		String q1 = "select max(u.userId) from User u";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number id = (Number) query1.getSingleResult();
		int userId = id.intValue() + 1;
		User.setUserId(userId);
		this.entityManager.persist(User);
		return userId;
	}

	@Override
	@Transactional
	public User adduser(User newuser) {
		entityManager.persist(newuser);
		return newuser;
	}

	@Override
	public User getuserById(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public User getuserByEmail(String userEmail) {
		return entityManager.find(User.class, userEmail);
	}

	@Override
	public List<User> showAllUsers() {
		return showAllUsers();
	}

	@Override
	public boolean loginUser(User login) {
		System.out.println(login.toString());
		String userEmail = login.getUserEmail();
		String userPassword = login.getUserPassword();
		
		TypedQuery<User> qryt= entityManager.createQuery("select u from User u", User.class);
		List<User> u= qryt.getResultList();
		
		for(User u1:u) {
			if(u1.getUserEmail()==userEmail && u1.getUserPassword()==userPassword) {
				System.out.println(u1.getUserEmail()+" "+u1.getUserPassword());
				return true;
			}
		}
		return false;
	}

}

