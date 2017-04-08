package com.tallentview.tallentview.user.dao;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.Profile;
import com.tallentview.tallentview.user.model.User;

public class Signup {
	ModelAndView model = new ModelAndView("redirect:profile"); 
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	Session ses;
	public ModelAndView signup(User user, HttpSession session) throws MySQLIntegrityConstraintViolationException {
		
		context.registerShutdownHook();
		HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
		ses = hibdaoimpl.getSessionfactory().openSession();
		ses.save(user);//saves user...for new signup
		
		Session ses2 = hibdaoimpl.getSessionfactory().openSession();
		
		Profile profile = new Profile(0,null,"","","","","","","",0,user.getUserid());//also create new profile for this user.
		ses2.save(profile);
		ses.clear();
		ses.close();
		ses2.clear();
		ses2.close();
		session.setAttribute("userSession", user);//sets session of this user.
		session.setMaxInactiveInterval(7*60*60);
		return model;
	} 

}
