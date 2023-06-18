package com.MyBlogSpace.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.MyBlogSpace.service.UserService;

@Scope("session")
@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice;

	private String user_id;
	
	@RequestMapping(path="/feed",method = RequestMethod.GET)
	public String feed(HttpServletRequest request, Model model) {
		
		System.out.print("feed page");
		System.out.println(this);
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
        if(flashMap==null && user_id==null){
           return "redirect:/error";
        }
        
        String user_id;
        
        if(flashMap != null)
        {
        	user_id = (String) flashMap.get("user_id");
        	this.user_id = user_id;
        }
        else
        {
        	user_id = this.user_id;
        	model.addAttribute("user_id", user_id);
        }
        	
        
        System.out.println(user_id);
       
        return "home";
	}
	
	@RequestMapping(path="/myblogs",method = RequestMethod.GET)
	public String myBlogs(Model model) {
		System.out.print("myblogs page");
		System.out.print(this.user_id);
		model.addAttribute("user_id", user_id);
		return "myblogs";
	}
	
	@RequestMapping(path="/viewblog",method = RequestMethod.GET)
	public String viewBlog(Model model) {
		System.out.print("timeline page");
		return "blogview";
	}
	
	@RequestMapping(path="/editblog",method = RequestMethod.GET)
	public String editBlog(Model model) {
		System.out.print("edit page");
		return "blogedit";
	}
	
	@RequestMapping(path="/newblog",method = RequestMethod.GET)
	public String newBlog(Model model) {
		System.out.print("new blog page");
		System.out.print(this.user_id);
		return "newblog";
	}

}
