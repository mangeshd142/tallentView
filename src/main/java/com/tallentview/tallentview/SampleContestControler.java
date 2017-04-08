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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.sampleContest.controler.ContestDetails;
import com.tallentview.sampleContest.controler.GetResult;
import com.tallentview.sampleContest.controler.SaveSapleResult;
import com.tallentview.sampleContest.dao.SelectSapmleContest;
import com.tallentview.sampleContest.model.CodeArea;
import com.tallentview.tallentview.user.dao.DIsplayProfile;
import com.tallentview.tallentview.user.dao.LoginAuthenticate;
import com.tallentview.tallentview.user.dao.SaveProfile;
import com.tallentview.tallentview.user.dao.Signup;
import com.tallentview.tallentview.user.model.*;

@Controller()
public class SampleContestControler {

	private static final Logger logger = LoggerFactory.getLogger(SampleContestControler.class);

	@RequestMapping(value = "selectSampleContest") // Goes to
													// selectSampleContest Page
	public ModelAndView selectSampleContest(HttpServletRequest request) {

		ModelAndView model;// selectSampleContest.jsp
		model = new SelectSapmleContest().selectAllSampleContest( request);
		//model.setViewName("selectSampleContest");
		return model;
	}

	@RequestMapping(value = "SampleContest") // goes Select Sample contest page
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

	@RequestMapping(value = "getsamplecontestdetail")
	public ModelAndView getsamplecontest(@RequestParam("language") String language, HttpServletRequest request) {

		ModelAndView model;// = new
							// ModelAndView("Subfiles/getsamplecontestdetail");//Gets
							// sample Contest Details from Database
		model = new SelectSapmleContest().selectContest(language, request);
		return model;
	}

	@RequestMapping(value = "getsampleresult", produces = "text/plain;charset=UTF-8") // Gets
																						// Sample
																						// Contest
																						// Result
	public ModelAndView getsampleresult(@RequestParam("codeArea") String code, @RequestParam("progid") long progid
			, @RequestParam("userId") String userId) {
		GetResult getres = new GetResult();

		ModelAndView model = getres.getRes(code, progid,userId);// Return compilation
															// Result

		System.out.println("Got Result ");

		return model;
	}

	@RequestMapping(value = "saveSampleRes", produces = "text/plain;charset=UTF-8") // Save
																					// contest
																					// Result
	public ModelAndView saveSampleRes(@RequestParam("codeArea") String code, @RequestParam("progid") long progid,
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
