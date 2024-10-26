package com.lti.appl.aseameet.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lti.appl.aseameet.dto.Category;


@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PROD_ID")
	private int prodId;
	
	@Column(name="PROD_NAME")
	private String prodName;
	
	@Column(name="PROD_PRICE")
	private double prodPrice;
	
	@Column(name="PROD_RATINGS")
	private float ratings;
	
	@Column(name="PROD_DESC")
	private String prodDesc;
	
	@Column(name="PROD_Stack")
	private int prodStack;
	
	@Column(name="PROD_Image")
	private String prodImage;
	
	public int getProdStack() {
		return prodStack;
	}

	public void setProdStack(int prodStack) {
		this.prodStack = prodStack;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	@ManyToOne
	@JoinColumn(name="CAT_ID")
	private Category category;
	
	public int getProdId() {
		return prodId;
	}
	
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	public String getProdName() {
		return prodName;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public double getProdPrice() {
		return prodPrice;
	}
	
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	public float getRatings() {
		return ratings;
	}
	
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", ratings="
				+ ratings + ", prodDesc=" + prodDesc + ", prodStack=" + prodStack + ", prodImage=" + prodImage
				+ ", category=" + category + "]";
	}

	
	
}