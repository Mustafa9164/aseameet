package com.lti.appl.aseameet.uicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.aseameet.beans.Admin;
import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dto.RetailerSignUp;
import com.lti.appl.aseameet.service.AdminService;
import com.lti.appl.aseameet.service.RetailerService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/admin")

public class AdminController {

	@Autowired
	private AdminService adminservice;
	@Autowired
	private RetailerService retailerservice;

	@PostMapping(path = "/adminlogin" ,produces="application/json")
	public boolean getAdmin(@RequestBody Admin login) {
		System.out.println("login");
		return adminservice.getAdmin(login);
	}

	@PostMapping(path = "/addNewRetailer")
	public int addNewRetailer(@RequestBody RetailerSignUp newRetailer) {
		return this.retailerservice.addRetailer(newRetailer);
	}
	
	@GetMapping(path="/getAdmin/{aId}")
	public Admin getAdminById(@PathVariable("aId") int aId) {
		System.out.println(aId);
		return adminservice.findAdminById(aId);
	}
	
	@GetMapping(path = "getAllRetailers")
	public List<Retailer> getAllRetailers(){
		List<Retailer> dto=adminservice.viewAllRetailers();
		return dto;
	}
	@GetMapping(path = "deleteRetailer/{rId}")
	public List<Retailer> deleteRetailer(@PathVariable("rId") int rId){
		List<Retailer> dto=adminservice.deleteRetailer(rId);
		return dto;
	}
	@PostMapping(path = "addRetailer/{aId}")
	public boolean addRetailer(@PathVariable("aId") int aId,@RequestBody RetailerSignUp retailer){
		return adminservice.addRetailer(retailer);
	}
	
	@GetMapping(path = "getAllProducts")
	public List<Product> getAllProducts(){
		List<Product> dto=adminservice.viewAllProducts();
		return dto;
	}
	
}
