package com.MyBlogSpace.service;

import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.model.BlogList;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.MyBlogSpace.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	//check if user entered values during sigin is correct
	
	public boolean checkuser(String user_name,String user_password) {
		
		if(this.userdao.check_userid(user_name) == 1 && 
				this.userdao.get_userpassword(user_name).equals(user_password) ) {
			return true;
		}
		
		return false;
	}
	
	// check if user can be added. return true if yes otherwise no.

	public boolean addnewuser(UserInfo user) {
		
		if(userdao.check_userid(user.getUser_name()) == 0 )
		{
			this.userdao.add_new_account(user);
			return true;
		}
		return false;
	}
	
	// add new blog 
	
	public void addNewBlog(String user_name, String blog_title, String blog_topic, 
			String blog_content, CommonsMultipartFile file, String path) throws Exception {
		
		BlogList temp = new BlogList();
		
		temp.setBlog_title(blog_title);
		temp.setBlog_topic(blog_topic);
		temp.setBlog_content(blog_content);
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
	    Date date = new Date();
	    
	    temp.setBlog_date(date);
		
		this.userdao.add_blog(user_name, temp);
		
		String num = this.userdao.getBlogId(user_name,blog_title,blog_topic,date);
		// convert imgae to byte data
		
		byte[] data = file.getBytes();
		
		FileOutputStream fos;
		
		String imagepath =  path + "resources" + File.separator + "images" + File.separator + num + ".jpg";
		
		System.out.print(imagepath);
		
		fos = new FileOutputStream(imagepath);
		
		fos.write(data);
		
		fos.close();
	}
	
	// this is used for sorting blog details to be shown to user in feed
	
	public LinkedHashMap<String, List<List<String>>> sortMapUsingList(List<BlogList> blog_list){
		
		
		HashMap<String,List<List<String>>> map = new HashMap<String,List<List<String>>>();
		
		map.put("Other",new ArrayList<List<String>>() );
		map.put("Technology",new ArrayList<List<String>>() );
		map.put("Movies",new ArrayList<List<String>>() );
		map.put("Health",new ArrayList<List<String>>() );
		map.put("Food",new ArrayList<List<String>>() );
		map.put("Science",new ArrayList<List<String>>() );
		map.put("Music",new ArrayList<List<String>>() );
		map.put("Books",new ArrayList<List<String>>() );
		map.put("Travel",new ArrayList<List<String>>() );
		map.put("Business",new ArrayList<List<String>>() );
		map.put("Politics",new ArrayList<List<String>>() );
		map.put("Fashion",new ArrayList<List<String>>() );
		
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		
		for (int i = 0; i < blog_list.size(); i++) {
			
			List<String> temp = new ArrayList<String>();
			
			temp.add( Integer.toString(blog_list.get(i).getId()));
			temp.add(blog_list.get(i).getBlog_title());
			temp.add(blog_list.get(i).getUser_info().getUser_name());
			temp.add(formatDate.format(blog_list.get(i).getBlog_date()));
			
			map.get(blog_list.get(i).getBlog_topic()).add(temp);
        }
		
		System.out.println(map);
		
		Comparator<List<List<String>>> bylistsize = 
	        		(List<List<String>> l1, List<List<String>> l2) -> Integer.compare(l1.size(),l2.size());
	        		
	    LinkedHashMap<String, List<List<String>>> sortedMap = map.entrySet()
	    		.stream()
	    		.sorted(Map.Entry.<String, List<List<String>>>comparingByValue(bylistsize.reversed()))
	    		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	    System.out.println(sortedMap);

		return sortedMap;
		
	}
	
	public LinkedHashMap<String, List<List<String>>> getAllBlogdetails() {
		
		List<BlogList> temp = this.userdao.get_all_blogs();
		
		return sortMapUsingList(temp);
	}
	
	public LinkedHashMap<String, List<List<String>>> getUserBlogdetails(String user_name) {
		
		List<BlogList> temp = this.userdao.get_all_blogs_user(user_name);
		
		return sortMapUsingList(temp);
	}

	public List<String> getblogdetails(String blog_id) {
		
		BlogList temp = this.userdao.get_blog_details(blog_id);
		
		List<String> result = new ArrayList<String>();
		
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		
		result.add( Integer.toString(temp.getId()) );
		result.add( temp.getBlog_title() );
		result.add( temp.getBlog_topic() );
		result.add( temp.getBlog_content() );
		result.add( temp.getUser_info().getUser_name());
		result.add( formatDate.format(temp.getBlog_date()) );
		
		return result;
	}
	
	// update blog
	
	public void updateblog(String blog_title, String blog_topic, 
			String blog_content, CommonsMultipartFile file, String path, 
			String blog_id) throws Exception {
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
	    Date date = new Date();
		
		this.userdao.update_blog(blog_title, blog_topic, blog_content, date, blog_id);
		
		String num = blog_id;
		
		if ( file==null || file.isEmpty()==true )
		{
			System.out.print("image not changed");
		}
		else
		{
			
			// first delete previous image
			
			String imagepath =  path + "resources" + File.separator + "images" + File.separator + num + ".jpg";
			
			File fileToDelete = FileUtils.getFile(imagepath);
			
		    boolean success = FileUtils.deleteQuietly(fileToDelete);
		    
		    if(success==false)
		    	System.out.println("file not deleted");
		    
		    // save new image
		    
		    byte[] data = file.getBytes();
		    
		    FileOutputStream fos;
		    
		    System.out.print(imagepath);
		    fos = new FileOutputStream(imagepath);
			
			fos.write(data);
			
			fos.close();
		}
	}
	
	//delete blog
	
	public void deleteblog(String user_name, String blog_id, String path) {
		
		// get id of blog 
		
		String num = blog_id;
		
		this.userdao.delete_blog(user_name, blog_id);
		
		// after deleting blog delete file
		
		String imagepath =  path + "resources" + File.separator + "images" + File.separator + num + ".jpg";
		
		File fileToDelete = FileUtils.getFile(imagepath);
		
	    boolean success = FileUtils.deleteQuietly(fileToDelete);
	    
	    if(success==false)
	    	System.out.println("file not deleted");
		
	}
	
	// remove user and all blogs
	
	public void deleteAccount(String user_name, String path) {
		
		// first delete all images
		
		List<BlogList> temp = this.userdao.get_all_blogs_user(user_name);
		
		for(int i=0 ; i<temp.size() ; i++)
		{
			
			String imagepath =  path + "resources" + File.separator + "images" + File.separator + 
					Integer.toString(temp.get(i).getId()) + ".jpg";
			
			File fileToDelete = FileUtils.getFile(imagepath);
						
			boolean success = FileUtils.deleteQuietly(fileToDelete);
			
			if(success==false)
				System.out.println("unable to delete file something went wrong");
		}
		
		// now delete account
		this.userdao.remove_user(user_name);
	}
	
	// get number of blogs by user
	
	public int getBlogNumber(String user_name) {
		
		return this.userdao.getBlogNumber(user_name);
	}
		
}

