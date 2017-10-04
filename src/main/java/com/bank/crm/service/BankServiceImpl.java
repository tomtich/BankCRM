package com.bank.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bank.crm.dao.BankDao;
import com.web.bank.controller.model.CustomerForm;
import com.web.bank.model.Customer;

public class BankServiceImpl implements BankService {

	private BankDao bankDao;
	
	public String acceptCustomer(int cid) {
		return bankDao.acceptCustomer(cid);
	}

	public String rejectCustomer(int cid) {
		return bankDao.rejectCustomer(cid);
	}

	public List<CustomerForm> showPendingCustomers() {
		List<Customer> customerList = bankDao.showPendingCustomers();
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>();
		for (Customer customer : customerList) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customer, customerForm);
			customerFormList.add(customerForm);
		}
		return customerFormList;
	}

}
