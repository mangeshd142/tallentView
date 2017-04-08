package com.tallentview.contest.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.contest.model.ContestWinner;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.User;

public class WinnerDao {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	// context.registerShutdownHook();
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");
	
	
	public void winnerDetailsSaave(ContestWinner contestWinner){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		ses.save(contestWinner);
		
		ses.beginTransaction().commit();
		ses.evict(contestWinner);
		ses.close();
	}
	
public ContestWinner getWinnerDetail(long group_Id, long contest_id){
	context.registerShutdownHook();
	
		Session ses = hibdaoimpl.getSessionfactory().openSession();
			
		String hql="from ContestWinner where goup_id="+group_Id+" and contest_id="+contest_id;
		Query query = ses.createQuery(hql);
		
		
		ContestWinner contestWinner = (ContestWinner)query.uniqueResult();
		ses.beginTransaction().commit();		  
		ses.close();

	return contestWinner;
	}

}
