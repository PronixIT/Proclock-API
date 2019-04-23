package com.pronix.spring.proclock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_contacts")
public class UserContacts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String emailId;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String phoneNo;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails userDetails;

	public UserContacts() {
		super();
	}

	public UserContacts(@NotNull String emailId, @NotNull String phoneNo, UserDetails userDetails) {
		super();
		/*this.id = id;*/
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.userDetails = userDetails;
	}

	public long getId() {
		return id;
	}

	/*public void setId(long id) {
		this.id = id;
	}*/

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

}
