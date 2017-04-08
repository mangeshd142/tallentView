package com.tallentview.tallentview.user.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class EducationBean {
	private long edu_id;
	@NotEmpty
	private String institute_name;	
	@NotEmpty
	private String degree;	
	@NotEmpty
	private String field;
	@Pattern(regexp="^$|^[1-2][0-9]{3}$",message="Enter year")
	private String passout_year;
	
	@Pattern(regexp="^$|^[0-9]+|^[-+]?[0-9]*\\.[0-9]+$",message="Enter percentage in well format")
	private String percentage;
	private long user_id;
	
	public EducationBean() {
		// TODO Auto-generated constructor stub
	}

	public EducationBean(long edu_id, String institute_name, String degree, String field, String passout_year,
			String percentage, long user_id) {
		super();
		this.edu_id = edu_id;
		this.institute_name = institute_name;
		this.degree = degree;
		this.field = field;
		this.passout_year = passout_year;
		this.percentage = percentage;
		this.user_id = user_id;
	}

	public long getEdu_id() {
		return edu_id;
	}

	public void setEdu_id(long edu_id) {
		this.edu_id = edu_id;
	}

	public String getInstitute_name() {
		return institute_name;
	}

	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getPassout_year() {
		return passout_year;
	}

	public void setPassout_year(String passout_year) {
		this.passout_year = passout_year;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	

	
}
