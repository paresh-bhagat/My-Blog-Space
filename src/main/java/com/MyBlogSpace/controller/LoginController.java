package com.MyBlogSpace.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String loginFail() {
		System.out.print("login fail page");
		return "loginfail";
		
	}
	
	@RequestMapping(path="/SignUp", method = RequestMethod.GET)
	public String signUp() {
		System.out.print("signup page");
		return "signup";
		
	}
	
	@RequestMapping(path="/processloginform", method=RequestMethod.POST)
	public String handleSignInForm(@RequestParam("user_id") String user_id, 
			@RequestParam("user_password") String user_password, 
			RedirectAttributes redirectAttributes) {
		
		boolean exist = userservice.checkuser(user_id,user_password);
		
		if(exist==false)
			return "redirect:/loginfail";
		
		redirectAttributes.addFlashAttribute("user_id",user_id );
		
		return "redirect:/feed";
	}
		
	
	
	@RequestMapping(path="/processsignupform", method=RequestMethod.POST)
	public String handleRegisterForm(@RequestParam("user_id") String user_id, 
			@RequestParam("user_password") String user_password, 
			RedirectAttributes redirectAttributes ) {
		
		UserInfo user = new UserInfo();
		user.setUser_id(user_id);
		user.setUser_password(user_password);
		
		List<BlogList> list = new ArrayList<BlogList>();
		user.setBlogs(list);
		
		System.out.print(user);
		boolean valid = userservice.addnewuser(user);
		
		if(valid==false)
		{
			return "";
		}
		
		redirectAttributes.addFlashAttribute("user_id",user_id );
		
		return "redirect:/feed";
		
	}
	
	@RequestMapping(path="/error", method = RequestMethod.GET)
	public String errorPage() {
		System.out.print("error page");
		return "errorpage";	
	}
	
}
