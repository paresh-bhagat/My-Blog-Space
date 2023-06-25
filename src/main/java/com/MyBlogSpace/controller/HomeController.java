package com.MyBlogSpace.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.MyBlogSpace.service.UserService;

@Scope("session")
@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice;

	private String user_id;
	
	// handler for feed
	
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
        
        LinkedHashMap<String, List<List<String>>> all_blog_details = this.userservice.getAllBlogdetails();
        
        model.addAttribute("blogs", all_blog_details);
        
        System.out.println(user_id);
       
        return "home";
	}
	
	// see all my blogs
	
	@RequestMapping(path="/myblogs",method = RequestMethod.GET)
	public String myBlogs(Model model) {
		System.out.print("myblogs page");
		System.out.print(this.user_id);
		model.addAttribute("user_id", user_id);
		
		LinkedHashMap<String, List<List<String>>> user_blog_details = this.userservice.getUserBlogdetails(user_id);
        
        model.addAttribute("blogs", user_blog_details);
        
		return "myblogs";
	}
	
	// view a blog
	
	@RequestMapping(path="/viewblog",method = RequestMethod.GET)
	public String viewBlog(@RequestParam String blog_user_id,
			@RequestParam String blog_name,
		    @RequestParam String blog_topic, Model model) {
		
		List<String> temp = this.userservice.getblogdetails(blog_user_id,blog_name,blog_topic);
		model.addAttribute("blog", temp);
		
		System.out.print("timeline page");
		return "blogview";
	}
	
	// edit a blog
	
	@RequestMapping(path="/editblog",method = RequestMethod.GET)
	public String editBlog(@RequestParam String blog_user_id,
			@RequestParam String blog_name,
		    @RequestParam String blog_topic, Model model) {
		System.out.print("edit page");
		return "return:/myblogs";
	}
	
	// update a blog
	
	@RequestMapping(path="/processupdateblogform",method = RequestMethod.POST)
	public String updateBlog(@RequestParam("blog_title") String title, 
			@RequestParam("blog_topic") String topic,
			@RequestParam("blog_content") String content, 
			@RequestParam("blog_postimage") CommonsMultipartFile file,
			HttpSession s) throws Exception {
		
		System.out.print("edit page");
		
		if( ( title==null || title.length()==0 ) || ( content==null || content.length()==0 ) )
		{
			System.out.print("title or content wrong");
			return "";
		}
		
		String path = s.getServletContext().getRealPath("/");
		
		this.userservice.updateblog(user_id, title, topic, content, file, path);
		
		System.out.print(user_id);
		return "redirect:/myblogs";
		
	}
	
	// delete a blog
	
	@RequestMapping(path="/deleteblog",method = RequestMethod.GET)
	public String deleteBlog(@RequestParam String blog_user_id,
			@RequestParam String blog_name,
		    @RequestParam String blog_topic, Model model) {
		System.out.print("delet blog page");
		
		this.userservice.deleteblog(blog_user_id, blog_name, blog_topic);
		
		return "return:/myblogs";
	}
	
	// create a new blog
	
	@RequestMapping(path="/newblog",method = RequestMethod.GET)
	public String newBlog(Model model) {
		System.out.print("new blog page");
		System.out.print(this.user_id);
		return "newblog";
	}
	
	// process new blog form action
	
	@RequestMapping(path="/processnewblogform", method=RequestMethod.POST)
	public String handleNewBlogForm(@RequestParam("blog_title") String title, 
			@RequestParam("blog_topic") String topic,
			@RequestParam("blog_content") String content, 
			@RequestParam("blog_postimage") CommonsMultipartFile file,
			HttpSession s) throws Exception {
		
		System.out.print("insid enew blog form");
		
		if( ( title==null || title.length()==0 ) || ( content==null || content.length()==0 ) )
		{
			System.out.print("tiltle or content wrong");
			return "";
		}
		
		if ( file==null ||file.getSize()==0 )
		{
			System.out.print("image wrong");
			return "";
		}
		
		String path = s.getServletContext().getRealPath("/");
		
		this.userservice.addNewBlog(this.user_id,title,topic,content,file,path);
		
		System.out.print(user_id);
		return "redirect:/myblogs";
		
	}

}
