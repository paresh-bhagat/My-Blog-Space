package com.MyBlogSpace.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.service.UserService;
import com.MyBlogSpace.model.BlogList;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String home() {
		System.out.print("first page");
		return "index";
		
	}
	
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public String login() {
		System.out.print("login page");
		return "login";
		
	}
	
	@RequestMapping(path="/loginfail", method = RequestMethod.GET)
	public String loginFail(@RequestParam int error_type, Model model) {
		System.out.print("login fail page");
		model.addAttribute("error_type", error_type);
		return "loginfail";
		
	}
	
	@RequestMapping(path="/SignUp", method = RequestMethod.GET)
	public String signUp() {
		System.out.print("signup page");
		return "signup";
		
	}
	
	@RequestMapping(path="/SignUpfail", method = RequestMethod.GET)
	public String signUpfail(@RequestParam int error_type, Model model) {
		System.out.print("signup fail page");
		
		model.addAttribute("error_type", error_type);
		return "signupfail";
		
	}
	
	
	@RequestMapping(path="/processloginform", method=RequestMethod.POST)
	public String handleLogInForm(@RequestParam("user_name") String user_name,
			@RequestParam("user_password") String user_password, 
			RedirectAttributes redirectAttributes) {
		
		
		if( user_name.length() > 20 || user_password.length() > 20 )
			return "redirect:/loginfail?error_type=0";
		
		boolean exist = userservice.checkuser(user_name,user_password);
		
		if(exist==false)
			return "redirect:/loginfail?error_type=1";
		
		redirectAttributes.addFlashAttribute("user_name",user_name );
		
		return "redirect:/feed";
	}
		
	
	
	@RequestMapping(path="/processsignupform", method=RequestMethod.POST)
	public String handleSignUpForm(@RequestParam("user_name") String user_name,
			@RequestParam("user_password") String user_password, 
			RedirectAttributes redirectAttributes ) {
		
		
		if( user_name==null || user_name.length()==0 || user_password==null || user_password.length()==0  )
			return "redirect:/SignUpfail?error_type=0";
		
		if( user_name.length() > 20 || user_password.length() > 20 )
			return "redirect:/SignUpfail?error_type=1";
		
		UserInfo user = new UserInfo();
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		
		List<BlogList> list = new ArrayList<BlogList>();
		user.setBlogs(list);
		
		System.out.print(user);
		boolean valid = userservice.addnewuser(user);
		
		if(valid==false)
			return "redirect:/SignUpfail?error_type=2";
		
		redirectAttributes.addFlashAttribute("user_name",user_name );
		
		return "redirect:/feed";
		
	}
	
	@RequestMapping(path="/error", method = RequestMethod.GET)
	public String errorPage() {
		System.out.print("error page");
		return "errorpage";	
	}
	
}
