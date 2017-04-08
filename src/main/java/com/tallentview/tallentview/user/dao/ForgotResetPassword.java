package com.tallentview.tallentview.user.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.Forgot;
import com.tallentview.tallentview.user.model.ForgotLogin;
import com.tallentview.tallentview.user.model.Login;
import com.tallentview.tallentview.user.model.User;

public class ForgotResetPassword {
	String emailget = null;
	String pwdget=null;
	long user_id;
	public ModelAndView resetForgotAuthentication(ForgotLogin forgot){
		
			String url;
			ModelAndView model;
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			context.registerShutdownHook();
			HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
			
			Session ses = hibdaoimpl.getSessionfactory().openSession();
			Forgot forgot2 = new Forgot();
			try{
			String hql = "from Forgot where forgot_email='"+forgot.getEmail()+"'"; //Gets Results from given email Id.
			Query query = ses.createQuery(hql);
			forgot2 = (Forgot) query.uniqueResult();
			
			emailget = forgot2.getForgot_email();
	    	pwdget = forgot2.getTemp_password();
	    	
	    	
			
			}
			catch(NullPointerException e){
				
			}
			if(forgot.getEmail().equals(emailget) && forgot.getPassword().equals(pwdget)){//If password and email Match It retuns to profile
				System.out.println("log sus.....::::....");
				//ses.delete(forgot2);
		    	//ses.beginTransaction().commit();
				model = new ModelAndView("resetPassword");
			}
			else{
				url="login";//else returns error on login page
				model = new ModelAndView("index");
			}	
			ses.evict(forgot2);
			
			ses.clear();
			ses.close();
		return model;
	}

}
