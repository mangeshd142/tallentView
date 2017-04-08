package com.tallentview.contest.model;

public class ProgramLanguage {
	
	private int lang_id;
	private String lang_name;
	private String extension;
	private String Compile_cmd;
	private String run_cmd;
	
	public ProgramLanguage() {
		// TODO Auto-generated constructor stub
	}

	public ProgramLanguage(int lang_id, String lang_name, String extension, String compile_cmd, String run_cmd) {
		super();
		this.lang_id = lang_id;
		this.lang_name = lang_name;
		this.extension = extension;
		Compile_cmd = compile_cmd;
		this.run_cmd = run_cmd;
	}
	
	
	public int getLang_id() {
		return lang_id;
	}
	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}
	public String getLang_name() {
		return lang_name;
	}
	public void setLang_name(String lang_name) {
		this.lang_name = lang_name;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getCompile_cmd() {
		return Compile_cmd;
	}
	public void setCompile_cmd(String compile_cmd) {
		Compile_cmd = compile_cmd;
	}
	public String getRun_cmd() {
		return run_cmd;
	}
	public void setRun_cmd(String run_cmd) {
		this.run_cmd = run_cmd;
	}

}
