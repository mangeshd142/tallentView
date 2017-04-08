package com.tallentview.tallentview.user.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.User;

public class ResetPasswordDao {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	public ModelAndView resetPassword(String email,String password){
		ModelAndView model = new ModelAndView("redirect:login");
		context.registerShutdownHook();
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		User user=new User();
		try{
		String hql = "from User where email='"+email+"'"; //Gets Results from given email Id.
		Query query = ses.createQuery(hql);
		user = (User) query.uniqueResult();
		user.setPassword(password);
		System.out.println("usinfo::::: "+user.getUserid());
		
		ses.update(user);
		ses.beginTransaction().commit();
		ses.evict(user);
		ses.clear();
		ses.close();
		}
		catch(NullPointerException e){
			
		}
		return model;
	}

}
