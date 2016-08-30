package com.niit.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO user;
	
	@Autowired  
	private SessionFactory sessionFactory;
	
	public UserServiceImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}

	@Transactional
	public boolean saveOrUpdate(User user) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public List<User> list() {
		List<User> list = user.list();
		return list;
	}

	@Transactional
	public User get(int id) {
	
		return user.get(id);
	}

	@Transactional
	 public User getName(String name) {
		System.out.println("Inside getuserByName service");
		System.out.println("name:" + name);
		return user.getName(name);
	} 


	@Transactional
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	

}
}