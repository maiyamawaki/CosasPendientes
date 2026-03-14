package com.joy.cosaspendientes.dto.request;

public class UserUpdateRequest {
	private String userName;

	private String password;

	private String userImg;

	public UserUpdateRequest() {}
 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
}
