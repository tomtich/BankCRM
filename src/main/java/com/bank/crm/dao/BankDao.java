package com.bank.crm.dao;

import java.util.List;

import com.bank.crm.entity.Customer;

public interface BankDao {
	
	//Accepts a Customer's loan request
	public String acceptCustomer(int cid);
	
	//Rejects a Customer's loan request
	public String rejectCustomer(int cid);
	
	public List<Customer> showPendingCustomers();

}
