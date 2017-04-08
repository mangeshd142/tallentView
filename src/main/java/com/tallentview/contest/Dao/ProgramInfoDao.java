package com.tallentview.contest.Dao;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.contest.model.ProgramBean;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;

public class ProgramInfoDao {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");
	
	public ProgramBean getProgramInfo(long prog_id){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		ProgramBean programBean = (ProgramBean) ses.get(ProgramBean.class, prog_id);
		ses.beginTransaction().commit();
		
		ses.clear();
		ses.close();
		
	return programBean;
	}

}
