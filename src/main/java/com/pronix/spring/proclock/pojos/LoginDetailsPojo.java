package com.pronix.spring.proclock.pojos;

public class LoginDetailsPojo {

	private String emailId;
	private String password;
	
	public LoginDetailsPojo() {
		super();
	}

	public LoginDetailsPojo(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
