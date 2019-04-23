package com.pronix.spring.proclock.pojos;

public class UserDashboardData {
	
	private long countOfPendingTimesheets;
	private long countOfAcceptedTimesheets;
	private long countOfRejectedTimesheets;
	
	public UserDashboardData() {
		super();
	}
	
	public UserDashboardData(long countOfPendingTimesheets, long countOfAcceptedTimesheets,
			long countOfRejectedTimesheets) {
		super();
		this.countOfPendingTimesheets = countOfPendingTimesheets;
		this.countOfAcceptedTimesheets = countOfAcceptedTimesheets;
		this.countOfRejectedTimesheets = countOfRejectedTimesheets;
	}
	
	public long getCountOfPendingTimesheets() {
		return countOfPendingTimesheets;
	}
	public void setCountOfPendingTimesheets(long countOfPendingTimesheets) {
		this.countOfPendingTimesheets = countOfPendingTimesheets;
	}
	public long getCountOfAcceptedTimesheets() {
		return countOfAcceptedTimesheets;
	}
	public void setCountOfAcceptedTimesheets(long countOfAcceptedTimesheets) {
		this.countOfAcceptedTimesheets = countOfAcceptedTimesheets;
	}
	public long getCountOfRejectedTimesheets() {
		return countOfRejectedTimesheets;
	}
	public void setCountOfRejectedTimesheets(long countOfRejectedTimesheets) {
		this.countOfRejectedTimesheets = countOfRejectedTimesheets;
	}
}
