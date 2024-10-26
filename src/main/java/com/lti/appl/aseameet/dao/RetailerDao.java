package com.lti.appl.aseameet.dao;

import java.util.List;

import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dto.RetailerSignUp;

public interface RetailerDao {
	public Retailer getRetailerById(int rId);
	public int addRetailer(RetailerSignUp newRetailer);
	public int getRetailerByEmailAndPassword(String email,String password);
	public Retailer getRetailerByEmail(String email);
	public List<Retailer> showAllRetailers();
	public boolean updateProduct(Product update);
	public List<Product> removeProduct(int pId);
	public List<Product> getAllProducts();
}
