package com.niit.dao;

import java.util.List;


import com.niit.model.Supplier;

public interface SupplierDAO {
 
	 //Declare all CRUD operations
	public boolean saveOrUpdate(Supplier supplier);
	
	//public boolean save(Supplier supplier);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	//public boolean update(Supplier supplier);
	
	public boolean delete(Supplier supplier);
	
	public Supplier get(int id);
	
	public Supplier getName(String name);
	
	public List<Supplier> list();
}
