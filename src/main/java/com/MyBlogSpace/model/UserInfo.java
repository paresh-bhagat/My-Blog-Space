package com.MyBlogSpace.model;

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
	@Column(length=20,name="User_Name")
	private String user_name;
	
	@Column(length=20,name="User_Password")
	private String user_password;
	
	@OneToMany(mappedBy="user_info",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
	private List<BlogList> blogs;
	

	public UserInfo(String user_name, String user_password, List<BlogList> blogs) {
		super();
		this.user_name = user_name;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	// add blog
	
	public void add_blog(BlogList blog)
	{
		this.blogs.add(blog);
	}
	
	// remove blog
	public void remove_blog(int i)
	{
		this.blogs.remove(i);
	}
	

	@Override
	public String toString() {
		return "UserInfo [user_name=" + user_name + ", user_password=" + user_password + ", blogs=" + blogs + "]";
	}
	

}
