package com.lti.appl.aseameet.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.dao.ProductDao;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao dao;
	
	public ProductDao getDao() {
		return dao;
	}

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Override
	public void addProduct(Product product) {
		dao.addProduct(product);
		
	}

	@Override
	public void removeProduct(String prodId) {
		dao.removeProduct(prodId);
		
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> prodList = dao.getAllProducts();
		System.out.println("Inside Sevice" + prodList);
		return prodList;
	}

	@Override
	public Product getProductById(String prodId) {
		return dao.getProductById(prodId);
		
	}

	@Override
	public Product getProductByName(String prodName) {
		return dao.getProductByName(prodName);
	}


}