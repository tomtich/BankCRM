package com.bank.crm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="AgentCustomerAssignments")
@DynamicUpdate
public class AgentCustomerAssignment implements Serializable {
	
	@Column(length=100)
	private String agentUsername;
	
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cid")
	private Customer customer;
	
	@Column
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
	
}
