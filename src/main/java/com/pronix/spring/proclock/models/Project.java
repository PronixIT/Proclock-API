package com.pronix.spring.proclock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "project_id")
	private long projectId;
	
	@Column(nullable = false)
	private String projectName;
	
	@Column(nullable = false)
	private String projectCode;
	
	@Column(nullable = false)
	private String projectVendor;
	
	private String projectStartDate;
	
	private String projectDuration;
	
	private String description;
	
	@ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
	private Company company;

	public Project() {
		super();
	}

	public Project(String projectName, String projectCode, String projectVendor, String projectStartDate,
			String projectDuration, String description, Company company) {
		super();
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.projectVendor = projectVendor;
		this.projectStartDate = projectStartDate;
		this.projectDuration = projectDuration;
		this.description = description;
		this.company = company;
	}

	public Project(long projectId, String projectName, String projectCode, String projectVendor, String projectStartDate,
			String projectDuration, String description, Company company) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.projectVendor = projectVendor;
		this.projectStartDate = projectStartDate;
		this.projectDuration = projectDuration;
		this.description = description;
		this.company = company;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
	
	

}
