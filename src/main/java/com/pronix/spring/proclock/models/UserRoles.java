package com.pronix.spring.proclock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private RefRoles refRoles;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails userDetails;

	public UserRoles() {
		super();
	}

	public UserRoles(RefRoles refRoles, UserDetails userDetails) {
		super();
		/*this.id = id;*/
		this.refRoles = refRoles;
		this.userDetails = userDetails;
	}

	public long getId() {
		return id;
	}

	/*public void setId(long id) {
		this.id = id;
	}*/

	public RefRoles getRefRoles() {
		return refRoles;
	}

	public void setRefRoles(RefRoles refRoles) {
		this.refRoles = refRoles;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
}
