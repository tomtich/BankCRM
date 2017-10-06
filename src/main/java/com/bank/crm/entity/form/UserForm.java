package com.bank.crm.entity.form;

public class UserForm {
	
	private String username;
	private String password;
	private int enabled; // possible values are 0 or 1, any user with value 1 can login
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
