package com.MyBlogSpace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyBlogSpace.service.UserService;

@Controller
public class LoginController {
	
	private UserService userservice;
	
	@RequestMapping("/login")
	public String Login() {
		System.out.print("signin page");
		return "signin";
		
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
