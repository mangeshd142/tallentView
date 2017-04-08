package com.tallentview.tallentview.user.model;

public class UserContestResultBean {
	
	private String contest_name;
	private String contest_language;
	private long group_id;
	private long contest_id;
	private int result;
	private int rank;
	public UserContestResultBean() {
		// TODO Auto-generated constructor stub
	}
	public UserContestResultBean(String contest_name, String contest_language, long group_id, long contest_id,
			int result, int rank) {
		super();
		this.contest_name = contest_name;
		this.contest_language = contest_language;
		this.group_id = group_id;
		this.contest_id = contest_id;
		this.result = result;
		this.rank = rank;
	}
	public String getContest_name() {
		return contest_name;
	}
	public void setContest_name(String contest_name) {
		this.contest_name = contest_name;
	}
	public String getContest_language() {
		return contest_language;
	}
	public void setContest_language(String contest_language) {
		this.contest_language = contest_language;
	}
	public long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	

	
}
