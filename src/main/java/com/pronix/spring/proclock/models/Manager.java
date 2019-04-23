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
@Table(name = "manager")
public class Manager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private long managerId;
	
	@Column(nullable = false)
	private String managerName;
	
	@Column(nullable = false)
	private String managerEmail;
	
	@Column(nullable = false)
	private boolean isAuth;
	
	@Column(nullable = false)
	private String password;

	@ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;

	public Manager() {
		super();
	}

	public Manager(String managerName, String managerEmail, boolean isAuth, String password, Project project) {
		super();
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.isAuth = isAuth;
		this.password = password;
		this.project = project;
	}

	public Manager(long managerId, String managerName, String managerEmail, boolean isAuth, String password,
			Project project) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.isAuth = isAuth;
		this.password = password;
		this.project = project;
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

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
