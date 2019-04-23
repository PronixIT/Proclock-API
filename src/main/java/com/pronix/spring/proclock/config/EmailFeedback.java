package com.pronix.spring.proclock.config;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class EmailFeedback {
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String feedback;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
