package com.tallentview.sampleContest.dao;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.sampleContest.model.SapmleContestInfo;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;

public class ContestDetailsDao {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	
	public SapmleContestInfo getContestDetails(long contestId){
		context.registerShutdownHook();
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		SapmleContestInfo contestInfo = (SapmleContestInfo)ses.get(SapmleContestInfo.class, contestId);
		
		ses.close();
		return contestInfo;
		
	}
	
}
