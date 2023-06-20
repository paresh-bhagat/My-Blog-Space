package com.MyBlogSpace.service;

import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.model.BlogList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
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

}
