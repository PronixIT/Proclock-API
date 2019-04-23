package com.pronix.spring.proclock.pojos;

public class UserStatusReportPojo {
	
	private long userId;
	private String employeeName;
	private String companyName;
	private String joiningDate;
	private long noOfWeeks;
	
	public UserStatusReportPojo() {
		super();
	}
	
	public UserStatusReportPojo(long userId, String employeeName, String companyName, String joiningDate, long noOfWeeks) {
		super();
		this.userId = userId;
		this.employeeName = employeeName;
		this.companyName = companyName;
		this.joiningDate = joiningDate;
		this.noOfWeeks = noOfWeeks;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public long getNoOfWeeks() {
		return noOfWeeks;
	}
	public void setNoOfWeeks(long noOfWeeks) {
		this.noOfWeeks = noOfWeeks;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
