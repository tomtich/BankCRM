package com.bank.crm.service;

import com.bank.crm.dao.BankDao;

public class BankServiceImpl implements BankService {

	private BankDao bankDao;
	
	public String acceptCustomer(int cid) {
		return bankDao.acceptCustomer(cid);
	}

	public String rejectCustomer(int cid) {
		return bankDao.rejectCustomer(cid);
	}

}
