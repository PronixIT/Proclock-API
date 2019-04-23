package com.pronix.spring.proclock.pojos;

public class LoginStatusRes {
	
	private String status;
	private String statusCode;
	private String statusMsg;
	private Object userDetails;
	private String userRole;
	
	public LoginStatusRes() {
		super();
	}
	
	public LoginStatusRes(String status, String statusCode, String statusMsg, Object userDetails, String userRole) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
		this.userDetails = userDetails;
		this.userRole = userRole;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public Object getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Object userDetails) {
		this.userDetails = userDetails;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
