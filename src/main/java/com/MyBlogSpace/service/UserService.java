package com.MyBlogSpace.service;

import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.model.BlogList;

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
	
	public boolean checkuser(String user_id,String user_password) {
		
		if(this.userdao.check_userid(user_id) == 1 && 
				this.userdao.get_userpassword(user_id).equals(user_password) ) {
			return true;
		}
		
		return false;
	}
	
	// check if user can be added. return true if yes otherwise no.

	public boolean addnewuser(UserInfo user) {
		
		if(userdao.check_userid(user.getUser_id()) == 0 )
		{
			this.userdao.add_new_account(user);
			return true;
		}
		return false;
	}
	
	// add new blog 
	
	public void addNewBlog(String user_id, String blog_name, String blog_topic, 
			String blog_content, CommonsMultipartFile file, String path) throws Exception {
		
		BlogList temp = new BlogList();
		
		temp.setBlog_name(blog_name);
		temp.setBlog_topic(blog_topic);
		temp.setBlog_details(blog_content);
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
	    Date date = new Date();
	    
	    temp.setBlog_date(date);
		
		this.userdao.add_blog(user_id, temp);
		
		String num = this.userdao.getBlogId(user_id,blog_name,blog_topic);
		// convert imgae to byte data
		
		byte[] data = file.getBytes();
		
		FileOutputStream fos;
		
		String imagepath =  path + "resources" + File.separator + "blog_images" + File.separator + num + ".jpg";
		
		System.out.print(imagepath);
		
		fos = new FileOutputStream(imagepath);
		
		fos.write(data);
		
		fos.close();
	}
	
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
			temp.add(blog_list.get(i).getBlog_name());
			temp.add(blog_list.get(i).getUser_info().getUser_id());
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
	
	public LinkedHashMap<String, List<List<String>>> getUserBlogdetails(String user_id) {
		
		List<BlogList> temp = this.userdao.get_all_blogs_user(user_id);
		
		return sortMapUsingList(temp);
	}
		
	}

