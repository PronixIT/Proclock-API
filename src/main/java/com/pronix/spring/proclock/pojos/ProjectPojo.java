package com.pronix.spring.proclock.pojos;

public class ProjectPojo {
	
	private Long projectId;
	private String projectName;
	private String projectCode;
	private String projectVendor;
	private String projectStartDate;
	private String projectDuration;
	private String description;
	private Long companyId;
	
	public ProjectPojo() {
		super();
	}
	
	public ProjectPojo(String projectName, String projectCode, String projectVendor, String projectStartDate,
			String projectDuration, String description, Long companyId) {
		super();
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.projectVendor = projectVendor;
		this.projectStartDate = projectStartDate;
		this.projectDuration = projectDuration;
		this.description = description;
		this.companyId = companyId;
	}
	
	
	public ProjectPojo(Long projectId, String projectName, String projectCode, String projectVendor,
			String projectStartDate, String projectDuration, String description, Long companyId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.projectVendor = projectVendor;
		this.projectStartDate = projectStartDate;
		this.projectDuration = projectDuration;
		this.description = description;
		this.companyId = companyId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectVendor() {
		return projectVendor;
	}
	public void setProjectVendor(String projectVendor) {
		this.projectVendor = projectVendor;
	}
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjectDuration() {
		return projectDuration;
	}
	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}
