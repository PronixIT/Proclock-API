package com.pronix.spring.proclock.pojos;

public class ManagerStatusReportPojo {
	
	private long managerId;
	private String managerName;
	private String companyName;
	private String projectname;
	private String vendorName;
	private long noOfWeeks;
	
	public ManagerStatusReportPojo() {
		super();
	}

	public ManagerStatusReportPojo(long managerId, String managerName, String companyName, String projectname,
			String vendorName, long noOfWeeks) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.companyName = companyName;
		this.projectname = projectname;
		this.vendorName = vendorName;
		this.noOfWeeks = noOfWeeks;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public long getNoOfWeeks() {
		return noOfWeeks;
	}

	public void setNoOfWeeks(long noOfWeeks) {
		this.noOfWeeks = noOfWeeks;
	}

}
