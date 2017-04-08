package com.tallentview.tallentview.user.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountDetails {
	
	private long ac_id;
	@NotEmpty(message="Enter Account Hloder Name")
	private String ac_name;
	@NotEmpty(message="Enter Bank Name")
	private String bank_nm;
	@Pattern(regexp="^[0-9]{9,18}$",message="Accoun number greter than 9 letter and numerical")//[0-9]+
	private String account_no;
	@Pattern(regexp="^[A-Za-z]{4}[0]{1}[0-9]{6}$",message="Invalid IFSC Code")
	private String ifcs_code;
	private double amount;
	private String status;
	private long user_id;
	
	public AccountDetails() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AccountDetails(long ac_id, String ac_name, String bank_nm, String account_no, String ifcs_code,
			double amount, String status, long user_id) {
		super();
		this.ac_id = ac_id;
		this.ac_name = ac_name;
		this.bank_nm = bank_nm;
		this.account_no = account_no;
		this.ifcs_code = ifcs_code;
		this.amount = amount;
		this.user_id = user_id;
		this.status = status;
	}

	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getAc_id() {
		return ac_id;
	}

	public void setAc_id(long ac_id) {
		this.ac_id = ac_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getAc_name() {
		return ac_name;
	}
	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}
	public String getBank_nm() {
		return bank_nm;
	}
	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getIfcs_code() {
		return ifcs_code;
	}
	public void setIfcs_code(String ifcs_code) {
		this.ifcs_code = ifcs_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
