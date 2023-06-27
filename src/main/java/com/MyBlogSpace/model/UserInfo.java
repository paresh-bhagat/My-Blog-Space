package com.MyBlogSpace.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User_Info")
public class UserInfo {
	
	@Id
	@Column(length=20,name="User_Id")
	private String user_id;
	
	@Column(length=20,name="User_Password")
	private String user_password;
	
	@OneToMany(mappedBy="user_info",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
	private List<BlogList> blogs;
	

	public UserInfo(String user_id, String user_password, List<BlogList> blogs) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.blogs = blogs;
	}

	public List<BlogList> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogList> blogs) {
		this.blogs = blogs;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	// add blog
	
	public void add_blog(BlogList task)
	{
		this.blogs.add(task);
	}
	
	// remove blog
	public void remove_blog(int i)
	{
		this.blogs.remove(i);
	}
	
	// update blog
	public void update_blog(int i, String new_blog_name, String blog_topic,String blog_details,Date blog_date ) {
		this.blogs.get(i).setBlog_name(new_blog_name);
		this.blogs.get(i).setBlog_details(blog_details);
		this.blogs.get(i).setBlog_topic(blog_topic);
		this.blogs.get(i).setBlog_date(blog_date);
	}

	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", user_password=" + user_password + ", blogs=" + blogs + "]";
	}
	

}
