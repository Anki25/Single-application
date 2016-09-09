package com.niit.controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;
import com.niit.service.SupplierService;
import com.niit.service.UserService;

@Controller
public class AdminController {
	
	
	
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

	@RequestMapping("/adminhome")
	public ModelAndView showAdmin() {
		System.out.println("In admin page");
		return new ModelAndView("adminhome");

	}

	
	@RequestMapping("/addcategory")
	public ModelAndView showAddCategory(@Valid @ModelAttribute("cat") Category c1, BindingResult result,
			HttpServletRequest request) throws IOException {

		System.out.println("In add category page");
		return new ModelAndView("addcategory");

	}

	@RequestMapping("/registerC")
	public String createCategory(@Valid @ModelAttribute("cat") Category c2, BindingResult result,
			HttpServletRequest request) throws IOException {
		categoryservice.saveOrUpdate(c2);
		return "adminhome";
	}

	@RequestMapping("/addsupplier")
	public ModelAndView showAddSupplier(@Valid @ModelAttribute("sup") Supplier s1, BindingResult result,
			HttpServletRequest request) throws IOException {

		System.out.println("In add supplier page");
		return new ModelAndView("addsupplier");

	}

	@RequestMapping("/registerS")
	public String createSupplier(@Valid @ModelAttribute("sup") Supplier s2, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println("in supplier add page");
		supplierservice.saveOrUpdate(s2);
		return "adminhome";
	}

	@RequestMapping("/products")
	public ModelAndView showAllProducts() {
		return new ModelAndView("products");
	}

	

	
	@RequestMapping("/managecategory")
	public ModelAndView categories(){
		Category category = new Category();
		ModelAndView mv=new ModelAndView("/category");
		mv.addObject("category",category);
		mv.addObject("categoryList",categoryservice.list());
		return mv;
		
		
	}
	
		
	
	
	
	
	
	
	/* @RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@PathVariable("id") int id) throws Exception {
		// log.debug("Starting");
		product = prodservice.get(id);
		ModelAndView mv = new ModelAndView("products");
		if (product == null) {
			mv.addObject("errorMessage", "Could not delete");
		} else {
			prodservice.delete(product);
		}
		return mv;
	}

	@RequestMapping("/updateproduct")
	public String editProduct(@PathVariable("id") int id, Model model) { // model
																			// because
																			// we
																			// want
																			// to
																			// retrieve
																			// whole
																			// object
																			// to
																			// edit
																			// anything
																			// we
																			// want

		if (prodservice.get(id) != null) {
			prodservice.saveOrUpdate(product);
			model.addAttribute("message", "Succesfully updated");
		} else {
			model.addAttribute("errorMessage", "Could not be updated");
		}
		// log.debug("Ending");
		return "product";
	}

	@RequestMapping("/deletecategory")
	public ModelAndView deleteCategory(@PathVariable("id") int id) throws Exception {
		// log.debug("Starting");
		Category category = categoryservice.get(id);
		ModelAndView mv = new ModelAndView("category");
		if (category == null) {
			mv.addObject("errorMessage", "Could not delete");
		} else {
			categoryservice.delete(category);
		}
		return mv;
	}
	
	@RequestMapping("/updatecategory")
	public ModelAndView UpdateCategoryPage() {
		System.out.println("In UpdateCategory page");

		return new ModelAndView("updatecategory");

	}



	@RequestMapping("/upcat")
	public String editCategory(@PathVariable("id") int id, Model model) { // model
																			// because
																			// we
																			// want
																			// to
																			// retrieve
																			// whole
																			// object
																			// to
																			// edit
																			// anything
																			// we
																			// want
System.out.println("In update category page");
		Category category = null;
		if (categoryservice.get(id) != null) {
			categoryservice.saveOrUpdate(category);
			model.addAttribute("message", "Succesfully updated");
		} else {
			model.addAttribute("errorMessage", "Could not be updated");
		}
		// log.debug("Ending");
		return "category";
	}
*/
	/* @RequestMapping("/cat")
	public ModelAndView viewItems() throws JsonGenerationException, JsonMappingException, IOException {
		List<Category> list = categoryservice.list();
		System.out.println("user list=" + list);
		ObjectMapper om = new ObjectMapper();
		String listjson = om.writeValueAsString(list);
		System.out.println(listjson);
		return new ModelAndView("categories", "listofitem", listjson);
	}
	String setName;
	List<Category> clist;

	@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues() throws Exception {
		String result = "";
		clist = categoryservice.list();
		Gson gson = new Gson();
		result = gson.toJson(clist);
		return result;

	}
	
	@RequestMapping("/EditProduct")
	public ModelAndView editItem(@RequestParam("id") int id) {
		System.out.println("id:" + id);
		Product product = prodservice.get(id);
		System.out.println("Product Name:" + product.getPro_name());
		return new ModelAndView("ManageProduct", "product", product);
	}
	
	@RequestMapping("/supplier/delete/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") int id) throws Exception {
		// log.debug("Starting");
		Supplier supplier = supplierservice.get(id);
		ModelAndView mv = new ModelAndView("supplier");
		if (supplier == null) {
			mv.addObject("errorMessage", "Could not delete");
		} else {
			supplierservice.delete(supplier);
		}
		return mv;
	}
	
	@RequestMapping("/updatesupplier")
	public ModelAndView updateSupplierPage(){
		System.out.println("In updateSupplier page");
		return new ModelAndView("updatesupplier");
	}

	@RequestMapping("/updatesupplier")
	public String editSupplier(@PathVariable("id") int id, Model model) { // model
																			// because
																			// we
																			// want
																			// to
																			// retrieve
																			// whole
																			// object
																			// to
																			// edit
																			// anything
																			// we
																			// want

		Supplier supplier = null;
		if (supplierservice.get(id) != null) {
			supplierservice.saveOrUpdate(supplier);
			model.addAttribute("message", "Successfully updated");
		} else {
			model.addAttribute("errorMessage", "Could not be updated");
		}
		// log.debug("Ending");
		return "supplier";
	}
*/
}
