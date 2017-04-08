package com.tallentview.contest.controler;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.tallentview.contest.Dao.ContestDetailsDao;
import com.tallentview.contest.Dao.ProgramControler;
import com.tallentview.contest.model.ContestInfo;
import com.tallentview.tallentview.user.dao.UserDao;
import com.tallentview.tallentview.user.model.User;

public class SaveContestResult {
	
	
	public ModelAndView saveSampleResult(String code,long progid,long contest_id,String user_ids,HttpSession session){
		long startTime = (Long) session.getAttribute("startTime");
		long endTime = System.currentTimeMillis(); 
		long totalTime = endTime - startTime;
		
		String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(totalTime),
	            TimeUnit.MILLISECONDS.toMinutes(totalTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(totalTime)),
	            TimeUnit.MILLISECONDS.toSeconds(totalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime)));
	   // System.out.println(hms);
		
		
		ModelAndView model = new ModelAndView("Subfiles/contest/saveResult");
		System.out.println("user bef:::: "+user_ids);
		long user_id = Long.parseLong(user_ids);
		User user = new UserDao().getUserInfo(user_id);
		ProgramControler controler = new ProgramControler();
		
		int tstcse = controler.setPath(progid);
		controler.saveserPath(user_ids);
		controler.saveProg(code);
		ContestInfo contestInfo = new ContestDetailsDao().getContestDetails(contest_id);
		double prise = contestInfo.getPrise();
		
		HashMap result = new HashMap();
		
			result = controler.runProg(tstcse);
			String res_str = result.get("pasedTestcases").toString();
			//String runTime = result.get("runTime").toString();
			long complition_time = 0;
			complition_time = Long.parseLong(result.get("runTime").toString());
			
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
		
		
		controler.saveResult(user_id, contest_id, score, complition_time,totalTime, sub_date,prise);
		
		model.addObject("userName", user.getFname()+" "+user.getLname());
		model.addObject("result", res_str); 
		model.addObject("id", contest_id); 
		model.addObject("score",+score+" / 100");
		model.addObject("contestName", contestInfo.getName());
		model.addObject("runTime", complition_time/1000.f);
		model.addObject("scorePoint", scorePoint);
		
		model.addObject("conetstTime", hms);
		
		System.out.println("Time required to submit::::::   "+totalTime);
		
		return model;
		 
	}

}
