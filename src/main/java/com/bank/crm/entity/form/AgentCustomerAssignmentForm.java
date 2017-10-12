package com.bank.crm.entity.form;

import com.bank.crm.entity.Customer;

public class AgentCustomerAssignmentForm {
	
	private String agentUsername;
	private Customer customer;
	private int status; //0 or 1; 0 = Agent is ready to be assigned to a new Customer, 1 = not ready
	
	public String getAgentUsername() {
		return agentUsername;
	}
	public void setAgentUsername(String agentUsername) {
		this.agentUsername = agentUsername;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "AgentCustomerAssignmentForm [agentUsername=" + agentUsername + ", customer=" + customer
				+ ", status=" + status + "]";
	}
}
