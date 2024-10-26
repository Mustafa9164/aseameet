package com.lti.appl.aseameet.service;

import java.util.List;

import com.lti.appl.aseameet.beans.Admin;
import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dto.RetailerSignUp;

public interface AdminService {
	public int loginadmin(String aEmail, String aPassword);
	public Admin findAdminById(int aId);
	public boolean getAdmin(Admin login);
	public Admin findAdminByEmail(String email);
	public List<Retailer> viewAllRetailers();
	public List<Retailer> deleteRetailer(int rId);
	public boolean addRetailer(RetailerSignUp retailer);
	public  List<Product> viewAllProducts();
}
