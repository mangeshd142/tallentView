package com.tallentview.tallentview.dao;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.module.SupportBean;

public class SupportDao {
	
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");
	
	public ModelAndView saveSupport(SupportBean supportBean){
		context.registerShutdownHook();
		ModelAndView model = new ModelAndView("thankYou");
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		ses.saveOrUpdate(supportBean);

		ses.beginTransaction().commit();
		ses.evict(supportBean);
		ses.clear();
		ses.close();
	return model;	
	}

}
