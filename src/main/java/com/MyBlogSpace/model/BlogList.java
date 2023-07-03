package com.MyBlogSpace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Blog_List")
public class BlogList {
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(length=70,name="Blog_Title")
	private String blog_title;
	
	@Column(length=60,name="Blog_Topic")
	private String blog_topic;
	
	@Column(length=7500,name="Blog_Content")
	private String blog_content;

	@Column(name="Blog_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date blog_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user_info;
	
	@Override
	public String toString() {
		return "BlogList [id=" + id + ", blog_title=" + blog_title + ", blog_topic=" + blog_topic + ", blog_content="
				+ blog_content + ", blog_date=" + blog_date + ", user_info=" + user_info + "]";
	}

	public BlogList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogList(int id, String blog_title, String blog_topic, String blog_content, Date blog_date,
			UserInfo user_info) {
		super();
		this.id = id;
		this.blog_title = blog_title;
		this.blog_topic = blog_topic;
		this.blog_content = blog_content;
		this.blog_date = blog_date;
		this.user_info = user_info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getBlog_topic() {
		return blog_topic;
	}

	public void setBlog_topic(String blog_topic) {
		this.blog_topic = blog_topic;
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}

	public Date getBlog_date() {
		return blog_date;
	}

	public void setBlog_date(Date blog_date) {
		this.blog_date = blog_date;
	}

	public UserInfo getUser_info() {
		return user_info;
	}

	public void setUser_info(UserInfo user_info) {
		this.user_info = user_info;
	}
	
	// update blog
	public void update_blog(String new_blog_title, String new_blog_topic,String new_blog_content,
			Date new_blog_date ) {
			this.blog_title = new_blog_title;
			this.blog_content = new_blog_content;
			this.blog_topic = new_blog_topic;
			this.blog_date = new_blog_date;
	}

}

