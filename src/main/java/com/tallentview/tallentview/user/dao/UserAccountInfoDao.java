package com.tallentview.tallentview.user.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.AccountDetails;
import com.tallentview.tallentview.user.model.Profile;

public class UserAccountInfoDao {
	
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	
	public ModelAndView saveAccountInfo(AccountDetails accountDetails,long user_id){
		context.registerShutdownHook();
		ModelAndView model = new ModelAndView("saveAccountInfo");
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		Profile profile = new Profile();
		String hql = "from Profile where userid="+user_id; //Gets Results from given email Id.
		Query query = ses.createQuery(hql);
		profile = (Profile) query.uniqueResult();
		
		accountDetails.setStatus("unpaid");
		accountDetails.setUser_id(user_id);
		accountDetails.setAmount(profile.getWallet());
		
		ses.save(accountDetails);
		profile.setWallet(0);
		ses.update(profile);
		
		ses.beginTransaction().commit();
		ses.evict(accountDetails);
		ses.clear();
		ses.close();
		
		model.addObject("claimDetails", accountDetails);
	return model;
	}

}
