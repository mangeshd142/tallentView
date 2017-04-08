package com.tallentview.tallentview.user.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.EducationBean;
import com.tallentview.tallentview.user.model.ProfessionBean;
import com.tallentview.tallentview.user.model.Profile;
import com.tallentview.tallentview.user.model.User;
import com.tallentview.tallentview.user.model.UserSession;

public class DIsplayProfile {

	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	
	public ModelAndView displayProfile(User user,HttpServletRequest request){
		context.registerShutdownHook();
		ModelAndView model = new ModelAndView("profile");
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
		
		String hql = "from Profile where userid="+user.getUserid()+"";//Gets all details of all profile from user id
		Query query = ses.createQuery(hql);
		
		List<EducationBean> educationBeans = getEducationList(user.getUserid());
		List<ProfessionBean> professionBeans = getProfessionList(user.getUserid());
		
		
		Profile profile = (Profile) query.uniqueResult();
		request.setAttribute("eduSize", educationBeans.size());
		request.setAttribute("profSize", professionBeans.size());
		model.addObject("profession", professionBeans);
		model.addObject("education", educationBeans);
		try{
		model.addObject("dob", dateFormat.format(profile.getDob()));
		}catch(Exception e){e.printStackTrace();}
		model.addObject("phoneno", profile.getPhoneno());
		model.addObject("address", profile.getAddress());
		model.addObject("country", profile.getCountry());
		model.addObject("city", profile.getCity());
		model.addObject("state", profile.getState());
		model.addObject("pincode", profile.getPincode());
		model.addObject("skills", profile.getSkills());
		model.addObject("wallet", profile.getWallet());
		
		ses.clear();
		ses.close();
		return model;
	}
	
	public List<EducationBean> getEducationList(long user_id){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		String hql = "from EducationBean where user_id="+user_id+"";//Gets all details of all profile from user id
		Query query = ses.createQuery(hql);
		
		List<EducationBean> educationBeans =(List<EducationBean>) query.list();
		
		ses.clear();
		ses.close();
		return educationBeans;
		
	}
	
	public List<ProfessionBean> getProfessionList(long user_id){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		String hql = "from ProfessionBean where user_id="+user_id+"";//Gets all details of all profile from user id
		Query query = ses.createQuery(hql);
		
		List<ProfessionBean> professionBeans =(List<ProfessionBean>) query.list();
		
		ses.clear();
		ses.close();
		return professionBeans;
		
	}
	
	public Profile dispEditProfile(User user){
		context.registerShutdownHook();
		
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		String hql = "from Profile where userid="+user.getUserid()+""; //Gets all details of all profile from user id for edit profile
		Query query = ses.createQuery(hql);
		
		Profile profile = (Profile) query.uniqueResult();
		ses.clear();
		ses.close();
		return profile;
	}
	
 }
