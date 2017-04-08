package com.tallentview.contest.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.contest.model.UserContestResult;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.User;

public class ContestReseletDao {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	// context.registerShutdownHook();
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");
	Session ses = hibdaoimpl.getSessionfactory().openSession();

	public List<UserContestResult> getUserResult(long user_id) {

		//Session ses = hibdaoimpl.getSessionfactory().openSession();

		String hql = "from UserContestResult where user_id=" + user_id;
		Query query = ses.createQuery(hql);
		List<UserContestResult> contres = (List<UserContestResult>) query.list();
		//ses.close();
		
	return contres;
	}
	
	public List<UserContestResult> getContestResult(long grpid,long contestid){
		System.out.println("group id:::: "+grpid+" ContestId:::: "+contestid);
		
		//Session ses = hibdaoimpl.getSessionfactory().openSession();
		
			String hql = "from UserContestResult where group_id="+grpid+" and contest_id="+contestid+" order by result DESC, required_time ASC, complition_time ASC";
			Query query = ses.createQuery(hql); 
			List<UserContestResult> contres =(List<UserContestResult>) query.list();
			//ses.close();
		return contres;
	}
	
	public User getUserDetail(long userid){
		
		
		
		User user = (User)ses.get(User.class, userid);
			 // ses.close();
		return user;
	}
	

}
