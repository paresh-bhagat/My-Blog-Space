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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.MyBlogSpace.service.UserService;

@Scope("session")
@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice;
	
	// handler for feed
	
	@RequestMapping(path="/feed",method = RequestMethod.GET)
	public String feed(HttpServletRequest request,HttpSession session,
			Model model) {
		
		System.out.print("feed page");
		System.out.println(this);
		
		session = request.getSession(true);
		String user_name = (String)session.getAttribute("user_name");
		
		System.out.println(user_name);
        
        LinkedHashMap<String, List<List<String>>> all_blog_details = this.userservice.getAllBlogdetails();
        
        model.addAttribute("blogs", all_blog_details);
        
        
       
        return "feed";
	}
	
	// see all my blogs
	
	@RequestMapping(path="/myblogs",method = RequestMethod.GET)
	public String myBlogs(HttpServletRequest request,
			HttpSession session,Model model) {
		System.out.print("myblogs page");
		
		session = request.getSession(true);
		String user_name = (String)session.getAttribute("user_name");
		
		LinkedHashMap<String, List<List<String>>> user_blog_details = this.userservice.getUserBlogdetails(user_name);
        
        model.addAttribute("blogs", user_blog_details);
        
		return "myblogs";
	}
	
	// view a blog
	
	@RequestMapping(path="/viewblog",method = RequestMethod.GET)
	public String viewBlog(@RequestParam String blog_id,
		    Model model) {
		
		List<String> temp = this.userservice.getblogdetails(blog_id);
		
		model.addAttribute("blog", temp);
		
		System.out.print("timeline page");
		return "blogview";
	}
	
	// edit a blog
	
	@RequestMapping(path="/editblog",method = RequestMethod.GET)
	public String editBlog(@RequestParam String blog_id,
			Model model) {
		
		System.out.print("edit page");
		List<String> temp = this.userservice.getblogdetails(blog_id);
		
		model.addAttribute("blog", temp);
		
		return "blogedit";
	}
	
	// edit a blog error
	
	@RequestMapping(path="/editblogerror",method = RequestMethod.GET)
	public String editBlogError(@RequestParam String blog_id,
			@RequestParam String blog_title,
			@RequestParam String blog_topic, 
			@RequestParam int error_type, Model model) {
			
			System.out.print("edit page error");
			List<String> temp = this.userservice.getblogdetails(blog_id);
			
			model.addAttribute("blog", temp);
			model.addAttribute("error_type", error_type);
			
			return "blogediterror";
		}
	
	// update a blog
	
	@RequestMapping(path="/processupdateblogform",method = RequestMethod.POST)
	public String updateBlog(@RequestParam String blog_id,
			@RequestParam("blog_title") String title, 
			@RequestParam("blog_topic") String topic,
			@RequestParam("blog_content") String content, 
			@RequestParam("blog_postimage") CommonsMultipartFile file,
			HttpSession s) throws Exception {
		
		System.out.print("edit page");
		
		
		if( title==null || title.length()==0 )
		{
			return "redirect:/editblogerror" + "?blog_id=" + blog_id + "&error_type=0";
		}
			
		if(title.length()>60)
		{
			return "redirect:/editblogerror" + "?blog_id=" + blog_id + "&error_type=1";
		}
			
		if( content==null || content.length()==0 )
		{
			return "redirect:/editblogerror" + "?blog_id=" + blog_id + "&error_type=2";
		}
				
		if(content.length()>7500)
		{
			return "redirect:/editblogerror" + "?blog_id=" + blog_id + "&error_type=3";
		}
			
		if( file!=null && file.isEmpty()==false && file.getSize() > 5242880 )
		{
			return "redirect:/editblogerror" + "?blog_id=" + blog_id + "&error_type=4";
		}
			
		if( file!=null && file.isEmpty()==false && file.getContentType().contains("image")==false )
		{
			return "redirect:/editblogerror" + "?blog_id=" + blog_id + "&error_type=5";
		}
		
		String path = s.getServletContext().getRealPath("/");
		
		this.userservice.updateblog(title, topic, content, file, path, blog_id);
		
		return "redirect:/myblogs";
		
	}
	
	// delete a blog
	
	@RequestMapping(path="/deleteblog",method = RequestMethod.GET)
	public String deleteBlog(@RequestParam String blog_id,
			HttpServletRequest request,
			HttpSession session,
		    Model model) {
		
		System.out.println("delete blog page");
		
		// get user name and path
		
		session = request.getSession(true);
		String user_name = (String)session.getAttribute("user_name");
		String path = session.getServletContext().getRealPath("/");
		
		this.userservice.deleteblog(user_name,blog_id, path);
		
		return "redirect:/myblogs";
	}
	
	// create a new blog
	
	@RequestMapping(path="/newblog",method = RequestMethod.GET)
	public String newBlog(Model model) {
		System.out.print("new blog page");
		return "newblog";
	}
	
	// process new blog form action
	
	@RequestMapping(path="/processnewblogform", method=RequestMethod.POST)
	public String handleNewBlogForm(@RequestParam("blog_title") String title, 
			@RequestParam("blog_topic") String topic,
			@RequestParam("blog_content") String content, 
			@RequestParam("blog_postimage") CommonsMultipartFile file,
			HttpServletRequest request,
			HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		
		System.out.print("insid enew blog form");
		
		// title content not empty
		
		if( title==null || title.length()==0 )
		{
			redirectAttributes.addFlashAttribute("blog_title",title );
			redirectAttributes.addFlashAttribute("blog_content",content );
			return "redirect:/newblogerror?error_type=0";
		}
			
		if(title.length()>60)
		{
			redirectAttributes.addFlashAttribute("blog_title",title );
			redirectAttributes.addFlashAttribute("blog_content",content );
			return "redirect:/newblogerror?error_type=1";
		}
			
		if( content==null || content.length()==0 )
		{
			redirectAttributes.addFlashAttribute("blog_title",title );
			redirectAttributes.addFlashAttribute("blog_content",content );
			return "redirect:/newblogerror?error_type=2";
		}
				
		if(content.length()>7500)
		{
			redirectAttributes.addFlashAttribute("blog_title",title );
			redirectAttributes.addFlashAttribute("blog_content",content );
			return "redirect:/newblogerror?error_type=3";
		}
			
		if( file==null || file.isEmpty()==true )
		{
			redirectAttributes.addFlashAttribute("blog_title",title );
			redirectAttributes.addFlashAttribute("blog_content",content );
			return "redirect:/newblogerror?error_type=4";
		}
			
		if(file.getSize() > 5242880)
		{
			redirectAttributes.addFlashAttribute("blog_title",title );
			redirectAttributes.addFlashAttribute("blog_content",content );
			return "redirect:/newblogerror?error_type=5";
		}
			
		
		if( file.getContentType().contains("image")==false )
		{
			redirectAttributes.addFlashAttribute("blog_title",title );
			redirectAttributes.addFlashAttribute("blog_content",content );
			return "redirect:/newblogerror?error_type=6";
		}
		
		
		session = request.getSession(true);
		String user_name = (String)session.getAttribute("user_name");
		
		String path = session.getServletContext().getRealPath("/");
		this.userservice.addNewBlog(user_name,title,topic,content,file,path);
		System.out.print(user_name);
		return "redirect:/myblogs";
	}
	
	// new blog error
	
	@RequestMapping(path="/newblogerror",method = RequestMethod.GET)
	public String newBlogError(HttpServletRequest request,
			@RequestParam int error_type,
			Model model) {
		System.out.print("new blog error page");
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
		String blog_title="";
		String blog_content="";
        
        if(flashMap != null)
        {
        	blog_title = (String) flashMap.get("blog_title");
        	blog_content = (String) flashMap.get("blog_content");
        	
        }
        
		model.addAttribute("blog_title", blog_title);
		model.addAttribute("blog_content", blog_content);
		model.addAttribute("error_type", error_type);
		return "newblogerror";
	}
	
	// profile
	
	@RequestMapping(path="/profile",method = RequestMethod.GET)
	public String profile(HttpServletRequest request, HttpSession session, Model model) {
		System.out.print("myblogs page");
		
		session = request.getSession(true);
		String user_name = (String)session.getAttribute("user_name");
		System.out.print(user_name);
        
		int blogs = this.userservice.getBlogNumber(user_name);
        model.addAttribute("user_name", user_name);
        model.addAttribute("blogs", blogs);
        
		return "profile";
	}
	
	// logout
	
	@RequestMapping(path="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.print("logout page");
		session.invalidate();
        
		return "redirect:/";
	}
	
	// delete
	
	@RequestMapping(path="/deleteaccount",method = RequestMethod.GET)
	public String delete(HttpServletRequest request, HttpSession session) {
		
		System.out.print("logout page");
		session = request.getSession(true);
		String user_name = (String)session.getAttribute("user_name");
		System.out.print(user_name);
		
		String path = session.getServletContext().getRealPath("/");
		
        this.userservice.deleteAccount(user_name,path);
		return "redirect:/";
	}

}
