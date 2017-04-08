package com.tallentview.sampleContest.model;


public class SapmleContestInfo {
	
	private long contest_id;
	private String language;
	private String name;
	private String contest_info;
	private int participant;
	private String start_date;
	private String end_date;
	private long prog_id;
	public long getContest_id() {
		return contest_id;
	}
	public void setContest_id(long contest_id) {
		this.contest_id = contest_id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContest_info() {
		return contest_info;
	}
	public void setContest_info(String contest_info) {
		this.contest_info = contest_info;
	}
	public int getParticipant() {
		return participant;
	}
	public void setParticipant(int participant) {
		this.participant = participant;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public long getProg_id() {
		return prog_id;
	}
	public void setProg_id(long prog_id) {
		this.prog_id = prog_id;
	}

}
