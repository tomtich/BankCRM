package com.bank.crm.entity.form;

public class AgentCustomerAssignmentForm {
	
	private String agentUsername;
	private String customerName;
	private int status; //0 or 1; 0 = Agent is ready to be assigned to a new Customer, 1 = not ready
	
	public String getAgentUsername() {
		return agentUsername;
	}
	public void setAgentUsername(String agentUsername) {
		this.agentUsername = agentUsername;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "AgentCustomerAssignmentForm [agentUsername=" + agentUsername + ", customerName=" + customerName
				+ ", status=" + status + "]";
	}
}
