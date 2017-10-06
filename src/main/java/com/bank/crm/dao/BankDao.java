package com.bank.crm.dao;

import java.util.List;

import com.bank.crm.entity.Customer;
import com.bank.crm.entity.User;

public interface BankDao {
	
	//Accepts a Customer's loan request
	public String acceptCustomer(int cid);
	
	//Rejects a Customer's loan request
	public String rejectCustomer(int cid);
	
	public List<Customer> showPendingCustomers();
	
	public List<Customer> showAcceptedCustomers();
	
	//Retrieves all Agents that are currently online
	public List<String> showOnlineAgents();

}
