package com.lti.appl.aseameet.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(scopeName="prototype")
@Entity
@Table(name = "RETAILER_T")
public class Retailer {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "R_ID")
	private int rId;

	@Column(name = "R_EMAIL")
	private String rEmail;

	@Column(name = "R_MOBILE")
	private long rMobile;

	@Column(name = "R_NAME")
	private String rName;

	@Column(name = "R_PASSWORD")
	private String rPassword;

	public Retailer() {

	}

	public Retailer(String rEmail, long rMobile, String rName, String rPassword) {
		super();
		this.rEmail = rEmail;
		this.rMobile = rMobile;
		this.rName = rName;
		this.rPassword = rPassword;
	}
	
	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrEmail() {
		return rEmail;
	}

	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}

	public long getrMobile() {
		return rMobile;
	}

	public void setrMobile(long rMobile) {
		this.rMobile = rMobile;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrPassword() {
		return rPassword;
	}

	public void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}


	@Override
	public String toString() {
		return "Retailer [rId=" + rId + ", rEmail=" + rEmail + ", rMobile=" + rMobile + ", rName=" + rName
				+ ", rPassword=" + rPassword + "]";
	}

	
}