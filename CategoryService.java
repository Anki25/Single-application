package com.niit.service;

import java.util.List;

import com.niit.model.Category;

public interface CategoryService {
 
	 //Declare all CRUD operations
	
	public boolean saveOrUpdate(Category category);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	public boolean delete(Category category);
	
	public Category get(int id);
	
	public Category getName(String name);
	
	public List<Category> list();

	//public boolean save(Category category);
	
	//public boolean update(Category category);
}