package com.lti.appl.aseameet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.appl.aseameet.beans.Admin;
import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dao.AdminDao;
import com.lti.appl.aseameet.dao.RetailerDao;
import com.lti.appl.aseameet.dto.RetailerSignUp;
@Service("adminservice")
@Scope(scopeName="singleton")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private RetailerDao retailerdao;
	
	@Override
	public Admin findAdminById(int aId) {
		return admindao.getAdminById(aId);
	}

	@Override
	public Admin findAdminByEmail(String email) {
		return admindao.getAdminByEmail(email);
	}

	@Override
	public List<Retailer> viewAllRetailers() {
		return admindao.getAllRetailers();
	}

	@Override
	public List<Retailer> deleteRetailer(int rId) {
		return admindao.removeRetailer(rId);
	}

	@Override
	public boolean addRetailer(RetailerSignUp retailer) {
		Retailer newRetailer=retailerdao.getRetailerByEmail(retailer.getrEmail());
		if(newRetailer!=null)
		return false;
		newRetailer=new Retailer();
		newRetailer.setrName(retailer.getrName());
		newRetailer.setrEmail(retailer.getrEmail());
		newRetailer.setrMobile(retailer.getrMobile());
		String password=retailer.getrName().substring(0,4)+"@"+"12345";
		newRetailer.setrPassword(password);
		return admindao.addRetailer(newRetailer);
	}

	@Override
	public int loginadmin(String aEmail, String aPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAdmin(Admin login) {
		admindao.getAdmin(login);
		return true;
	}

	@Override
	public List<Product> viewAllProducts() {
		return admindao.getAllProducts();
	}

	

}
