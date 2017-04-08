package com.tallentview.tallentview.user.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.*;

public class LoginAuthenticate {
	
	String emailget = null;
	String pwdget=null;
	long user_id;
	
	public String authenticate(Login login,HttpSession session,BindingResult result ){
		String url;
		ModelAndView model;
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		User user=new User();
		try{
		String hql = "from User where email='"+login.getEmail()+"'"; //Gets Results from given email Id.
		Query query = ses.createQuery(hql);
		user = (User) query.uniqueResult();
		user_id = user.getUserid();
		emailget = user.getEmail();
    	pwdget = user.getPassword();
		ses.evict(user);
		ses.clear();
		ses.close();
		}
		catch(NullPointerException e){
			
		}
		if(login.getEmail().equals(emailget) && login.getPassword().equals(pwdget)){//If password and email Match It retuns to profile
			session.setAttribute("userSession", user);//Sets user session for all session management
			session.setMaxInactiveInterval(7*60*60);
			url="redirect:profile";
		}
		else{
			if(!login.getEmail().equals(emailget))
				result.rejectValue("email", "error.user", "Enter registered email id");
			else
				result.rejectValue("password", "error.user", "Wrong Password.");
			
			url="login";//else returns error on login page
		}	
		return url;
	}

}
