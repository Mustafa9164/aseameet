package com.lti.appl.aseameet.uicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dto.Login;
import com.lti.appl.aseameet.dto.RetailerSignUp;
import com.lti.appl.aseameet.service.RetailerService;

@RestController
@CrossOrigin("*")
@RequestMapping(path ="retailer")

public class RetailerController {
	
	@Autowired
	private RetailerService retailerservice;
	
	@PostMapping(path = "/retailerlogin")
	public int retailerlogin(@RequestBody Login login) {
		System.out.println("login succesfull");
		return this.retailerservice.loginRetailer(login.getEmail(), login.getPassword());

	}
	
	@GetMapping(path="/getRetailer/{rId}")
	public Retailer getRetailerById(@PathVariable("rId") int rId) {
		return retailerservice.findgetRetailerById(rId);
	}
	
	@PostMapping(path = "/addNewRetailer")
	public int addNewRetailer(@RequestBody RetailerSignUp newRetailer)
	{
		return this.retailerservice.addRetailer(newRetailer);
	}
	
	@PutMapping(path = "/updateProduct")
	public boolean updateProduct(@RequestBody Product update)
	{
		return retailerservice.updateProduct(update);
	}
	
	@GetMapping(path = "/deleteProduct/{pId}")
	public List<Product> deleteProduct(@PathVariable("pId") int pId){
		List<Product> dto=retailerservice.removeProduct(pId);
		return dto;
	}
	
		
}
