package com.bank.crm.dao;

public interface AuthDao {
	
	public String authenticateUser(String username, String password);
	
	public String authorizeUser(String username);

	//public Authority findRoleByUsername(String username);
}
