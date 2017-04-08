package com.tallentview.tallentview.user.model;



import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class Login {
	
	@NotEmpty(message = "email-id may not be empty")
	@Email(message = "Enter valid email id")
	private String email;
	
	@Size(min=6,message="Password must be greater than 6 characters")
	private String password;
	
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

}
