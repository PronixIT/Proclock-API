package com.pronix.spring.proclock.pojos;

public class UserTimeSheetPojo {
	
	private String startDate;
	private String endDate;
	private int monday;
	private int tuesday;
	private int wednesday;
	private int thursday;
	private int friday;
	private int saturday;
	private int sunday;
	private long projectId;
    private long userId;
    private long statusId;
	private String comments;
    private long approvedByUserId;
    
	public UserTimeSheetPojo() {
		super();
	}

	public UserTimeSheetPojo(String startDate, String endDate, int monday, int tuesday, int wednesday, int thursday,
			int friday, int saturday, int sunday, long projectId, long userId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.projectId = projectId;
		this.userId = userId;
	}

	public UserTimeSheetPojo(long statusId, String comments, long approvedByUserId) {
		super();
		this.statusId = statusId;
		this.comments = comments;
		this.approvedByUserId = approvedByUserId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getMonday() {
		return monday;
	}

	public void setMonday(int monday) {
		this.monday = monday;
	}

	public int getTuesday() {
		return tuesday;
	}

	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}

	public int getWednesday() {
		return wednesday;
	}

	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}

	public int getThursday() {
		return thursday;
	}

	public void setThursday(int thursday) {
		this.thursday = thursday;
	}

	public int getFriday() {
		return friday;
	}

	public void setFriday(int friday) {
		this.friday = friday;
	}

	public int getSaturday() {
		return saturday;
	}

	public void setSaturday(int saturday) {
		this.saturday = saturday;
	}

	public int getSunday() {
		return sunday;
	}

	public void setSunday(int sunday) {
		this.sunday = sunday;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public long getApprovedByUserId() {
		return approvedByUserId;
	}

	public void setApprovedByUserId(long approvedByUserId) {
		this.approvedByUserId = approvedByUserId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
    
}
