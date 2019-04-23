package com.pronix.spring.proclock.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_password")
public class UserPassword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String userName;
	
	@NotNull
	@Column(nullable = false)
	private String userPassword;

	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails userDetails;
	
	@ManyToOne
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "user_id")
    private UserDetails createdByUserDetails;
	
	private Date createdDate;

	public UserPassword() {
		super();
	}

	public UserPassword(long id, @NotNull String userName, @NotNull String userPassword, UserDetails userDetails,
			UserDetails createdByUserDetails,Date createdDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userDetails = userDetails;
		this.createdByUserDetails = createdByUserDetails;
		this.createdDate = createdDate;
	}

	public UserPassword(@NotNull String userName, @NotNull String userPassword, UserDetails userDetails, UserDetails createdByUserDetails) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userDetails = userDetails;
		this.createdByUserDetails = createdByUserDetails;
		this.createdDate = new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetails getCreatedByUserDetails() {
		return createdByUserDetails;
	}

	public void setCreatedByUserDetails(UserDetails createdByUserDetails) {
		this.createdByUserDetails = createdByUserDetails;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate() {
		this.createdDate = new Date();
	}
	
	
}
