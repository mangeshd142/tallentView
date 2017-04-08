package com.tallentview.contest.controler;

import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;

import com.tallentview.contest.Dao.ProgramControler;

public class CompileResult {
	
	public ModelAndView getRes(String userId,String code,long progid){
		ModelAndView model = new ModelAndView("Subfiles/contest/getResult");
		
		ProgramControler controler = new ProgramControler();
		
		controler.setPath(progid);
		controler.saveserPath(userId);
		controler.saveProg(code);
		HashMap res = controler.runProg(1);
		
		String testStatus="false";
		
		System.out.println(res.get("pasedTestcases").toString() + "status::: "+res.get("pasedTestcases").toString().contains("1 / 1"));
		if(res.get("pasedTestcases").toString().contains("1 / 1"))
			testStatus="true";
		else
			testStatus = "false";
		
		model.addObject("compile",res.get("compile").toString());
		model.addObject("input",res.get("input").toString());
		model.addObject("expOutput",res.get("expOutput").toString()); 
		model.addObject("output",res.get("output").toString());
		model.addObject("pasedTestcases",testStatus);
	
	return model;
	}

}
