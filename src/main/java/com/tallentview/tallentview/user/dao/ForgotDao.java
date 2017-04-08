package com.tallentview.tallentview.user.dao;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.tallentview.email.ForgotEmail;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.Forgot;
import com.tallentview.tallentview.user.model.User;

public class ForgotDao {
	
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");
	String emailget = null;
	long user_id;
	public String setForgot(String email){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		User user=new User();
		try{
		String hql = "from User where email='"+email+"'"; //Gets Results from given email Id.
		Query query = ses.createQuery(hql);
		user = (User) query.uniqueResult();
		
		emailget = user.getEmail();
		ses.evict(user);
		}
		catch(NullPointerException e){
			
		}
		if(email.equals(emailget) ){//If password and email Match It retuns to profile
			RandomString randomString = new RandomString();
			Forgot forgot = new Forgot();
			
			String hql = "from Forgot where forgot_email='"+email+"'"; //Gets Results from given email Id.
			Query query = ses.createQuery(hql);
			forgot = (Forgot) query.uniqueResult();
			try{
			if(forgot.equals(null)){
				forgot = new Forgot();
			}
			}catch(NullPointerException exception){
				forgot = new Forgot();
			}
			
			forgot.setForgot_email(email);
			String tempPwd = randomString.nextSessionId();
			forgot.setTemp_password(tempPwd);
			Session ses2 = hibdaoimpl.getSessionfactory().openSession();

			ses2.saveOrUpdate(forgot);

			ses2.beginTransaction().commit();
			ses2.evict(forgot);
			ForgotEmail forgotEmail = new ForgotEmail();
			try {
				forgotEmail.sendForgotEmail(email,tempPwd);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ses.clear();
			ses.close();
			ses2.clear();
			ses2.close();
			return " <span style=\"color: green;\"> Forgot Email sent Sucessifully</span>";
		}
		else{
			ses.clear();
			ses.close();
			//else returns error on login page
			return "<span style=\"color: red;\">Please Enter registered email id</span>";
		}
		
	}
	
}
