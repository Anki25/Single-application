package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.niit.model.Category;

@EnableTransactionManagement
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	// OR private static final Logger Log = LoggerFactory.getLogger("com.niit.shoppingcart.dao.ProductDAOImpl");
	
	@Autowired  //no need to create object of session factory ...automatically created
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	
	/* @Transactional
	public boolean save(Category category) {
		// TODO Auto-generated method stub
		try{
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().save(category);
				
			log.debug("Ending of the method save");
			return true;
			}catch(Exception e){
				log.error("Exception occured in save method" + e.getMessage());
				e.printStackTrace();
				return false;
	}
	}

	 @Transactional
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try{
			log.debug("Starting of the method update");
			sessionFactory.getCurrentSession().update(category);
			log.debug("Ending of the method update");
			return true;
			}catch(Exception e){
				log.error("Exception occured in update method" + e.getMessage());
				e.printStackTrace();
				return false;
			}
	} */

	@Transactional
	public boolean delete(Category category) {  //since object is given 
		// TODO Auto-generated method stub
		try{
			log.debug("Starting of the method delete");
			sessionFactory.getCurrentSession().delete(category);
			log.debug("Ending of the method delete");
			return true;
			}catch(Exception e){
				log.error("Exception occured in delete method" + e.getMessage());
				e.printStackTrace();
				return false;
			}
	}

	
	@Transactional	
			public Category get(int id) {
		// TODO Auto-generated method stub  select * from category where id = '101'
				log.debug("Starting of the method get");
				log.info("Trying to get product based on id: " + id);
		String hql = "from Category where id= " + " ' " + id + " ' ";  //category is d domain object name not table name
		
		log.info("The hql query is: " + hql); 
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List <Category> list = query.list();
		
		if(list==null || list.isEmpty())
		{
			log.info("No products are available with this id: " + id);
		return null;
	}else
	{ return list.get(0);
	}
			}
	
	@Transactional
	public List<Category> list() {
		// TODO Auto-generated method stub
		log.debug("Starting of the method list");
		
		String hql = " from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  //to add try catch right click surround with
		
		log.debug("Starting of the method list");
		List<Category> list =  query.list();
		if(list==null || list.isEmpty())
		{
			log.info("No products are available");
		}
		return list;
		
	}
	
	@Transactional
	 public boolean saveOrUpdate(Category category) {
		 try{
			Transaction t =sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			t.commit();
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			} 
	}

	

	@Transactional
	public Category getName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Inside getcategoryyName daoimpl");
		System.out.println("name:" + name);
        String hql = "from Category where id= " + " ' " + name + " ' ";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List <Category> list = query.list();
		
		if(list==null || list.isEmpty())
		{
		return null;
	}else
	{ return list.get(0);
	}
	
	} 

	

	}
