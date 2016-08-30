package com.niit.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierDAO supp;
	
	@Autowired  
	private SessionFactory sessionFactory;
	
	public SupplierServiceImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	
/*	@Transactional
	public boolean save(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	} */

	@Transactional
	public boolean delete(Supplier supplier) {     //(String id) since id is given object is created
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	
	}


	@Transactional
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		String hql = " from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  //to add try catch right click surround with
		return query.list();
	
	}

	@Override
	public boolean saveOrUpdate(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public Supplier get(int id) {
		// TODO Auto-generated method stub
		return supp.get(id);
	}

	@Override
	public Supplier getName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Inside getproductByName service");
		System.out.println("name:" + name);
		return supp.getName(name);
	}

	

}
