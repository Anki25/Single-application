package com.niit.dao;

import java.util.List;





import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@EnableTransactionManagement
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired  //no need to create object of session factory ...automatically created
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	/* @Transactional
	public boolean save(User user) {
		// TODO Auto-generated method stub
		try{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(User user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	} */
	@Transactional
	public boolean delete(User user) {  //since object is given 
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	
	@Transactional
			public User get(int id) {
		// TODO Auto-generated method stub  select * from user where id = '101'
		String hql = "from User where id= " + " ' " + id + " ' ";  //user is d domain object name not table name
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List <User> list = query.list();
		
		if(list==null || list.isEmpty())
		{
		return null;
	}else
	{ return list.get(0);
	}
			}
			
	@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub 
		String hql = " from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  //to add try catch right click surround with
		return query.list();
		
	}
	
	@Transactional
	public boolean saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		
}
	
	
	
@Transactional
	public User getName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Inside getuserByName daoimpl");
		System.out.println("name:" + name);
        String hql = "from User where id= " + " ' " + name + " ' ";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List <User> list = query.list();
		
		if(list==null || list.isEmpty())
		{
		return null;
	}else
	{ return list.get(0);
	}
	
	} 

	} 

