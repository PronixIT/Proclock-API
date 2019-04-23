package com.pronix.spring.proclock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ref_roles")
public class RefRoles {
	
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long roleId;
	
	@NotNull
	@Column(nullable = false)
	private String value;
	
	@NotNull
	@Column(nullable = false)
	private String description;

	public RefRoles() {
		super();
	}

	public RefRoles(@NotNull String value, @NotNull String description) {
		super();
		/*this.roleId = roleId;*/
		this.value = value;
		this.description = description;
	}

	public long getRoleId() {
		return roleId;
	}

	/*public void setRoleId(long roleId) {
		this.roleId = roleId;
	}*/

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
