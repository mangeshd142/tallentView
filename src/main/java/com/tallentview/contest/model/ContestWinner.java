package com.tallentview.contest.model;

public class ContestWinner {
	private long winnerId;
	private long goup_id;
	private long user_id;
	private long contest_id;
	private int result;
	private long complition_time;
	
	public ContestWinner() {
		// TODO Auto-generated constructor stub
	}

	public ContestWinner(long winnerId, long goup_id, long user_id, long contest_id, int result, long complition_time) {
		super();
		this.winnerId = winnerId;
		this.goup_id = goup_id;
		this.user_id = user_id;
		this.contest_id = contest_id;
		this.result = result;
		this.complition_time = complition_time;
	}

	public long getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(long winnerId) {
		this.winnerId = winnerId;
	}

	public long getGoup_id() {
		return goup_id;
	}

	public void setGoup_id(long goup_id) {
		this.goup_id = goup_id;
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
	
	
	 
}
