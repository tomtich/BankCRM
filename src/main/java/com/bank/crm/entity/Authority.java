package com.bank.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Authorities")
@DynamicUpdate
public class Authority {

	// Create Authorities table
	// Columns: username varchar(100), authority varchar(100)
	// authority = ROLE_BANK_MANAGER, ROLE_ADMIN, ROLE_USER, etc.
	
	@Column(length=100)
	private String username;
	
	@Column(length=50)
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
