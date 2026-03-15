package com.joy.cosaspendientes.dto.request;

public class LoginRequest {
	private Long userId;

	private String password;

	public LoginRequest() {}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

