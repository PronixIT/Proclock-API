package com.pronix.spring.proclock.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "poject_assignment")
public class ProjectAssignment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails userDetails;
	
	@ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
	private Company company;
	
	@ManyToMany
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private List<Project> projectList;
	
	@ManyToMany
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
	private List<Manager> managerList;
	
	@ManyToOne
    @JoinColumn(name = "assigned_user_id", referencedColumnName = "user_id")
    private UserDetails assignedUserDetails;
	
	@Column(nullable = false)
	private Date assignedDate;

	public ProjectAssignment() {
		super();
	}

	public ProjectAssignment(long id, UserDetails userDetails, Company company, List<Project> projectList, List<Manager> managerList,
			UserDetails assignedUserDetails, Date assignedDate) {
		super();
		this.id = id;
		this.userDetails = userDetails;
		this.company = company;
		this.projectList = projectList;
		this.managerList = managerList;
		this.assignedUserDetails = assignedUserDetails;
		this.assignedDate = assignedDate;
	}
	
	public ProjectAssignment(UserDetails userDetails, Company company, List<Project> projectList,List<Manager> managerList,
			UserDetails assignedUserDetails) {
		super();
		this.userDetails = userDetails;
		this.company = company;
		this.projectList = projectList;
		this.managerList = managerList;
		this.assignedUserDetails = assignedUserDetails;
		this.assignedDate = new Date();
	}
	
	/*public ProjectAssignment(UserDetails userDetails, Company company) {
		super();
		this.userDetails = userDetails;
		this.company = company;
	}

	public ProjectAssignment(long id, UserDetails userDetails, Company company) {
		super();
		this.id = id;
		this.userDetails = userDetails;
		this.company = company;
	}

	public ProjectAssignment(long id, UserDetails userDetails, List<Project> projectList, List<Manager> managerList) {
		super();
		this.id = id;
		this.userDetails = userDetails;
		this.projectList = projectList;
		this.managerList = managerList;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Manager> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<Manager> managerList) {
		this.managerList = managerList;
	}

}
