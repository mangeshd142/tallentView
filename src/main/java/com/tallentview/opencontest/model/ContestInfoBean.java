package com.tallentview.opencontest.model;

import java.util.Date;

public class ContestInfoBean {

	private long contest_id;
	private String language;
	private String name;
	private String contest_info;
	private Date start_date;
	private Date end_date;
	private String prise1;
	private String prise2;
	private String prise3;
	private long prog_id;
	
	
	public ContestInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public ContestInfoBean(long contest_id, String language, String name, String contest_info, Date start_date,
			Date end_date, long prog_id, String prise1, String prise2, String prise3) {
		super();
		this.contest_id = contest_id;
		this.language = language;
		this.name = name;
		this.contest_info = contest_info;
		this.start_date = start_date;
		this.end_date = end_date;
		this.prog_id = prog_id;
		this.prise1 = prise1;
		this.prise2 = prise2;
		this.prise3 = prise3;
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

	public String getPrise1() {
		return prise1;
	}

	public void setPrise1(String prise1) {
		this.prise1 = prise1;
	}

	public String getPrise2() {
		return prise2;
	}

	public void setPrise2(String prise2) {
		this.prise2 = prise2;
	}

	public String getPrise3() {
		return prise3;
	}

	public void setPrise3(String prise3) {
		this.prise3 = prise3;
	}
	
	
}
