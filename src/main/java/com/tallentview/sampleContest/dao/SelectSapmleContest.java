package com.tallentview.sampleContest.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.sampleContest.model.SapmleContestInfo;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;

public class SelectSapmleContest {
	
	public ModelAndView selectContest(String language, HttpServletRequest request){
		
		ModelAndView model = new ModelAndView("Subfiles/getsamplecontestdetail");
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		String hql="";
		
		if(language.equals("all"))
			hql = "from SapmleContestInfo";
		else
			hql = "from SapmleContestInfo where language='"+language+"'";
		Query query = ses.createQuery(hql);
		List<SapmleContestInfo> list = query.list();
		request.setAttribute("contestSize", list.size());
			
		ses.clear();
		ses.close();
		model.addObject("contestInfo",list);
	
	return model;
		
		
	}
	
public ModelAndView selectAllSampleContest(HttpServletRequest request){
		
		ModelAndView model = new ModelAndView("selectSampleContest");
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		String hql = "from SapmleContestInfo";
		Query query = ses.createQuery(hql);
		List<SapmleContestInfo> list = query.list();
		request.setAttribute("contestSize", list.size());
			
		model.addObject("contestInfo",list);
	
	return model;
		
		
	}

}
