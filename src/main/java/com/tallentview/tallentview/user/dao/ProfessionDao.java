package com.tallentview.tallentview.user.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.model.EducationBean;
import com.tallentview.tallentview.user.model.ProfessionBean;
import com.tallentview.tallentview.user.model.User;

public class ProfessionDao {

	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");

	public ModelAndView saveProfession(ProfessionBean professionBean, HttpSession session) {
		context.registerShutdownHook();
		ModelAndView model;

		try {
			User user = (User) session.getAttribute("userSession");

			if (user == null) {
				model = new ModelAndView("redirect:login");
			} else {
				model = new ModelAndView("redirect:profile");
				professionBean.setUser_id(user.getUserid());

				context.registerShutdownHook();

				Session ses = hibdaoimpl.getSessionfactory().openSession();

				ses.saveOrUpdate(professionBean);

				ses.beginTransaction().commit();
				ses.evict(professionBean);
				ses.clear();
				ses.close();
			}
		} catch (Exception e) {
			model = new ModelAndView("redirect:login");
		}

		return model;
	}
	
	
	public ModelAndView getProfesson(long prof_id, HttpSession session,ModelMap map) {
		context.registerShutdownHook();
		ModelAndView model;
		
		try {
			User user = (User) session.getAttribute("userSession");

			if (user == null) {
				model = new ModelAndView("redirect:login");
			} else {
				
				ProfessionBean professionBean = new ProfessionBean();

				Session ses = hibdaoimpl.getSessionfactory().openSession();
				
				professionBean = (ProfessionBean) ses.get(ProfessionBean.class, prof_id);
					
				ses.beginTransaction().commit();
				ses.clear();
				ses.close();
				
				if(professionBean.getUser_id()==user.getUserid()){
					model = new ModelAndView("editProfession");
					map.put("profession", professionBean);
				}else{
					model = new ModelAndView("redirect:profile");
				}
			}
		} catch (Exception e) {
			model = new ModelAndView("redirect:login");
		}
		return model;
	}
	
}
