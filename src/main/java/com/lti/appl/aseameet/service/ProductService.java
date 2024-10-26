package com.lti.appl.aseameet.service;
import java.util.List;

import com.lti.appl.aseameet.beans.Product;



public interface ProductService {
	
	public void addProduct(Product product);
	
	public void removeProduct(String prodId);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String prodId);
	
	public Product getProductByName(String prodName);


}
