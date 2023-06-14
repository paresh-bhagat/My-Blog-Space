package com.MyBlogSpace.service;

import com.MyBlogSpace.model.UserInfo;
import com.MyBlogSpace.model.BlogList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
