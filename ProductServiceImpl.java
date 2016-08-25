package com.niit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO prod;

	@Override
	public boolean saveOrUpdate(Product product) {
		return prod.saveOrUpdate(product);
	}

	@Override
	public List<Product> list() {
		List<Product> list = prod.list();
		return list;
	}

	@Override
	public Product get(int pro_Id) {
		return prod.get(pro_Id);
	}

	@Override
	 public Product getName(String pro_name) {
		System.out.println("Inside getproductByName service");
		System.out.println("name:" + pro_name);
		return prod.getName(pro_name);
	} 


	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
