package com.pronix.spring.proclock.pojos;

public class ManagerPojo {
	
	private long managerId;
	private String managerName;
	private String managerEmail;
	private boolean isAuth;
	private long projectId;
	
	public ManagerPojo() {
		super();
	}
	public ManagerPojo(long managerId, String managerName, String managerEmail, boolean isAuth,
			long projectId) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.isAuth = isAuth;
		this.projectId = projectId;
	}
	public ManagerPojo(String managerName, String managerEmail, boolean isAuth, long projectId) {
		super();
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.isAuth = isAuth;
		this.projectId = projectId;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setId(long managerId) {
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
	public boolean getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	

}
