package com.eDiary.entities.dto;

public class UserDto {
	private String user;
	private String token;

	public UserDto() {
		super();
	}

	public UserDto(String user, String token) {
		super();
		this.user = user;
		this.token = token;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
