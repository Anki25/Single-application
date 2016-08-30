package com.niit.dao;

import java.util.List;


import com.niit.model.User;


public interface UserDAO {
 
	 //Declare all CRUD operations
	
	//public boolean save(User user);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	//public boolean update(User user);  //to find and replace select word ctrl C and ctrl F
	
	public boolean delete(User user);
	
	public boolean saveOrUpdate(User user);
	
	public User get(int id);
	
	public User getName(String name);
	
	public List<User> list();
}

