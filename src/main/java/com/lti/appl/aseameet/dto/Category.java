package com.lti.appl.aseameet.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class Category {
	
	@Id
	@Column(name="CAT_ID")
	private String catId;
	
	@Column(name="CAT_NAME")
	private String catName;
	

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}


	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + "]";
	}
	
	
	

}
