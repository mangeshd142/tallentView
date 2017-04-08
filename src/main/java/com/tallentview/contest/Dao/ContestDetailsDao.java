package com.tallentview.contest.Dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.contest.model.ContestInfo;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;

public class ContestDetailsDao {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	//context.registerShutdownHook();
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	
	
	public List<ContestInfo> selectContest(String language, HttpServletRequest request){
		context.registerShutdownHook();
		System.out.println("call is here...dao");
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		String hql;
		
		if(language.equals("all"))
			hql = "from ContestInfo";
		else
			hql = "from ContestInfo where language='"+language+"'";
		Query query = ses.createQuery(hql);
		List<ContestInfo> contestInfos = query.list();
		request.setAttribute("contestSize", contestInfos.size());
		ses.close();
	return contestInfos;
	}

	public ContestInfo getContestDetails(long contestId){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		ContestInfo contestInfo = (ContestInfo)ses.get(ContestInfo.class, contestId);
		
		ses.close();
	return contestInfo;
	}

}
