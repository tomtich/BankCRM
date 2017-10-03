package com.bank.crm.service;

import org.springframework.transaction.annotation.Transactional;

import com.bank.crm.dao.AuthDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service("AuthServiceImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	@Qualifier("AuthDaoImpl")
	private AuthDao authDao;

	public String authenticateUser(String username, String password) {
		return authDao.authenticateUser(username, password);
	}

	public String authorizeUser(String username, String password) {
		return authDao.authorizeUser(username);
	}

}
