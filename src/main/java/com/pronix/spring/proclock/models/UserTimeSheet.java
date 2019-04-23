package com.pronix.spring.proclock.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_timesheet")
public class UserTimeSheet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String startDate;
	
	@Column(nullable = false)
	private String endDate;
	
	@Column(nullable = false)
	private int monday;
	
	@Column(nullable = false)
	private int tuesday;
	
	@Column(nullable = false)
	private int wednesday;
	
	@Column(nullable = false)
	private int thursday;
	
	@Column(nullable = false)
	private int friday;
	
	@Column(nullable = true)
	private int saturday;
	
	@Column(nullable = true)
	private int sunday;
	
	@ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails userDetails;
	
	@ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private RefStatus refStatus;
	
	private String comments;
	
	@ManyToOne
    @JoinColumn(name = "approved_by_user_id", referencedColumnName = "manager_id")
    private Manager approvedUserDetails;
	
	@Column(nullable = false)
	private Date updatedDate;

	public UserTimeSheet() {
		super();
		this.updatedDate = new Date();
	}

	public UserTimeSheet(String startDate, String endDate, int monday,int tuesday, int wednesday, int thursday, int friday, int saturday,
			int sunday, Project project, UserDetails userDetails, RefStatus refStatus, String comments, Manager approvedUserDetails) {
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
		this.project = project;
		this.userDetails = userDetails;
		this.refStatus = refStatus;
		this.comments = comments;
		this.approvedUserDetails = approvedUserDetails;
		this.updatedDate = new Date();
	}

	public UserTimeSheet(long id, String startDate, String endDate, int monday,int tuesday, int wednesday, int thursday, int friday, int saturday,
			int sunday, Project project, UserDetails userDetails, RefStatus refStatus, String comments, Manager approvedUserDetails) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.project = project;
		this.userDetails = userDetails;
		this.refStatus = refStatus;
		this.comments = comments;
		this.approvedUserDetails = approvedUserDetails;
		this.updatedDate = new Date();
	}

	public UserTimeSheet(long id, RefStatus refStatus, String comments, Manager approvedUserDetails) {
		super();
		this.id = id;
		this.refStatus = refStatus;
		this.comments = comments;
		this.approvedUserDetails = approvedUserDetails;
	}

	public UserTimeSheet(String startDate, String endDate, int monday, int tuesday, int wednesday, int thursday, 
			int friday, int saturday, int sunday, Project project, RefStatus refStatus,UserDetails userDetails) {
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
		this.project = project;
		this.userDetails = userDetails;
		this.refStatus = refStatus;
		this.updatedDate = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public RefStatus getRefStatus() {
		return refStatus;
	}

	public void setRefStatus(RefStatus refStatus) {
		this.refStatus = refStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Manager getApprovedUserDetails() {
		return approvedUserDetails;
	}

	public void setApprovedUserDetails(Manager approvedUserDetails) {
		this.approvedUserDetails = approvedUserDetails;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate() {
		this.updatedDate = new Date();
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
