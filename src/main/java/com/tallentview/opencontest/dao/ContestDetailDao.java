package com.tallentview.opencontest.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.opencontest.model.ContestInfoBean;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;

public class ContestDetailDao {
	
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	Session ses;
	public List<ContestInfoBean> selectContest(String language, HttpServletRequest request){
		context.registerShutdownHook();
		System.out.println("call is here...dao");
		ses = hibdaoimpl.getSessionfactory().openSession();
		String hql;
		
		if(language.equals("all"))
			hql = "from ContestInfoBean";
		else
			hql = "from ContestInfoBean where language='"+language+"'";
		Query query = ses.createQuery(hql);
		List<ContestInfoBean> contestInfos = query.list();
		request.setAttribute("contestSize", contestInfos.size());
		ses.close();
	return contestInfos;
	}
	
	public ContestInfoBean getContestDetails(long contestId){
		context.registerShutdownHook();
		ses = hibdaoimpl.getSessionfactory().openSession();
		
		ContestInfoBean contestInfo = (ContestInfoBean)ses.get(ContestInfoBean.class, contestId);
		
		ses.close();
	return contestInfo;
	}

}
