package com.lti.appl.aseameet.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.aseameet.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addProduct(Product product) {
		String q1 = "select max(PROD_ID) from PRODUCTS";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number id = (Number) query1.getSingleResult();
		int prodId = id.intValue()+1;
		product.setProdId(prodId); 
		entityManager.persist(product);
	}

	@Override
	public void removeProduct(String prodId) {
		entityManager.remove(prodId);
	}

	@Override
	public List<Product> getAllProducts() {
		
		TypedQuery<Product> qry = entityManager.createQuery("Select p from Product p", Product.class);
		
		List<Product> prodList = qry.getResultList();
		System.out.println("Inside DAO" + prodList);
		//System.out.println(prodList);
		return prodList;
	
	}

	@Override
	public Product getProductById(String prodId) {
		Product prod = entityManager.find(Product.class, prodId);
		return prod;
	}

	@Override
	public Product getProductByName(String prodName) {
		TypedQuery<Product> qry1 = entityManager.createQuery("Select p from Product p where p.prodName=:prName", Product.class);
		qry1.setParameter("prName", prodName);
		return qry1.getSingleResult();
	}


}

