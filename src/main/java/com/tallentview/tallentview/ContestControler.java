package com.tallentview.tallentview;

import java.io.IOException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.instamojo.main.GetOrderDetails;
import com.instamojo.main.InstamojoMain;
import com.tallentview.contest.Dao.ContestDetailsDao;
import com.tallentview.contest.controler.CompileResult;
import com.tallentview.contest.controler.ContestDetails;
import com.tallentview.contest.controler.ProceedToContest;
import com.tallentview.contest.controler.SaveContestResult;
import com.tallentview.contest.model.ContestInfo;
import com.tallentview.contest.model.PaymentContestSession;

@Controller()
public class ContestControler {

	private static final Logger logger = LoggerFactory.getLogger(ContestControler.class);

	@RequestMapping(value = "/selectContest") // Goes to selectContest Page
	public ModelAndView selectContest( HttpServletRequest request) {
		ModelAndView model = new ModelAndView("selectContest");// selectContest.jsp
		ContestDetailsDao contestDetailsDao = new ContestDetailsDao();
		model.addObject("contestInfo", contestDetailsDao.selectContest("all", request));
		model.addObject("regist", "");

		return model;
	}
	
	@RequestMapping(value = "/getContestDetail")
	public ModelAndView getsamplecontest(@RequestParam("language") String language, HttpServletRequest request) {
		System.out.println("call is here...Controler");
		ModelAndView model = new ModelAndView("Subfiles/contest/getContestDetail");// Gets
		// Contest Details from Database form given language
		// model = new SelectContest().selectContest(language, request);
		ContestDetailsDao contestDetailsDao = new ContestDetailsDao();
		model.addObject("contestInfo", contestDetailsDao.selectContest(language, request));
		return model;
	} 
	
	@RequestMapping(value = "/proceedContest") // Goes to selectContest Page
	public ModelAndView proceedContest(@RequestParam("contestid") long contestid,HttpSession session) {
 
		ModelAndView model = new ProceedToContest().proceedContest(contestid,session);// selectContest.jsp
		
		return model;
	}

	@RequestMapping(value = "/contest") // goes Select Sample contest page
	public ModelAndView SampleContest(ModelMap modelmap, @RequestParam("payment_id") String payment_id, HttpSession session) {
		
		ModelAndView model = new ModelAndView(); 
		
			try {
				model = new ContestDetails().getContestdetails(modelmap,payment_id,session);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return model;
	}

	@RequestMapping(value = "/getresult", produces = "text/plain;charset=UTF-8") // Gets
	// Sample
	// Contest
	// Result
	public ModelAndView getsampleresult(@RequestParam("codeArea") String code, @RequestParam("progid") long progid,@RequestParam("userId") String userId) {
		System.out.println("code::: "+code);
		CompileResult result = new CompileResult();

		ModelAndView model = result.getRes(userId,code, progid);// Return compilation
		// Result

		System.out.println("Got Result ");

		return model;
	}

	@RequestMapping(value = "/saveResult", produces = "text/plain;charset=UTF-8") // Save
	// contest
	// Result
	public ModelAndView saveSampleRes(@RequestParam("codeArea") String code, @RequestParam("progid") long progid,
			@RequestParam("contestid") long contestid,@RequestParam("userId") String userId,HttpSession session) {
		SaveContestResult contestResult = new SaveContestResult(); 
System.out.println("From Main Contest");
		ModelAndView model = contestResult.saveSampleResult(code, progid, contestid, userId,session);// Saves
		// Sample  
		// Contest
		// result
		// with
		// session
		// User
		// id
 
		return model;
	} 
	@RequestMapping(value = "/paymentAuth") // Save
	// contest
	// Result
	public ModelAndView sample(@RequestParam("transaction_id") String transaction_id,
				@RequestParam("id") String id,@RequestParam("payment_id") String payment_id) {
		
		
		
		ModelAndView model = new ModelAndView("Sample");
		model.addObject("transaction_id", transaction_id);
		model.addObject("id", id);
		model.addObject("payment_id", payment_id);
 
		return model;
	}
	

}
