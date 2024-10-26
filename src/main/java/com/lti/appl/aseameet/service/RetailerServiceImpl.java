package com.lti.appl.aseameet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dao.RetailerDao;
import com.lti.appl.aseameet.dto.RetailerSignUp;
@Service("retailerservice")
@Scope(scopeName="singleton")
public class RetailerServiceImpl implements RetailerService{
	@Autowired
	private RetailerDao retailerdao;
	
	@Override
	public int loginRetailer(String rEmail, String rPassword) {
		return this.retailerdao.getRetailerByEmailAndPassword(rEmail, rPassword);
	}

	@Override
	public int addRetailer(RetailerSignUp newRetailer) {
		int id = 0;
		try
		{
			Retailer retailer = this.retailerdao.getRetailerByEmail(newRetailer.getrEmail());
			if(retailer==null) {
				id = this.retailerdao.addRetailer(newRetailer);
			}
		}
		catch(NullPointerException e)
		{
			return -100;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			id = this.retailerdao.addRetailer(newRetailer);
		}
		return id;
	}
	
	@Override
	public Retailer findgetRetailerById(int rId) {
		return retailerdao.getRetailerById(rId);
	}

	@Override
	public int findgetRetailerByEmailAndPassword(String email, String password) {
		return retailerdao.getRetailerByEmailAndPassword(email, password);
	}

	@Override
	public Retailer findgetRetailerByEmail(String email) {
		return retailerdao.getRetailerByEmail(email);
	}

	@Override
	public List<Retailer> findshowAllRetailers() {
		return retailerdao.showAllRetailers();
	}
	

	@Override
	public boolean updateProduct(Product update) {
		
		return retailerdao.updateProduct(update);
	}

	@Override
	public List<Product> removeProduct(int pId) {
			return retailerdao.removeProduct(pId);
	}
}
