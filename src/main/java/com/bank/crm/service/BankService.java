package com.bank.crm.service;

import java.util.List;

import com.bank.crm.entity.AgentCustomerAssignment;
import com.bank.crm.entity.Customer;
import com.bank.crm.entity.User;
import com.bank.crm.entity.form.AgentCustomerAssignmentForm;
import com.bank.crm.entity.form.UserForm;
import com.web.bank.controller.model.CustomerForm;

public interface BankService {

	public String acceptCustomer(int cid);
	
	public String rejectCustomer(int cid);
	
	public List<CustomerForm> showPendingCustomers();
	
	public List<CustomerForm> showAcceptedCustomers();
	
	//Retrieves all Agents that are currently online
	public List<String> showOnlineAgents();
	
	public List<AgentCustomerAssignmentForm> showAssignments();
}
