package com.tallentview.tallentview;


import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.sampleContest.controler.ContestDetails;
import com.tallentview.sampleContest.model.CodeArea;
import com.tallentview.tallentview.dao.SupportDao;
import com.tallentview.tallentview.module.SupportBean;
import com.tallentview.tallentview.user.controler.ContestGroupResul;
import com.tallentview.tallentview.user.controler.ContestResult;
import com.tallentview.tallentview.user.dao.DIsplayProfile;
import com.tallentview.tallentview.user.dao.EducationDao;
import com.tallentview.tallentview.user.dao.ForgotDao;
import com.tallentview.tallentview.user.dao.ForgotResetPassword;
import com.tallentview.tallentview.user.dao.LoginAuthenticate;
import com.tallentview.tallentview.user.dao.ProfessionDao;
import com.tallentview.tallentview.user.dao.ResetPasswordDao;
import com.tallentview.tallentview.user.dao.SaveProfile;
import com.tallentview.tallentview.user.dao.Signup;
import com.tallentview.tallentview.user.model.*;
 



/** 
 * Handles requests for the application home page.
 */
@Controller()
public class HomeController {
	 
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/** 
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")// Main Controler
	public ModelAndView home() {
		 
		
		
		ModelAndView model = new ModelAndView("index");
		
		return model;
	}
	
	
	
	@RequestMapping(value = "/sample",method = RequestMethod.GET) //User results displayed here
	public ModelAndView sample() {
		ModelAndView model = new ModelAndView("sample");
				  
		return model;
	}
	
	
	
	
	@RequestMapping(value = "/robots.txt", produces = {"text/plain"}, method = RequestMethod.GET)
	@ResponseBody
	public String getRobotsTxt() {
	    return "User-agent: *" + 
	   "\n" + "Disallow: /selectContest" + 
	   "\n" + "Disallow: /proceedContest" +
	   "\n" + "Disallow: /contest" + 
	   "\n" + "Disallow: /hiringContest" + 
	   "\n" + "Disallow: /skillPages"+ 
	   "\n" + "Disallow: /terms&condition";
	} 
	
	
	
	@RequestMapping(value = "/skillPages", method = RequestMethod.GET)
	public ModelAndView skillPages() {
		ModelAndView model = new ModelAndView("skillPage");		   
	    return model;
	}
	
	@RequestMapping(value = "/hiringContest", method = RequestMethod.GET)
	public ModelAndView hiringContest() {
		ModelAndView model = new ModelAndView("hiringContest");		   
	    return model;
	}
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public ModelAndView aboutUs() {
		ModelAndView model = new ModelAndView("aboutUs");		   
	    return model;
	}
	@RequestMapping(value = "/terms&condition", method = RequestMethod.GET)
	public ModelAndView terms() {
		ModelAndView model = new ModelAndView("terms");		   
	    return model;
	}
	
	@RequestMapping(value = "/support", method = RequestMethod.GET)
	public ModelAndView support(ModelMap modelmap) {
		ModelAndView model = new ModelAndView("support");	
		modelmap.put("support",new SupportBean());
	    return model;
	}
	
	@RequestMapping(value = "/thankYou", method = RequestMethod.POST)
	public ModelAndView thankYou(@Valid @ModelAttribute("support") SupportBean supportBean,BindingResult result) {
		ModelAndView model;
		if(result.hasErrors()){
			return new ModelAndView("support");// If Validation Problem return results on same Page
		}
		SupportDao supportDao = new SupportDao();
		model = supportDao.saveSupport(supportBean);
	    return model; 
	}
	
	
	
}
