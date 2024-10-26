package com.lti.appl.aseameet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;
import com.lti.appl.aseameet.dto.RetailerSignUp;

@Repository("retailerdao")
public class RetailerDaoImpl implements RetailerDao {
	@PersistenceContext
	private EntityManager entityManager;


	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addRetailer(RetailerSignUp newRetailer) {
		Retailer retailer = new Retailer();
		retailer.setrName(newRetailer.getrName());
		retailer.setrMobile(newRetailer.getrMobile());
		retailer.setrEmail(newRetailer.getrEmail());
		retailer.setrPassword(newRetailer.getrPassword());
		String q1 = "select max(r_Id) from retailer_t ";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number id = (Number) query1.getSingleResult();
		int rId = id.intValue()+1;
		retailer.setrId(rId);
		this.entityManager.persist(retailer);
		return rId;
	}
	
	@Override
	public Retailer getRetailerById(int rId) {
		Retailer temp=entityManager.find(Retailer.class, rId);
		System.out.println(temp);
		return temp;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getRetailerByEmailAndPassword(String email, String password) {

		String query = "SELECT E FROM Retailer E WHERE E.rEmail=:email AND E.rPassword=:password";
		int rId = -1;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			tquery.setParameter("email", email);
			tquery.setParameter("password", password);
			rId = tquery.getResultList().get(0).getrId();
		} catch (Exception e) {
			System.out.println("Retailer not exists.");
		}
		return rId;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Retailer getRetailerByEmail(String email) {
		String query = "SELECT E FROM Retailer E WHERE E.rEmail=:email";
		Retailer retailer = null;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			tquery.setParameter("email", email);
			retailer = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Retailer not exists.");
		}
		return retailer;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Retailer> showAllRetailers() {
		String query = "SELECT E FROM Retailer E ";
		List<Retailer> retailer = null;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			retailer = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("Retailers not exists.");
		}
		return retailer;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateProduct(Product update) {
				Product emp = entityManager.find(Product.class, update.getProdStack());
					emp.setProdStack(update.getProdStack());
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> removeProduct(int pId) {
			Product prd=entityManager.find(Product.class,pId);
			entityManager.remove(prd);
			return getAllProducts();
		}
	
	@Override
	public List<Product> getAllProducts() {
		
		TypedQuery<Product> qry = entityManager.createQuery("Select p from Product p", Product.class);
		
		List<Product> prodList = qry.getResultList();
		System.out.println("Inside DAO" + prodList);
		//System.out.println(prodList);
		return prodList;
}
}
