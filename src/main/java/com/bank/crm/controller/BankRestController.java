package com.bank.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.crm.service.BankService;
import com.web.bank.controller.model.CustomerForm;

@RestController
public class BankRestController {

	@Autowired
	@Qualifier("BankServiceImpl")
	private BankService bankService;
	
	@RequestMapping(value="teamLeaderHomeAgents", method=RequestMethod.GET,
			produces = {"application/json"})
	@ResponseBody public List<String> showOnlineAgents() {
		List<String> agentList = bankService.showOnlineAgents();
		for (String agent : agentList) { //for testing purposes
			System.out.println(agent);
		}
		return agentList;
	}
	
	@RequestMapping(value="teamLeaderHomeCustomers", method=RequestMethod.GET,
			produces = {"application/json"})
	@ResponseBody public List<CustomerForm> showAcceptedCustomers() {
		List<CustomerForm> customerList = bankService.showAcceptedCustomers();
		for (CustomerForm cf : customerList) { //for testing purposes
			System.out.println(cf.getName());
		}
		return customerList;
	}
}
