package com.tallentview.tallentview.user.model;

public class Forgot {
	
	private long forgot_id;
	private String forgot_email;
	private String temp_password;

	
	
	public long getForgot_id() {
		return forgot_id;
	}

	public void setForgot_id(long forgot_id) {
		this.forgot_id = forgot_id;
	}

	public String getForgot_email() {
		return forgot_email;
	}

	public void setForgot_email(String forgot_email) {
		this.forgot_email = forgot_email;
	}

	public String getTemp_password() {
		return temp_password;
	}

	public void setTemp_password(String temp_password) {
		this.temp_password = temp_password;
	}
	
	
}
