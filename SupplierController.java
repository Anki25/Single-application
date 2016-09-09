package com.niit.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Supplier;
import com.niit.service.SupplierService;

@Controller
public class SupplierController {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierService supplierservice;
	
	@Autowired
	private Supplier supplier;
	
	
	@RequestMapping(value="/supplier/add",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier")Supplier supplier){
		//log.debug("Starting");
		ModelAndView mv = new ModelAndView("supplier");
		if(supplierservice.get(supplier.getSup_Id())==null)
		{
			supplierservice.saveOrUpdate(supplier);
		}
		else
		{
			mv.addObject("errorMessage","The record exist with this id" + supplier.getSup_Id());
		}
	//log.debug("Ending");
	return "supplier";
}
	
	@RequestMapping("supplier/remove/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id")int id,Supplier s4,BindingResult result,
			HttpServletRequest request)throws Exception{
		//log.debug("Starting");
		supplier=supplierservice.get(id);
		ModelAndView mv = new ModelAndView("supplier");
		if(supplier==null)
		{
			mv.addObject("errorMessage", "Could not delete");
		}
		else
		{
			supplierservice.delete(supplier);
		}
		
		return mv;
	}
	
	@RequestMapping("supplier/edit/{id}")
	public String editSupplier(@PathVariable("id")int id,Model model){  //model because we want to retrieve whole object to edit anything we want
		
		//log.debug("Starting");
		if(supplierservice.get(id)!=null)
		{
			supplierservice.saveOrUpdate(supplier);
			model.addAttribute("message","Succesfully updated");
		}
		else
		{
			model.addAttribute("errorMessage","Could not be updated");
		}
		//log.debug("Ending");
		return "supplier";
	}
	
	@RequestMapping(value="/supplier" ,method=RequestMethod.GET)
	public String listCategories(Model model){
		//log.debug("Starting");
	model.addAttribute("Supplier", new Supplier());
	model.addAttribute("supplierList","this.supplierservice.list()");
	//log.debug("Ending");
	return "supplier";
	}
	
	@RequestMapping("/managesupplier")
	public ModelAndView suppliers(){
		Supplier supplier = new Supplier();
		ModelAndView mv=new ModelAndView("/supplier");
		mv.addObject("supplier",supplier);
		mv.addObject("supplierList",supplierservice.list());
		return mv;
	}
	
}