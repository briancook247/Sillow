package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Class to model login data
public class LoginModel {
	
	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="User name must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	public LoginModel(String password, String username)
	{
		this.password = password;
		this.username = username;
	}

	public LoginModel()
	{
		
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginModel [ username= " + username + ", password = " + password + " ]";
	}
	
}