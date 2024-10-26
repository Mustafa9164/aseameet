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

import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.service.ProductServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	@GetMapping("/allproducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@PostMapping(path="/addProduct", produces="appliation/json")
	public void addProduct(@RequestBody Product product)
	{
		System.out.println("Adding the Product" + product);
		productService.addProduct(product);
	}
	
	@GetMapping(path="/allproducts/{prodId}", produces="application/json")
	public Product getProductById(@PathVariable (value="prodId") String prodId) 
	{
		return productService.getProductById(prodId);
		
	}
	
	@GetMapping(path="/allproducts/prodName/{prodName}", produces="application/json")
	public Product getProductByName(@PathVariable (value="prodName") String prodName) 
	{
		return productService.getProductByName(prodName);
		
	}

}