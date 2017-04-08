package com.tallentview.tallentview.user.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ProfessionBean {
	private long prof_id;
	@NotEmpty
	private String companyName;
	@NotEmpty
	private String profile;
	@NotEmpty
	private String currently_working;
	@NotEmpty
	private String experience;
	private String description;
	private long user_id;
	
	public ProfessionBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ProfessionBean(long prof_id, String companyName, String profile, String currently_working, String experience,
			String description, long user_id) {
		super();
		this.prof_id = prof_id;
		this.companyName = companyName;
		this.profile = profile;
		this.currently_working = currently_working;
		this.experience = experience;
		this.description = description;
		this.user_id = user_id;
	}



	public long getProf_id() {
		return prof_id;
	}

	public void setProf_id(long prof_id) {
		this.prof_id = prof_id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getCurrently_working() {
		return currently_working;
	}

	public void setCurrently_working(String currently_working) {
		this.currently_working = currently_working;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	
	

}
