package com.tallentview.tallentview.user.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Profile {
	private long pro_id;
	
	@DateTimeFormat(pattern="MMM-dd-yyyy")
	private Date dob;
	
	@Pattern(regexp="^$|^[7-9][0-9]{9}$",message="Phone no must be 10 cheractor and Start with 7 to 9")//[0-9]+
	private String phoneno;
	private String address;
	private String country;
	private String state;
	private String city;
	@Pattern(regexp="^$|^[0-9]{6}$",message="Pin code must be 6 digit")
	private String pincode;
	private String skills;
	private double wallet;
	private long userid;
	
	
	
	public Profile() {
		// TODO Auto-generated method stub

	}


	public Profile(long pro_id, Date dob, String phoneno, String address, String country, String state, String city,
			String pincode, String skills,double wallet, long userid) {
		super();
		this.pro_id = pro_id;
		this.dob = dob;
		this.phoneno = phoneno;
		this.address = address;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.skills = skills;
		this.userid = userid;
		this.wallet = wallet;
	}


	public long getPro_id() {
		return pro_id;
	}


	public void setPro_id(long pro_id) {
		this.pro_id = pro_id;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}


	public double getWallet() {
		return wallet;
	}


	public void setWallet(double wallet) {
		this.wallet = wallet;
	}



	
	

}
