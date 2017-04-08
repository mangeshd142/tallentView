package com.tallentview.tallentview.user.model;

public class UserSession {
	private long userid;
	private String email;
	private String fname;
	private String lname;
	private String gender;
	private long profile_id;
	
	public UserSession() {
		// TODO Auto-generated constructor stub
	}

	public UserSession(long userid, String email, String fname, String lname, String gender, long profile_id) {
		super();
		this.userid = userid;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.profile_id = profile_id;
	}

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

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}
	
	
}
