package com.pronix.spring.proclock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ref_status")
public class RefStatus {

	@Id
	@Column(name = "status_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long statusId;
	
	@NotNull
	@Column(nullable = false)
	private String value;
	
	@NotNull
	@Column(nullable = false)
	private String description;

	public RefStatus() {
		super();
	}

	public RefStatus(long statusId, @NotNull String value, @NotNull String description) {
		super();
		this.statusId = statusId;
		this.value = value;
		this.description = description;
	}
	
	public RefStatus(String value, String description) {
		super();
		this.value = value;
		this.description = description;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

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
