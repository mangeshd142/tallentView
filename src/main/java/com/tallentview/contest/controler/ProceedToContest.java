package com.tallentview.contest.controler;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.instamojo.main.InstamojoMain;
import com.tallentview.contest.Dao.ContestDetailsDao;
import com.tallentview.contest.Dao.PaymentDao;
import com.tallentview.contest.Dao.ProgramInfoDao;
import com.tallentview.contest.model.ContestInfo;
import com.tallentview.contest.model.PaymentContestSession;
import com.tallentview.contest.model.ProgramBean;
import com.tallentview.tallentview.user.model.User;

public class ProceedToContest {

	public ModelAndView proceedContest(long contestId, HttpSession session) {

		ModelAndView model;

		User user = (User) session.getAttribute("userSession");

		try {
			if (user == null) {
				model = new ModelAndView("redirect:/login");
			} else {
				model = new ModelAndView("proceedContest");
				ContestDetailsDao contestDetailsDao = new ContestDetailsDao();
				ContestInfo contestInfo = contestDetailsDao.getContestDetails(contestId);
				ProgramInfoDao programInfoDao = new ProgramInfoDao(); 
				ProgramBean programBean = programInfoDao.getProgramInfo(contestInfo.getProg_id());
				String name = user.getFname() + " " + user.getLname(), email_id = user.getEmail(),
						phone_no = "9860966979";

				model.addObject("contestInfo", contestInfo);
				String hms = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(programBean.getTimelimit()),
			            TimeUnit.SECONDS.toMinutes(programBean.getTimelimit()) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(programBean.getTimelimit())),
			            TimeUnit.SECONDS.toSeconds(programBean.getTimelimit()) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(programBean.getTimelimit())));
			  
				model.addObject("timeLimit", hms);

				PaymentDao paymentDao = new PaymentDao();
				InstamojoMain instamojoMain = new InstamojoMain();

				String transaction_id = paymentDao.setPaymentInfo(user.getUserid(), contestInfo.getContest_id());
				String order_id = instamojoMain.CreateLink(name, email_id, phone_no, transaction_id,
						contestInfo.getName(), contestInfo.getEntry_fee());
				PaymentContestSession paymentContestSession = new PaymentContestSession(contestInfo, transaction_id,
						order_id);

				session.setAttribute("paymentContestSession", paymentContestSession);

				model.addObject("order_id", order_id);
			}
		} catch (Exception e) {
			model = new ModelAndView("redirect:/login");
		}
		return model;
	}

}
