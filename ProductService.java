package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {
	
	public boolean delete(Product product);
	
	public boolean saveOrUpdate(Product product);
	
	public Product get(int id);
	
	public Product getName(String name);
	
	public List<Product> list();


}
