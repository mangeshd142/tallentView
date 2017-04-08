package com.tallentview.contest.model;

public class ProgramBean {
	private long prog_id;
	private String prog_language;
	private String prog_name;
	private String prog_disc;
	private long timelimit;
	private String path;
	private int testcases;
	
	
	public long getProg_id() {
		return prog_id;
	}
	public void setProg_id(long prog_id) {
		this.prog_id = prog_id;
	}
	public String getProg_language() {
		return prog_language;
	}
	public void setProg_language(String prog_language) {
		this.prog_language = prog_language;
	}
	public String getProg_name() {
		return prog_name;
	}
	public void setProg_name(String prog_name) {
		this.prog_name = prog_name;
	}
	public String getProg_disc() {
		return prog_disc;
	}
	public void setProg_disc(String prog_disc) {
		this.prog_disc = prog_disc;
	}
	public long getTimelimit() {
		return timelimit;
	}
	public void setTimelimit(long timelimit) {
		this.timelimit = timelimit;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getTestcases() {
		return testcases;
	}
	public void setTestcases(int testcases) {
		this.testcases = testcases;
	}
}
