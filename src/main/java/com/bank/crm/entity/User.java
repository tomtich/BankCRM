package com.bank.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Users")
@DynamicUpdate
public class User {

	
	// Create Users table
	// Columns: username varchar(100), password varchar(100), enabled tinyint (1 or 0)
	// enabled = 1 -> user can access the system
	
	@Id
	private String username;
	
	@Column(length=100)
	private String password;
	
	@Column
	private int enabled;
	
	@Column
	private int status; // indicates whether a user is logged in or not

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
