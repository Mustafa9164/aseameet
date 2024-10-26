package com.lti.appl.aseameet.dao;


import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.aseameet.beans.Admin;
import com.lti.appl.aseameet.beans.Product;
import com.lti.appl.aseameet.beans.Retailer;

@Repository("admindao")
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Admin getAdminById(int aId) {
		String query = "SELECT E FROM Admin E WHERE E.aId=:aId";
		Admin admin = null;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("aId", aId);
			admin = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return admin;
	}

	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Admin getAdminByEmail(String email) {
		String query = "SELECT E FROM Admin E WHERE E.aEmail=:email";
		Admin admin = null;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("email", email);
			admin = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return admin;
	}

	@Override
	public List<Retailer> getAllRetailers() {
		String query = "SELECT E FROM Retailer E";
		List<Retailer> retailers = null;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			retailers = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("No Retailer or some error");
		}
		return retailers;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Retailer> removeRetailer(int rId) {
		Retailer retailer=entityManager.find(Retailer.class,rId);
		entityManager.remove(retailer);
		return getAllRetailers();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addRetailer(Retailer newRetailer) {
		try {
			entityManager.persist(newRetailer);
			
			String message="You are now a Retailer\n ID: "+newRetailer.getrEmail()+"\n Password : "+newRetailer.getrPassword();
			
		}
		catch(Exception e)
		{
			System.out.println("Unable to add");
			return false;
		}
		return true;
	}



	@Override
	public boolean getAdmin(Admin login) {
		String aEmail=login.getaEmail();
		String aPassword=login.getaPassword();
		
		TypedQuery<Admin> tquery=entityManager.createQuery("select a from Admin a",Admin.class);
		List<Admin> a1=tquery.getResultList();
		
		for(Admin a:a1) {
			if(a.getaEmail()==aEmail && a.getaPassword()==aPassword) {
				return true;
			}
			System.out.println(a.getaEmail()+" " +a.getaPassword());
		}
		return false;
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getAllProducts() {
		String query = "SELECT P FROM Product P ";
		List<Product> prod = null;
		TypedQuery<Product> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Product.class);
			prod = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("products not exists.");
		}
		return prod;
		}

}
