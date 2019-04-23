package com.pronix.spring.proclock.pojos;

public class UserDetailsPojo {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String emailId;
	private String phoneNo;
	
	public UserDetailsPojo() {
		super();
	}

	public UserDetailsPojo(String firstName, String lastName, String userName, String emailId, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
