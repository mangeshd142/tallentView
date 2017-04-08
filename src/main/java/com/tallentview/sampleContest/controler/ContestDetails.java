package com.tallentview.sampleContest.controler;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.sampleContest.dao.SampleProgramInfo;
import com.tallentview.sampleContest.model.CodeArea;
import com.tallentview.tallentview.user.model.User;

public class ContestDetails {

	String disc = "";
	long timeLimit;

	public ModelAndView getContestdetails(ModelMap map, HttpSession session, long prog_id) throws IOException {
		ModelAndView model;

		User user = (User) session.getAttribute("userSession");

		try {
			if (user == null) {
				model = new ModelAndView("redirect:/login");
			} else {

				model = new ModelAndView("startSampleContest");
				SampleProgramInfo proginfo = new SampleProgramInfo();
				proginfo.setPath(prog_id);
				proginfo.setUserPath(""+user.getUserid());
				timeLimit = proginfo.getTimeLimit();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String samplecode = proginfo.getProg();
				disc = proginfo.getDisc();
				System.out.println("description:::::::: " + disc);

				CodeArea codeArea = new CodeArea();
				codeArea.setCodeArea(samplecode);

				map.put("codeArea", codeArea);
				
				model.addObject("userId", ""+user.getUserid());
				model.addObject("detail", disc + ".jsp");
				model.addObject("timeLimit", timeLimit);
			}
		} catch (Exception e) {
			model = new ModelAndView("redirect:/login");
		}

	return model;
	}

	public String getDisc() {
		return disc;
	}

	public long getTimeLimit() {
		return timeLimit;
	}

}
