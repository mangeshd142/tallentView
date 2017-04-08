package com.tallentview.tallentview.user.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	private long userid;
	
	@NotEmpty(message = "email-id may not be empty")
	@Email(message = "Enter well womated email")
	private String email;
	
	@Size(min=6,message="Passwor must be grether than 7 charectors")
	private String password;
	@NotEmpty(message = "First Name may not be empty")
	private String fname;
	
	@NotEmpty(message = "Last Name may not be empty")
	private String lname;
	
	@NotEmpty(message = "select gender")
	private String gender;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	

}
