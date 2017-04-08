package com.tallentview.opencontest.controler;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;

import com.tallentview.opencontest.dao.ContestDetailDao;
import com.tallentview.opencontest.dao.OpenProgramInfo;
import com.tallentview.opencontest.model.ContestInfoBean;
import com.tallentview.sampleContest.dao.ContestDetailsDao;
import com.tallentview.sampleContest.dao.SampleProgramInfo;
import com.tallentview.sampleContest.model.SapmleContestInfo;
import com.tallentview.tallentview.user.dao.UserDao;
import com.tallentview.tallentview.user.model.User;

public class SaveSapleResult {
	
	
	public ModelAndView saveSampleResult(String code,long progid,long contest_id,String user_ids){
		
		ModelAndView model = new ModelAndView("subfiles/openContest/saveSampleRes");
		
		long user_id = Long.parseLong(user_ids);
		OpenProgramInfo proginfo = new OpenProgramInfo();
		
		User user = new UserDao().getUserInfo(user_id);
		
		int tstcse = proginfo.setPath(progid);
		proginfo.saveserPath(user_ids);
		proginfo.saveProg(code);
		ContestInfoBean contestInfo = new ContestDetailDao().getContestDetails(contest_id);
		
		HashMap result = new HashMap();
		
			result = proginfo.runProg(tstcse);
			String res_str = result.get("pasedTestcases").toString();
			//String runTime = result.get("runTime").toString();
			long complition_time = 0;
			complition_time = Long.parseLong(result.get("runTime").toString());
			System.out.println("pasedTestcases:::::   "+res_str);
			String res[]=res_str.split("/");
			
			int result_int = 0;
			int total_tstsace = 0;
			try{
				result_int = Integer.parseInt(res[0].trim());
				total_tstsace = Integer.parseInt(res[1].trim());
			}catch(Exception e){
				result_int=0;
			}
			
			int score  = 0;
			try{
			score = (100*result_int)/total_tstsace;
			}catch(Exception e){}
			float scorePoint = score/100.f;
			System.out.println("scorePoint:::: "+scorePoint);
		//long complition_time = 13212;
		Date sub_date = new Date();
		proginfo.saveResult(user_id, contest_id, score, complition_time, sub_date);
		
		model.addObject("userName", user.getFname()+" "+user.getLname());
		model.addObject("result", res_str);
		model.addObject("id", contest_id); 
		model.addObject("score",+score+" / 100");
		model.addObject("contestName", contestInfo.getName());
		model.addObject("runTime", complition_time/1000.f);
		model.addObject("scorePoint", scorePoint);
		
		return model;
		 
	}

}
