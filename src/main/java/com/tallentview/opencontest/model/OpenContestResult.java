package com.tallentview.opencontest.model;

import java.util.Date;

public class OpenContestResult {
	private long res_id; 
	private long user_id;
	private long contest_id;
	private int result;
	private long complition_time;
	private long required_time;
	private Date sub_date;

	public OpenContestResult() {
		// TODO Auto-generated constructor stub
	}

	public OpenContestResult(long res_id, long user_id, long contest_id, int result, long complition_time,
			long required_time, Date sub_date) {
		super();
		this.res_id = res_id;
		this.user_id = user_id;
		this.contest_id = contest_id;
		this.result = result;
		this.complition_time = complition_time;
		this.required_time = required_time;
		this.sub_date = sub_date;
	}

	public long getRes_id() {
		return res_id;
	}

	public void setRes_id(long res_id) {
		this.res_id = res_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getContest_id() {
		return contest_id;
	}

	public void setContest_id(long contest_id) {
		this.contest_id = contest_id;
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

	public long getRequired_time() {
		return required_time;
	}

	public void setRequired_time(long required_time) {
		this.required_time = required_time;
	}

	public Date getSub_date() {
		return sub_date;
	}

	public void setSub_date(Date sub_date) {
		this.sub_date = sub_date;
	}
	
}
