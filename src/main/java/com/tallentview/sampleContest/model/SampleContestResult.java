package com.tallentview.sampleContest.model;

import java.util.Date;

public class SampleContestResult {
	
	private long res_id;
	private long user_id;
	private long contest_id;
	private int result;
	private long complition_time;
	private Date sub_date;
	
	public SampleContestResult() {
		// TODO Auto-generated constructor stub
	}

	public SampleContestResult(long res_id, long user_id, long contest_id, int result, long complition_time, Date sub_date) {
		super();
		this.res_id = res_id;
		this.user_id = user_id;
		this.contest_id = contest_id;
		this.result = result;
		this.complition_time = complition_time;
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

	public Date getSub_date() {
		return sub_date;
	}

	public void setSub_date(Date sub_date) {
		this.sub_date = sub_date;
	}



}
