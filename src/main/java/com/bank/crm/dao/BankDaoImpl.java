package com.bank.crm.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.web.bank.model.Customer;

public class BankDaoImpl extends HibernateDaoSupport implements BankDao {

	public String acceptCustomer(int cid) {
		List<Customer> customerList = (List<Customer>) super.getHibernateTemplate().find("from Customer where cid=?", cid);
		Customer customer = customerList.get(0);
		customer.setStatus("Accepted");
		super.getHibernateTemplate().update(customer);
		return "accepted";
	}

	public String rejectCustomer(int cid) {
		List<Customer> customerList = (List<Customer>) super.getHibernateTemplate().find("from Customer where cid=?", cid);
		Customer customer = customerList.get(0);
		customer.setStatus("Rejected");
		super.getHibernateTemplate().update(customer);
		return "rejected";
	}

}
