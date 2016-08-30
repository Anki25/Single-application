package com.niit.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO cat;
	
	@Autowired  
	private SessionFactory sessionFactory;
	
	public CategoryServiceImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}

	@Transactional
	public boolean saveOrUpdate(Category category) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public List<Category> list() {
		List<Category> list = cat.list();
		return list;
	}

	@Transactional
	public Category get(int id) {
	
		return cat.get(id);
	}

	@Transactional
	 public Category getName(String name) {
		System.out.println("Inside getcategoryByName service");
		System.out.println("name:" + name);
		return cat.getName(name);
	} 


	@Transactional
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(category);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	

}
}