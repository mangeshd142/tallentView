package com.tallentview.tallentview.hibernateconf;

import org.hibernate.SessionFactory;

public class HibernateDaoImpl {// Hibernate Configurations
	
	
	private SessionFactory sessionfactory;

	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

}
