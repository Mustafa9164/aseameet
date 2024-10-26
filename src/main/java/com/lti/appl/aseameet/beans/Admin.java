package com.lti.appl.aseameet.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "Admin_t")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Admin {

	@Id
	@Column(name = "A_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	@Column(name = "A_NAME")
	private String aName;
	@Column(name = "A_EMAIL")
	private String aEmail;
	@Column(name = "A_PASSWORD")
	private String aPassword;

	public Admin() {
	}

	public Admin(String aName, String aEmail, String aPassword) {
		super();
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPassword = aPassword;
	}
	
	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}


	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aEmail=" + aEmail + ", aPassword=" + aPassword + "]";
	}

}