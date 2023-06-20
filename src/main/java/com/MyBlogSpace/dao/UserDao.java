package com.MyBlogSpace.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.model.BlogList;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//check if userid is present
	
	public int check_userid(String userid) {
		
		UserInfo usr_info = this.hibernateTemplate.get(UserInfo.class, userid);
		
		if(usr_info == null)
			return 0;
		return 1;
		
	}
	
	//add a new account
	@Transactional
	public void add_new_account(UserInfo user) {
		
		this.hibernateTemplate.save(user);
	}
	
	// get user password of a user

	public String get_userpassword(String usr_id) {
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_id);
		return temp.getUser_password();
	}
	
	// change password of a user
	@Transactional
	public void change_password(String passwordTyped, String usr_name) {
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		temp.setUser_password(passwordTyped);
		this.hibernateTemplate.update(temp); 
	}
	
	// get all tasks of a user

	public List<String> get_all_blogs_user(String usr_name) {
		
		List<String> result = new ArrayList<String>();
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		
		for(BlogList t:temp.getBlogs())
			result.add(t.getBlog_name());
		
		return result;
	}
	
	// remove user and all tasks
	@Transactional
	public void remove_user(String usr_name) {
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		
		this.hibernateTemplate.delete(temp);
	}
	
	// get all details of a blog
	
	public List<String> get_blog_details(String usr_name, String task) {
		
		List<String> result = new ArrayList<String>();
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		List<BlogList> tasks_list = temp.getBlogs();
		
		int i=0;
		
		for(;i<tasks_list.size();i++) {
			
			if(tasks_list.get(i).getBlog_name().equals(task))
				break;
			
		}
		
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		
		result.add( tasks_list.get(i).getBlog_details() );
		result.add( formatDate.format(tasks_list.get(i).getBlog_date()) );
		result.add( tasks_list.get(i).getBlog_topic() );
		
		return result;
	}
	
	//delete a task
	@Transactional
	public void delete_blog(String usr_name, String task) {
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		
		List<BlogList> tasks_list = temp.getBlogs();
		
		int i=0;
		
		for(;i<tasks_list.size();i++) {
			
			if(tasks_list.get(i).getBlog_name().equals(task))
				break;
			
		}
		
		temp.remove_blog(i);
		
		this.hibernateTemplate.update(temp);
	}
	
	//check if a task exist

	public int check_blog_exist(String usr_name, String new_task) {
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		List<BlogList> tasks_list = temp.getBlogs();
		
		int ans = 0;
		
		for(int i=0;i<tasks_list.size();i++) {
			
			if(tasks_list.get(i).getBlog_name().equals(new_task))
			{
				ans = 1;
				break;
			}	
		}
			
		return ans;
	}
	
	// add a new blog
	@Transactional
	public void add_blog(String usr_name, BlogList blog ) throws ParseException {
		
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		blog.setUser_info(temp);
		
		temp.add_blog(blog);
		
		this.hibernateTemplate.update(temp);
	}
	
	// update a task
	@Transactional
	public void update_blog(String usr_name, String new_blog_name, String blog_details, String blog_date, 
			String blog_topic, String old_blog) throws ParseException {
				
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, usr_name);
		
		List<BlogList> blog_list = temp.getBlogs();
		
		int i=0;
		
		for(;i<blog_list.size();i++) {
			
			if(blog_list.get(i).getBlog_name().equals(old_blog))
				break;
			
		}
		
		temp.update_blog(i, new_blog_name, blog_details, blog_topic, 
				new SimpleDateFormat("dd-MM-yyyy").parse(blog_date));
		
		this.hibernateTemplate.update(temp);
	}
	
	// get the id of the blog
	
	public String getBlogId(String user_id, String blog_name, String blog_topic)
	{
		UserInfo temp = this.hibernateTemplate.get(UserInfo.class, user_id);
		
		List<BlogList> blog_list = temp.getBlogs();
		
		int i=0;
		
		System.out.print(blog_list.size());
		
		for(;i<blog_list.size();i++) {
			
			if( blog_list.get(i).getBlog_name().equals(blog_name) && blog_list.get(i).getBlog_topic().equals(blog_topic) )
				break;
			
		}
		
		if(i>=blog_list.size())
		{
			System.out.print("something failed");
			return "0";
		}
			
		return Integer.toString(blog_list.get(i).getId());
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
