package com.lti.appl.aseameet.service;

import java.util.List;

import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dto.RetailerSignUp;

public interface RetailerService {
	public int loginRetailer(String rEmail, String rPassword); //throws CustomerException;
	public int addRetailer(RetailerSignUp newRetailer);
	public Retailer findgetRetailerById(int rId);//return Retailer
	public int findgetRetailerByEmailAndPassword(String email,String password);//return rId
	public Retailer findgetRetailerByEmail(String email);//return Retailer
	public List<Retailer> findshowAllRetailers();
	public boolean updateProduct(Product update);
	public List<Product> removeProduct(int pId);
}
