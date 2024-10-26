package com.lti.appl.aseameet.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_T")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_CONTACT")
	private long userContact;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

	public User(int userId, String userType, String userName, long userContact, String userEmail, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userContact = userContact;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userContact="
				+ userContact + ", userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}


	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private Set<ProductForApproval> products_f_a;

}
