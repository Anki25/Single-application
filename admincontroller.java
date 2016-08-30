package com.niit.controller;

import java.io.File;



import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;
import com.niit.service.SupplierService;
import com.niit.service.UserService;

@Controller
public class admincontroller {
	
	@Autowired
	Product product;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	CategoryService categoryservice;
	
	@Autowired
	SupplierService supplierservice;
	
	@Autowired
	ProductService prodservice;
	
	@RequestMapping("/addproduct") //, method=RequestMethod.POST)
	public ModelAndView showProduct(@Valid @ModelAttribute("prod")Product p1,BindingResult result,HttpServletRequest request)throws IOException
	{
		
		System.out.println("In add product page");
		return new ModelAndView("addproduct");
		
	}
	
	@RequestMapping("/adminhome")
	public ModelAndView showAdmin(@Valid @ModelAttribute("prod")Product p1,BindingResult result)
	{
		System.out.println("In admin page");
		return new ModelAndView("adminhome");
		
	}
	
	@RequestMapping("/register")
	public String createProduct(@ModelAttribute("prod") Product p2,@RequestParam("image") MultipartFile file,Model model,HttpServletRequest request)throws IOException
	{
	 	//String filename;
	 	//byte[]bytes;
	 			prodservice.saveOrUpdate(p2);
	 			System.out.println("image");
	 			MultipartFile image=p2.getImage();
	 			Path path;
	 			path=Paths.get("F://Single//Single//src//main//webapp//resources//images//"+p2.getPro_Id()+".jpg");
	 			//String path = request.getSession().getServletContext().getRealPath("/resources/images/" + user.getUser_id() + ".jpg");
	            System.out.println("Path = " + path);
	            System.out.println("File name = " + p2.getImage().getOriginalFilename());
	            if(image!=null && !image.isEmpty())
	            {
	            	try
	            	{
	            	   image.transferTo(new File(path.toString()));
	            	   System.out.println("Image Saved in:"+path.toString());
	            	}catch(Exception e)
	            	{
	            		e.printStackTrace();
	            		System.out.println("Image not saved");
	            	}
	            }
	            Supplier supplier= supplierservice.getName(((Supplier) product.getSupplier()).getSup_name());
	            supplierservice.saveOrUpdate(supplier);
	            
	            Category category= categoryservice.getName(product.getCategory().getCat_name());
	            categoryservice.saveOrUpdate(category);
	            
	            product.setCategory(category);
	            product.setSupplier((Set<Supplier>) supplier);
	            
	            prodservice.saveOrUpdate(product);
	            

		return "addproduct";
	}
}


