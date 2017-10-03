package com.bank.crm.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.bank.crm.entity.Authority;
import com.bank.crm.entity.User;

public class AuthDaoImpl extends HibernateDaoSupport implements AuthDao {

	//Authenticate the user logging in to make sure their username and password are correct
	public String authenticateUser(String username, String password) {
		String result = "";
		List<User> userList = (List<User>) super.getHibernateTemplate()
				.find("from User where username=? and password=?", username, password);
		if (userList.isEmpty()) {
			return result;
		} else {
			result = userList.get(0).getUsername();
		}
		return result;
	}

	//Authorize the user to make sure the user logging in has authority to access a specific resource
	public String authorizeUser(String username) {
		String result = "";
		List<Authority> authList = (List<Authority>) super.getHibernateTemplate()
				.find("from Authority where username=?", username);
		String authority = authList.get(0).getAuthority();
		return authority;
	}

}
