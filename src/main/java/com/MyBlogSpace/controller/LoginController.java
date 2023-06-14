package com.MyBlogSpace.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.service.UserService;
import com.MyBlogSpace.model.BlogList;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/login")
	public String Login() {
		System.out.print("signin page");
		return "signin";
		
	}
	
	@RequestMapping(path="/processsigninform", method=RequestMethod.POST)
	public String handleSignInForm(@RequestParam("user_id") String user_id, 
			@RequestParam("user_password") String user_password) {
		
		boolean exist = userservice.checkuser(user_id,user_password);
		
		if(exist==true)
			return "home";
		return "";
		
	}
	
	@RequestMapping(path="processregisterform", method=RequestMethod.POST)
	public String handleRegisterForm(@RequestParam("user_id") String user_id, 
			@RequestParam("user_password") String user_password ) {
		
		UserInfo user = new UserInfo();
		user.setUser_id(user_id);
		user.setUser_password(user_password);
		
		List<BlogList> list = new ArrayList<BlogList>();
		user.setBlogs(list);
		
		System.out.print(user);
		boolean valid = userservice.addnewuser(user);
		
		if(valid==true)
			return "home";
		return "";
	}
	
	
	@RequestMapping("/register")
	public String Register() {
		System.out.print("register page");
		return "register";
		
	}
	
	@RequestMapping("/feed")
	public String Home() {
		System.out.print("timeline page");
		return "home";
	}
	
	@RequestMapping("/myblogs")
	public String MyBlogs() {
		System.out.print("timeline page");
		return "myblogs";
	}
	
	@RequestMapping("/viewblog")
	public String ViewBlog() {
		System.out.print("timeline page");
		return "blogview";
	}
	
	@RequestMapping("/editblog")
	public String EditBlog() {
		System.out.print("edit page");
		return "blogedit";
	}
	
}
