package com.tallentview.sampleContest.controler;

import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;

import com.tallentview.sampleContest.dao.SampleProgramInfo;

public class GetResult {
	
	
	public ModelAndView getRes(String code,long progid,String userId){
		ModelAndView model = new ModelAndView("Subfiles/getsampleres");
	
		SampleProgramInfo proginfo = new SampleProgramInfo();
		
		proginfo.setPath(progid);
		proginfo.saveserPath(""+userId);
		proginfo.saveProg(code);
		HashMap res = proginfo.runProg(1);
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
