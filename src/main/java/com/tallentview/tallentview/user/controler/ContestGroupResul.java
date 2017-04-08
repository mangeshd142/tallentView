package com.tallentview.tallentview.user.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.tallentview.contest.Dao.ContestReseletDao;
import com.tallentview.contest.Dao.WinnerDao;
import com.tallentview.contest.model.ContestWinner;
import com.tallentview.contest.model.UserContestResult;
import com.tallentview.tallentview.user.dao.UserDao;
import com.tallentview.tallentview.user.model.GroupContetResultBean;
import com.tallentview.tallentview.user.model.User;

public class ContestGroupResul {

	public ModelAndView getGroupContestResult(HttpServletRequest request, HttpSession session,long group_id,long contest_id) {
		ModelAndView model;

		try {
			User user = (User) session.getAttribute("userSession");

			if (user == null) {
				model = new ModelAndView("redirect:login");
			} else {
				 model = new ModelAndView("groupDetails");
				ContestReseletDao contestReseletDao = new ContestReseletDao();
				List<UserContestResult> contestResults = contestReseletDao.getContestResult(group_id, contest_id);
				
				List<GroupContetResultBean> groupContetResultBeans = new ArrayList<GroupContetResultBean>();
				for(UserContestResult contestResult : contestResults){
					long req_time= contestResult.getRequired_time();
					String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(req_time),
				            TimeUnit.MILLISECONDS.toMinutes(req_time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(req_time)),
				            TimeUnit.MILLISECONDS.toSeconds(req_time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(req_time)));
				   // System.out.println(hms);
					
					System.out.println("userid:: "+contestResult.getUser_id()+" userResult:: "+contestResult.getResult()
					+" CompileTime::: "+contestResult.getComplition_time());
					User user2 = contestReseletDao.getUserDetail(contestResult.getUser_id());
					groupContetResultBeans.add(new GroupContetResultBean(user2.getFname()+" "+user2.getLname()
							, contestResult.getResult(), contestResult.getComplition_time(), hms));
					
				}
				WinnerDao winnerDao = new WinnerDao();
				try{
					ContestWinner contestWinner = winnerDao.getWinnerDetail(group_id, contest_id);
					System.out.println("Size of contest:::: "+contestResults.size());
					if(contestResults.size()<10){
						model.addObject("winningMessage", "Contest not completed yet");
					}
					else if(contestWinner.getUser_id()==0){
						model.addObject("winningMessage", "Contest is completed but no one wins this contest, becouse of poor result of all candidates");
					}
					else if(user.getUserid()==contestWinner.getUser_id()){
						model.addObject("winningMessage", "You are win this contest and prise amount is added to your account.");
					}
					else if(contestWinner.getUser_id()>0&&contestWinner.getUser_id()!=user.getUserid()){
						
						User user2 = new UserDao().getUserInfo(contestWinner.getUser_id());
						model.addObject("winningMessage", "Winner of this contest is "+user2.getFname()+" "+user2.getLname());
					}
				}catch(Exception e){
					e.printStackTrace();
					model.addObject("winningMessage", "Contest not completed yet");
				}
					
				model.addObject("groupResults", groupContetResultBeans);
				request.setAttribute("groupSize", groupContetResultBeans.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
			model = new ModelAndView("redirect:login");
		}

	return model;
	}
}
