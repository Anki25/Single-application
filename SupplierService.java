package com.niit.service;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierService {
	
	public boolean delete(Supplier supplier);
	
	public boolean saveOrUpdate(Supplier supplier);
	
	public Supplier get(int id);
	
	public Supplier getName(String name);
	
	public List<Supplier> list();


}