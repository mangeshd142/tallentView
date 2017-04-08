package com.tallentview.tallentview.module;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SupportBean {
	private long support_id;
	
	@NotEmpty(message = "Enter name")
	private String name;
	
	@NotEmpty(message = "email-id may not be empty")
	@Email(message = "Please enter a valid email")
	private String email;
	@NotEmpty(message = "Enter subject")
	private String subject;
	@NotEmpty(message = "Enter message")
	private String message;

	public SupportBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SupportBean(long support_id, String name, String email, String subject, String message) {
		super();
		this.support_id = support_id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}


	public long getSupport_id() {
		return support_id;
	}

	public void setSupport_id(long support_id) {
		this.support_id = support_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
