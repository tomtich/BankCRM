package com.bank.crm.dao;

public interface BankDao {
	
	//Accepts a Customer's loan request
	public String acceptCustomer(int cid);
	
	//Rejects a Customer's loan request
	public String rejectCustomer(int cid);

}
