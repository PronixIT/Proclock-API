package com.pronix.spring.proclock.pojos;

public class Employee {
	
	private long userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String emailId;
	private String phoneNo;
	private long companyId;
	private String companyName;
	private long projectId;
	private String projectName;
	private String vendorName;
	private long managerId;
	private String managerName;
	private long createdBy;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String userName, String emailId, String phoneNo, long companyId,
			long projectId, long managerId, long createdBy) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.companyId = companyId;
		this.projectId = projectId;
		this.managerId = managerId;
		this.createdBy = createdBy;
	}
	
	public Employee(long userId, String firstName, String lastName, String userName, String emailId, String phoneNo,
			long companyId, String companyName, long projectId, String projectName, String vendorName, long managerId,
			String managerName, long createdBy) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.companyId = companyId;
		this.companyName = companyName;
		this.projectId = projectId;
		this.projectName = projectName;
		this.vendorName = vendorName;
		this.managerId = managerId;
		this.managerName = managerName;
		this.createdBy = createdBy;
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
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
}
