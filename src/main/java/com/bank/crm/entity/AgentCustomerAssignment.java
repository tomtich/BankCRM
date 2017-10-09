package com.bank.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="AgentCustomerAssignments")
@DynamicUpdate
public class AgentCustomerAssignment {
	
	@Id
	@Column(length=100)
	private String agentUsername;
	
	@Column(length=100)
	private String customerName;
	
	@Column
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
	
}
