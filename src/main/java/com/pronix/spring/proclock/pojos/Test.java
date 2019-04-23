package com.pronix.spring.proclock.pojos;

public class Test {
	
	private String practiceName;
	private String crmIt;
	private String dbName;
	private String userName;
	private String password;
	public Test() {
		super();
	}
	public Test(String practiceName, String crmIt, String dbName, String userName, String password) {
		super();
		this.practiceName = practiceName;
		this.crmIt = crmIt;
		this.dbName = dbName;
		this.userName = userName;
		this.password = password;
	}
	public String getPracticeName() {
		return practiceName;
	}
	public void setPracticeName(String practiceName) {
		this.practiceName = practiceName;
	}
	public String getCrmIt() {
		return crmIt;
	}
	public void setCrmIt(String crmIt) {
		this.crmIt = crmIt;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
