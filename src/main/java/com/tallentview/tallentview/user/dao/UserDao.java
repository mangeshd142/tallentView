package com.tallentview.tallentview.user.dao;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.User;

public class UserDao {
	
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	//context.registerShutdownHook();
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	
	public User getUserInfo(long userId){
		context.registerShutdownHook();
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		User user = (User)ses.get(User.class, userId);
		ses.close();
	return user;
	}
	

}
