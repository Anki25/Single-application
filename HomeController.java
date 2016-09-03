package com.niit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.User;
import com.niit.service.UserService;

//@controller is a predefined annotation which we need to specified for our class to be act like as controller 
@Controller
public class HomeController {

	@Autowired
	UserService userservice;

	@Autowired
	User user;

	// request mapping is also predefined a annotation for map the address which
	// jsp page //u need to execute .
	// here in these example my home page should display as soon as I will run
	// my project
	// Without giving a extension of jsp page

	@RequestMapping("/")
	// user defined function which return a ModelAndViewobject .
	public ModelAndView LandingPage() {
		System.out.println("In Home page");
		// creating a object for modelandview class and passing the parameter
		// for //jsppage .without extension of jsp page. It will execute your
		// main //page.
		return new ModelAndView("home");

	}

	@RequestMapping("/signin")
	public ModelAndView SignInPage() {
		System.out.println("In SignIn page");

		return new ModelAndView("signin");

	}

	@RequestMapping(value = "/check")
	public ModelAndView AfterSignIn(@RequestParam(value = "txtname") String username,
			@RequestParam(value = "txtpass") String password, HttpSession session) {

		String msg;
		System.out.println("In Checking SignIn page");
		ModelAndView mv;

		user = userservice.isValidUser(username, password);

		if (user == null) {
			msg = "Invalid user..please try again";
			mv = new ModelAndView("signin");
		} else {
			if (user.getRole().equals("ADMIN")) {
				mv = new ModelAndView("adminhome");
			} else {
				mv = new ModelAndView("home1");
			}
			session.setAttribute("welcomeMsg", user.getFirstname());
			System.out.println((String) session.getAttribute("welcomeMsg"));

		}
		return mv;
	}

	@RequestMapping("/signup")
	public ModelAndView SignUp(@Valid @ModelAttribute("us") User u, BindingResult result, HttpServletRequest request)
			throws IOException {
		System.out.println("signup");
		return new ModelAndView("signup");
	}

	@RequestMapping("/validate")
	public ModelAndView ValidateSignUpPage(@Valid @ModelAttribute("us") User u, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println("In SignUp page");
		u.setRole("USER");

		System.out.println(u.getPassword());
		System.out.println(u.getCpassword());
		
		if (u.getCpassword().equals(u.getPassword())) {
			userservice.saveOrUpdate(u);
		}
		return new ModelAndView("signin");

	}

	@RequestMapping("/home1")
	public ModelAndView showHome() {
		System.out.println("In home page");
		return new ModelAndView("home1");

	}

	@RequestMapping("/aboutus")
	public ModelAndView showAboutUs() {
		System.out.println("In About us page");
		return new ModelAndView("aboutus");

	}

	@RequestMapping("/contactus")
	public ModelAndView showContactUs() {
		System.out.println("In Contact us page");
		return new ModelAndView("contactus");

	}

	@RequestMapping("/privacynotice")
	public ModelAndView showPrivacy() {
		System.out.println("In Privacy Notice page");
		return new ModelAndView("privacynotice");

	}

	@RequestMapping("/conditionsofsale")
	public ModelAndView showCondition() {
		System.out.println("In Conditions of Sale page");
		return new ModelAndView("conditionsofsale");

	}

	@RequestMapping("/cancelpolicy")
	public ModelAndView showCancelPolicy() {
		System.out.println("In Cancel&Return Policy page");
		return new ModelAndView("contactus");

	}

}
