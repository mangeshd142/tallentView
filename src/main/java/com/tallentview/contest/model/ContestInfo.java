package com.tallentview.contest.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContestInfo {
	
	private long contest_id;
	private String language;
	private String name;
	private String contest_info;
	private int participant;
	private Date start_date;
	private Date end_date;
	private long prog_id;
	private double entry_fee;
	private double prise;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
	public ContestInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public ContestInfo(long contest_id, String language, String name, String contest_info, int participant,
			Date start_date, Date end_date, long prog_id, double entry_fee, double prise) {
		super();
		this.contest_id = contest_id;
		this.language = language;
		this.name = name;
		this.contest_info = contest_info;
		this.participant = participant;
		this.start_date = start_date;
		this.end_date = end_date;
		this.prog_id = prog_id;
		this.entry_fee = entry_fee;
		this.prise = prise;
	}

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

	

	public Date getStart_date() {
		return start_date;
	}



	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}



	public Date getEnd_date() {
		return end_date;
	}



	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}



	public long getProg_id() {
		return prog_id;
	}

	public void setProg_id(long prog_id) {
		this.prog_id = prog_id;
	}

	public double getEntry_fee() {
		return entry_fee;
	}

	public void setEntry_fee(double entry_fee) {
		this.entry_fee = entry_fee;
	}

	public double getPrise() {
		return prise;
	}

	public void setPrise(double prise) {
		this.prise = prise;
	}
	

}
