package com.tallentview.tallentview.user.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.tallentview.contest.Dao.ContestDetailsDao;
import com.tallentview.contest.Dao.ContestReseletDao;
import com.tallentview.contest.model.ContestInfo;
import com.tallentview.contest.model.UserContestResult;
import com.tallentview.tallentview.user.model.User;
import com.tallentview.tallentview.user.model.UserContestResultBean;

public class ContestResult {

	public ModelAndView getUserContestResult(HttpServletRequest request, HttpSession session) {
		ModelAndView model;

		try {
			User user = (User) session.getAttribute("userSession");

			if (user == null) {
				model = new ModelAndView("redirect:login");
			} else {
				 model = new ModelAndView("contestResult");
				ContestReseletDao contestReseletDao = new ContestReseletDao();
				List<UserContestResult> contestResults = contestReseletDao.getUserResult(user.getUserid());
				ContestDetailsDao contestDetailsDao = new ContestDetailsDao();
				List<UserContestResultBean> userContestResultBeans = new ArrayList<UserContestResultBean>();
				for(UserContestResult contestResult : contestResults){
					ContestInfo contestInfo = contestDetailsDao.getContestDetails(contestResult.getContest_id());
					userContestResultBeans.add(new UserContestResultBean(contestInfo.getName(),contestInfo.getLanguage()
							,contestResult.getGroup_id(),contestResult.getContest_id(),contestResult.getResult(),contestResult.getRank()));
				}
				
				model.addObject("contestResults", userContestResultBeans);
				request.setAttribute("resSize", userContestResultBeans.size()); 
			}
		} catch (Exception e) {
			model = new ModelAndView("redirect:login");
		}

	return model;
	}

}
