package com.tallentview.tallentview.user.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.Profile;
import com.tallentview.tallentview.user.model.User;

public class WalletUpdate {
	
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	
	public void upadteWallet(long user_id,double amount){
		
		context.registerShutdownHook();
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		Profile profile = new Profile();
		try{
			String hql = "from Profile where userid="+user_id; //Gets Results from given email Id.
			Query query = ses.createQuery(hql);
			profile = (Profile) query.uniqueResult();
			profile.setWallet(amount);
			System.out.println("phno:::: "+profile.getPhoneno()+" prise ::::"+amount);
			ses.update(profile);
			ses.beginTransaction().commit();
			ses.evict(profile);
			ses.clear();
			ses.close();
		}catch(Exception e){
			
		}
		
	}
	
	public double getWalletAmount(long user_id){
		
		context.registerShutdownHook();
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		Profile profile = new Profile();
		try{
			String hql = "from Profile where userid="+user_id; //Gets Results from given email Id.
			Query query = ses.createQuery(hql);
			profile = (Profile) query.uniqueResult();
			
			ses.clear();
			ses.close();
		}catch(Exception e){
			
		}
		
		
		return profile.getWallet();
	}

}
