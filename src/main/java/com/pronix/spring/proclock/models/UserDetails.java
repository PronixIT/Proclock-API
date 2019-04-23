package com.pronix.spring.proclock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	@NotNull
	@Column(nullable = false)
	private String firstName;
	
	@NotNull
	@Column(nullable = false)
	private String lastName;

	public UserDetails() {
		super();
	}

	public UserDetails(@NotNull String firstName, @NotNull String lastName) {
		super();
		/*this.userId = userId;*/
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getUserId() {
		return userId;
	}

	/*public void setUserId(long userId) {
		this.userId = userId;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
