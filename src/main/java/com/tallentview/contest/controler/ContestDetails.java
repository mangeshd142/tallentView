package com.tallentview.contest.controler;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.instamojo.main.GetOrderDetails;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;
import com.tallentview.contest.Dao.PaymentDao;
import com.tallentview.contest.Dao.ProgramControler;
import com.tallentview.contest.model.ContestInfo;
import com.tallentview.contest.model.PaymentContestSession;
import com.tallentview.sampleContest.dao.SampleProgramInfo;
import com.tallentview.sampleContest.model.CodeArea;
import com.tallentview.tallentview.user.model.User;

public class ContestDetails {

	String disc = "";
	long timeLimit;

	public ModelAndView getContestdetails(ModelMap map, String payment_id, HttpSession session) throws IOException {

		ModelAndView model;
		PaymentDao paymentDao = new PaymentDao();
		User user = (User) session.getAttribute("userSession");

		try {
			if (user == null) {
				model = new ModelAndView("redirect:/login");
			} else {
				PaymentContestSession paymentContestSession = (PaymentContestSession) session
						.getAttribute("paymentContestSession");
				ContestInfo contestInfo = paymentContestSession.getContestInfo();

				GetOrderDetails details = new GetOrderDetails();
				PaymentOrderDetailsResponse paymentOrderDetailsResponse = details.getOrderDetails(paymentContestSession.getOrder_id());
				
				if (paymentOrderDetailsResponse.getStatus().equals("completed")
						&&paymentOrderDetailsResponse.getAmount()==contestInfo.getEntry_fee()) {
					model = new ModelAndView("startContest");
					CodeArea codeArea = new CodeArea();

					ProgramControler programControler = new ProgramControler();
					programControler.setPath(contestInfo.getProg_id());
					//System.out.println("userid::::: "+user.getUserid());
					programControler.setUserPath(""+user.getUserid());
					timeLimit = programControler.getTimeLimit();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String samplecode = programControler.getProg();
					disc = programControler.getDisc();
					System.out.println("description:::::::: " + disc);

					try {
						codeArea.setCodeArea(samplecode);
						model.addObject("detail", disc + ".jsp");
						model.addObject("timeLimit", timeLimit);
						model.addObject("progid", contestInfo.getProg_id());
						model.addObject("contestid", contestInfo.getContest_id());
						model.addObject("userId", ""+user.getUserid());
						paymentDao.updatePaymentInfo(paymentContestSession.getTransaction_id(),
								paymentContestSession.getOrder_id(), payment_id, "", paymentOrderDetailsResponse.getStatus(),
								contestInfo.getEntry_fee());
					} catch (Exception e) {
						e.printStackTrace();
					}

					map.put("codeArea", codeArea);

				} else {
					model = new ModelAndView("redirect:/login");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			model = new ModelAndView("redirect:/login");
		}

	session.removeAttribute("paymentContestSession");
	long startTime = System.currentTimeMillis(); 
	session.setAttribute("startTime", startTime);
	return model;
	}

	public String getDisc() {
		return disc;
	}

	public long getTimeLimit() {
		return timeLimit;
	}

}
