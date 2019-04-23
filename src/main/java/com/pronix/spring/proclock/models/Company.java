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
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "company_id")
	private long companyId;
	
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private String companyAddress;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails userDetails;

	public Company() {
		super();
	}

	public Company(long companyId, String companyName, String companyAddress, UserDetails userDetails) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.userDetails = userDetails;
	}

	public Company(String companyName, String companyAddress, UserDetails userDetails) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.userDetails = userDetails;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
}
