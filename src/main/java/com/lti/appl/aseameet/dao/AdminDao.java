package com.lti.appl.aseameet.dao;

import java.util.List;

import com.lti.appl.aseameet.beans.Admin;
import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;

public interface AdminDao {
	public Admin getAdminById(int aId);//return Retailer
	public boolean getAdmin(Admin login);//return rId
	public Admin getAdminByEmail(String email);
	public List<Retailer> getAllRetailers();
	public List<Retailer> removeRetailer(int rId);
	public boolean addRetailer(Retailer newRetailer);
	public List<Product> getAllProducts();
}
