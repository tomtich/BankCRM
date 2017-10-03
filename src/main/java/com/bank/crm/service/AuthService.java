package com.bank.crm.service;

public interface AuthService {

	public String authenticateUser(String username, String password);
	
	public String authorizeUser(String username, String password);
}
