package com.bank.crm.service;

import java.util.List;

import com.bank.crm.entity.Customer;
import com.web.bank.controller.model.CustomerForm;

public interface BankService {

	public String acceptCustomer(int cid);
	
	public String rejectCustomer(int cid);
	
	public List<CustomerForm> showPendingCustomers();
	
	public List<CustomerForm> showAcceptedCustomers();
	
}
