package com.bank.crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bank.crm.entity.Customer;

@Repository("BankDaoImpl")
@Scope("singleton")
@Transactional
public class BankDaoImpl extends HibernateDaoSupport implements BankDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setBankSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

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

	public List<Customer> showPendingCustomers() {
		List<Customer> customerList = 
				(List<Customer>) super.getHibernateTemplate().find("from Customer where status=?", "Pending");
		return customerList;
	}

}
