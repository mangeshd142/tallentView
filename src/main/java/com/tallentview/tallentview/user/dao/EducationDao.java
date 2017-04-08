package com.tallentview.tallentview.user.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.EducationBean;
import com.tallentview.tallentview.user.model.User;

public class EducationDao {

	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");

	public ModelAndView saveEducation(EducationBean educationBean, HttpSession session) {
		context.registerShutdownHook();
		ModelAndView model;

		try {
			User user = (User) session.getAttribute("userSession");

			if (user == null) {
				model = new ModelAndView("redirect:login");
			} else {
				model = new ModelAndView("redirect:profile");
				educationBean.setUser_id(user.getUserid());

				context.registerShutdownHook();

				Session ses = hibdaoimpl.getSessionfactory().openSession();

				ses.saveOrUpdate(educationBean);

				ses.beginTransaction().commit();
				ses.evict(educationBean);
				ses.clear();
				ses.close();
			}
		} catch (Exception e) {
			model = new ModelAndView("redirect:login");
		}

		return model;
	}
	
	
	public ModelAndView getEducation(long edu_id, HttpSession session,ModelMap map) {
		context.registerShutdownHook();
		ModelAndView model;
		
		try {
			User user = (User) session.getAttribute("userSession");

			if (user == null) {
				model = new ModelAndView("redirect:login");
			} else {
				
				EducationBean educationBean = new EducationBean();

				Session ses = hibdaoimpl.getSessionfactory().openSession();
				
				educationBean = (EducationBean) ses.get(EducationBean.class, edu_id);
					
				ses.beginTransaction().commit();
				
				if(educationBean.getUser_id()==user.getUserid()){
					model = new ModelAndView("editEducation");
					map.put("addEducation", educationBean);
				}else{
					model = new ModelAndView("redirect:profile");
				}
					
				ses.clear();
				ses.close();
			}
		} catch (Exception e) {
			model = new ModelAndView("redirect:login");
		}
		return model;
	}
	

}
