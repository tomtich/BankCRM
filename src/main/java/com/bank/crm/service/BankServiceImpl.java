package com.bank.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.crm.dao.BankDao;
import com.web.bank.controller.model.CustomerForm;
import com.bank.crm.entity.Customer;
import com.bank.crm.entity.User;
import com.bank.crm.entity.form.UserForm;

@Service("BankServiceImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class BankServiceImpl implements BankService {

	@Autowired
	@Qualifier("BankDaoImpl")
	private BankDao bankDao;
	
	public String acceptCustomer(int cid) {
		return bankDao.acceptCustomer(cid);
	}

	public String rejectCustomer(int cid) {
		return bankDao.rejectCustomer(cid);
	}

	public List<CustomerForm> showPendingCustomers() {
		System.out.println("In service layer");
		List<Customer> customerList = bankDao.showPendingCustomers();
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>();
		for (Customer customer : customerList) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customer, customerForm);
			customerFormList.add(customerForm);
		}
		return customerFormList;
	}

	public List<CustomerForm> showAcceptedCustomers() {
		List<Customer> customerList = bankDao.showAcceptedCustomers(); //get the Customers
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>(); //make a list of CustomerForms
		for (Customer customer : customerList) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customer, customerForm); //transfer properties of each Customer to CustomerForms
			customerFormList.add(customerForm); //populate the CustomerForm list
		}
		return customerFormList;
	}

	public List<String> showOnlineAgents() {
		List<String> agentList = bankDao.showOnlineAgents(); //get the Agents
//		List<UserForm> userFormList = new ArrayList<UserForm>(); //make a list of UserForms
//		for (User agent : agentList) {
//			UserForm userForm = new UserForm();
//			BeanUtils.copyProperties(agent, userForm); //transfer properties of each Agent to UserForms
//			userFormList.add(userForm); //populate the CustomerForm list
//		}
//		return userFormList;
		return agentList;
	}

}
