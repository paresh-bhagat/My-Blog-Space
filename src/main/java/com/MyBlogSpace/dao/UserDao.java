package com.MyBlogSpace.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.model.BlogList;

@Transactional
@Repository
public class UserDao {
	
    private SessionFactory sessionFactory;
	
    //setSessionFactory
    
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
	
	//check if userid is present
	
	public int check_userid(String user_name) {
		
		Session session=this.sessionFactory.getCurrentSession();
		UserInfo usr_info = session.get(UserInfo.class, user_name);
		
		if(usr_info == null)
			return 0;
		return 1;
		
	}
	
	//add a new account
	
	@Transactional
	public void add_new_account(UserInfo user) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	// get user password of a user

	public String get_userpassword(String usr_name) {
		
		Session session = this.sessionFactory.getCurrentSession();
		UserInfo temp =  session.get(UserInfo.class, usr_name);
		return temp.getUser_password();
	}
	
	// change password of a user
	
	@Transactional
	public void change_password(String passwordTyped, String usr_name) {
		
		Session session = this.sessionFactory.getCurrentSession();
		UserInfo temp =  session.get(UserInfo.class, usr_name);
		temp.setUser_password(passwordTyped);
		session.update(temp);
	}
	
	// get all blogs of a user

	public List<BlogList> get_all_blogs_user(String usr_name) {
		
		Session session = this.sessionFactory.getCurrentSession();
		UserInfo temp =  session.get(UserInfo.class, usr_name);
		
		return temp.getBlogs();
	}
	
	// get all blogs for feed page
	
	public List<BlogList> get_all_blogs() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		return session.createQuery("SELECT a FROM BlogList a", BlogList.class).getResultList();
		
	}
	
	// remove user and all blogs
	
	@Transactional
	public void remove_user(String usr_name) {
		
		Session session = this.sessionFactory.getCurrentSession();
		UserInfo temp = session.get(UserInfo.class, usr_name);
		
		session.delete(temp);
	}
	
	// get all details of a blog
	
	public BlogList get_blog_details(String blog_id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		BlogList temp = session.get(BlogList.class, Integer.parseInt(blog_id));
		
		return temp;
	}
	
	// delete a blog
	
	@Transactional
	public void delete_blog(String user_id, String blog_id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		UserInfo temp = session.get(UserInfo.class, user_id);
		
		List<BlogList> blogs_list = temp.getBlogs();
		
		int i=0;
		
		for(;i<blogs_list.size();i++) {
			
			if( blogs_list.get(i).getId() == Integer.parseInt(blog_id))
				break;
			
		}
		
		temp.remove_blog(i);
		
		session.update(temp);
	}
	
	// add a new blog
	@Transactional
	public void add_blog(String usr_name, BlogList blog ) throws ParseException {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		UserInfo temp = session.get(UserInfo.class, usr_name);
		blog.setUser_info(temp);
		
		temp.add_blog(blog);
		
		session.update(temp);
	}
	
	// update a blog
	
	@Transactional
	public void update_blog(String blog_title, String blog_topic,String blog_content, Date blog_date, 
			 String blog_id ) throws ParseException {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		BlogList temp = session.get(BlogList.class, Integer.parseInt(blog_id));
		
		temp.update_blog(blog_title, blog_topic, blog_content, blog_date);
		
		session.update(temp);
	}
	
	// get the id of the blog
	
	public String getBlogId(String user_id, String blog_name, String blog_topic, Date date){
		
		Session session = this.sessionFactory.getCurrentSession();
		
		UserInfo temp = session.get(UserInfo.class, user_id);
		
		List<BlogList> blog_list = temp.getBlogs();
		
		int i=0;
		
		System.out.print(blog_list.size());
		
		for(;i<blog_list.size();i++) {
			
			if( blog_list.get(i).getBlog_title().equals(blog_name) && blog_list.get(i).getBlog_topic().equals(blog_topic) 
					&& (blog_list.get(i).getBlog_date().compareTo(date)==0) )
				break;
			
		}
		
		if(i>=blog_list.size())
		{
			System.out.print("something failed");
			return "0";
		}
			
		return Integer.toString(blog_list.get(i).getId());
	}

	// get number of blogs by a user
	
	public int getBlogNumber(String user_name) {
		
		Session session = this.sessionFactory.getCurrentSession();
		UserInfo temp = session.get(UserInfo.class, user_name);
		return temp.getBlogs().size();
	}

}
