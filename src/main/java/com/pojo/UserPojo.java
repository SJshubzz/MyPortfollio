package com.pojo;



public class UserPojo {

	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserPojo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	private String password;
}
