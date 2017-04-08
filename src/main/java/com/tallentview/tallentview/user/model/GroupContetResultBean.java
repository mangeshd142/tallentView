package com.tallentview.tallentview.user.model;

public class GroupContetResultBean {
	
	private String user_name;
	private int result;
	private long complition_time;
	private String required_time;
	
	public GroupContetResultBean() {
		// TODO Auto-generated constructor stub
	}

	

	public GroupContetResultBean(String user_name, int result, long complition_time, String required_time) {
		super();
		this.user_name = user_name;
		this.result = result;
		this.complition_time = complition_time;
		this.required_time = required_time;
	}



	public String getRequired_time() {
		return required_time;
	}



	public void setRequired_time(String required_time) {
		this.required_time = required_time;
	}



	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public long getComplition_time() {
		return complition_time;
	}

	public void setComplition_time(long complition_time) {
		this.complition_time = complition_time;
	}
	
	

}
