package com.niit.controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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

	@RequestMapping("/addproduct") // , method=RequestMethod.POST)
	public ModelAndView showAddProduct(@Valid @ModelAttribute("prod") Product p1, BindingResult result,
			HttpServletRequest request) throws IOException {

		System.out.println("In add product page");
		return new ModelAndView("addproduct");

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/registerP")
	public String createProduct(@ModelAttribute("prod") Product p2, @RequestParam("image") MultipartFile file,
			Model model, HttpServletRequest request) throws IOException {
		// String filename;
		// byte[]bytes;
		prodservice.saveOrUpdate(p2);
		System.out.println("image");
		MultipartFile image = p2.getImage();
		Path path;
		path = Paths.get("F://Single//Single//src//main//webapp//resources//images//" + p2.getPro_Id() + ".jpg");
		// String path =
		// request.getSession().getServletContext().getRealPath("/resources/images/"
		// + user.getUser_id() + ".jpg");
		System.out.println("Path = " + path);
		System.out.println("File name = " + p2.getImage().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");
			}
		}

		Supplier supplier = supplierservice.getName(((Supplier) product.getSupplier()).getSup_name());
		supplierservice.saveOrUpdate(supplier);

		Category category = categoryservice.getName(product.getCategory().getCat_name());
		categoryservice.saveOrUpdate(category);

		product.setCategory(category);
		product.setSupplier((Set<Supplier>) supplier);

		prodservice.saveOrUpdate(product);

		return "adminhome";
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
	
	return "category";
}
	
	@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id")int id)throws Exception{
		
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
		
		/*boolean flag=categoryDAO.delete(id);
		ModelAndView mv=new ModelAndView("category");
		String msg="Success";
		if(flag!=true)
		{
			msg="Unsuccessful";
		}
		mv.addObject("msg",msg);
		}
		log.debug("Ending");*/
		return mv;
	}
	
	@RequestMapping("/managecategory")
	public ModelAndView categories(){
		Category category = new Category();
		ModelAndView mv=new ModelAndView("/category");
		mv.addObject("category",category);
		mv.addObject("categoryList",categoryservice.list());
		return mv;
		
		
	}
	
	@RequestMapping("category/edit/{id}")
	public String editCategory(@PathVariable("id")int id,Model model){  //model because we want to retrieve whole object to edit anything we want
		
	//public String addCategory(@ModelAttribute("category")Category category)   another method
		//if(categoryDAO.get(Category.get(Id)!=null)
		//ModelAndView mv=new ModelAndView();
		//mv.addObject()
		
		if(categoryservice.get(id)!=null)
		{
			Category category = new Category();
			categoryservice.saveOrUpdate(category);
			model.addAttribute("message","Succesfully updated");
		}
		else
		{
			model.addAttribute("errorMessage","Could not be updated");
		}
		
		return "category";
	}
	
	@RequestMapping(value="/category" ,method=RequestMethod.GET)
	public String listCategories(@Valid @ModelAttribute("category") Category c3, BindingResult result,
			HttpServletRequest request,Model model) throws IOException {        
		
	model.addAttribute("Category", new Category());
	model.addAttribute("categoryList","this.categoryDAO.list()");
	
	return "category";
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
