package com.tallentview.tallentview;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.opencontest.controler.ContestDetails;
import com.tallentview.opencontest.controler.GetResult;
import com.tallentview.opencontest.controler.SaveSapleResult;
import com.tallentview.opencontest.dao.ContestDetailDao;

@Controller()
public class OpenContestControler {

	@RequestMapping(value = "/selectOpenContest") // Goes to selectContest Page
	public ModelAndView selectContest( HttpServletRequest request) {
		ModelAndView model = new ModelAndView("openContest");// selectContest.jsp
		ContestDetailDao contestDetailsDao = new ContestDetailDao();
		model.addObject("contestInfo", contestDetailsDao.selectContest("all", request));
		model.addObject("regist", "");

		return model;
	}
	
	@RequestMapping(value = "/getOpenContestDetail")
	public ModelAndView getsamplecontest(@RequestParam("language") String language, HttpServletRequest request) {
		System.out.println("call is here...Controler");
		ModelAndView model = new ModelAndView("subfiles/openContest/getContestDetail");// Gets
		// Contest Details from Database form given language
		// model = new SelectContest().selectContest(language, request);
		ContestDetailDao contestDetailsDao = new ContestDetailDao();
		model.addObject("contestInfo", contestDetailsDao.selectContest(language, request));
		return model;
	} 
	
	@RequestMapping(value = "openContest") // goes Select Sample contest page
	public ModelAndView SampleContest(ModelMap modelmap,HttpSession session, @RequestParam("progid") long progid) {
		ContestDetails contdetail = new ContestDetails();
		ModelAndView model = new ModelAndView();

		try {
			model = contdetail.getContestdetails(modelmap,session,progid);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}
	
	@RequestMapping(value = "getOpenresult", produces = "text/plain;charset=UTF-8") // Gets
																					// Sample
																					// Contest
																					// Result
	public ModelAndView getOpenresult(@RequestParam("codeArea") String code, @RequestParam("progid") long progid
	, @RequestParam("userId") String userId) {
		GetResult getres = new GetResult();
		
		ModelAndView model = getres.getRes(code, progid,userId);// Return compilation
		// Result
		
		System.out.println("Got Result ");
		
		return model;
	}
	
	@RequestMapping(value = "saveOpenRes", produces = "text/plain;charset=UTF-8") // Save
	// contest
	// Result
	public ModelAndView saveOpenRes(@RequestParam("codeArea") String code, @RequestParam("progid") long progid,
	@RequestParam("contestid") long contestid,@RequestParam("userId") String userId) {
		SaveSapleResult saveSapleResult = new SaveSapleResult();
		
		ModelAndView model = saveSapleResult.saveSampleResult(code, progid, contestid, userId);// Saves
					// Sample
					// Contest
					// result
					// with
					// session
					// User
					// id
		
		return model;
	}
	
}
