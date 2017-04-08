package com.tallentview.tallentview.user.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.Profile;
import com.tallentview.tallentview.user.model.User;

public class SaveProfile {
	
	
	public ModelAndView saveProfile(Profile profile,HttpSession session)// Gets profile and session
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		User user = (User) session.getAttribute("userSession");
		
		long userid=user.getUserid();
		String hql = "UPDATE Profile set dob=:dob,phoneno=:phoneno,address=:address,"
				+ "country=:country,state=:state,city=:city,pincode=:pincode,skills=:skills WHERE userid =:userid" ;//Update all profile Parameters
		
		
		Query query = ses.createQuery(hql);
		//parameters for update results
		query.setParameter("dob", profile.getDob());
		query.setParameter("phoneno", profile.getPhoneno());
		query.setParameter("address", profile.getAddress());
		query.setParameter("country", profile.getCountry());
		query.setParameter("state", profile.getState());
		query.setParameter("city", profile.getCity());
		query.setParameter("pincode", profile.getPincode());
		query.setParameter("skills", profile.getSkills());
		query.setParameter("userid", userid);
		
		int result = query.executeUpdate();
		
		ses.clear();
		ses.close();
		return new ModelAndView("redirect:profile");// returns to profile page
	}

}
