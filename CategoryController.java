package com.niit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Category;
import com.niit.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
	@RequestMapping(value="/category" ,method=RequestMethod.GET)
	public String listCategories(@Valid @ModelAttribute("category") Category c3, BindingResult result,
			HttpServletRequest request,Model model) throws IOException {        
		
	model.addAttribute("Category", new Category());
	model.addAttribute("categoryList","this.categoryDAO.list()");
	
	return "category";
	}
	
	@RequestMapping(value="/category/add",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category")Category category){
		
		ModelAndView mv = new ModelAndView("category");
		if(categoryservice.get(category.getCat_Id())==null)
		{
			categoryservice.saveOrUpdate(category);
		}
		else
		{
			mv.addObject("errorMessage","The record exist with this id" + category.getCat_Id());
		}
		mv.addObject("categoryList",categoryservice.list());
	return "category";
}
	
	@RequestMapping("category/edit/{id}")  //@ModelAttribute("category"),Category category
	public String editCategory(@PathVariable("id")int id,Model model,Category category,BindingResult result,
			HttpServletRequest request){  
		System.out.println("in category editpage ");
	    category = categoryservice.get(id);
		if(category !=null)
		{			
			categoryservice.saveOrUpdate(category);
			model.addAttribute("message","Successfully updated");
		}
		else
		{
			model.addAttribute("errorMessage","Could not be updated");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryList",categoryservice.list());
		return "category";
	}
	
	@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id")int id,Category c4,BindingResult result,
			HttpServletRequest request)throws Exception{
		
		Category category=categoryservice.get(id);
		ModelAndView mv = new ModelAndView("category");
		if(category==null)
		{
			mv.addObject("errorMessage", "Could not delete");
		}
		else
		{
			categoryservice.delete(category);
		}
		mv.addObject("categoryList",categoryservice.list());
		return mv;
	}
	

}
