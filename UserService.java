package com.niit.service;

import java.util.List;



import com.niit.model.User;

public interface UserService {
	
	public boolean delete(User user);
	
	public boolean saveOrUpdate(User user);
	
	public User get(int id);
	
	public User getName(String name);
	
	public List<User> list();


}