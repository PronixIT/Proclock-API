package com.pronix.spring.proclock.pojos;

public class ResetPassword {
	
	private Long userId;
	private String oldPassword;
	private String newPassword;
	
	public ResetPassword() {
		super();
	}
	
	public ResetPassword(Long userId, String oldPassword, String newPassword) {
		super();
		this.userId = userId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	
	public ResetPassword(Long userId, String newPassword) {
		super();
		this.userId = userId;
		this.newPassword = newPassword;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
