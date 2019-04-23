package com.pronix.spring.proclock.pojos;

public class CompanyPojo {

	private long companyId;
	private String companyName;
	private String companyAddress;
	private long userId;
	
	public CompanyPojo() {
		super();
	}
	
	public CompanyPojo(String companyName, String companyAddress, long userId) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.userId = userId;
	}
	
	public CompanyPojo(long companyId, String companyName, String companyAddress, long userId) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.userId = userId;
	}
	
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
