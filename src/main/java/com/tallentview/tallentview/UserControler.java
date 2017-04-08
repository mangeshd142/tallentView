package com.tallentview.tallentview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tallentview.tallentview.user.controler.ContestGroupResul;
import com.tallentview.tallentview.user.controler.ContestResult;
import com.tallentview.tallentview.user.dao.DIsplayProfile;
import com.tallentview.tallentview.user.dao.EducationDao;
import com.tallentview.tallentview.user.dao.ForgotDao;
import com.tallentview.tallentview.user.dao.ForgotResetPassword;
import com.tallentview.tallentview.user.dao.LoginAuthenticate;
import com.tallentview.tallentview.user.dao.ProfessionDao;
import com.tallentview.tallentview.user.dao.ResetPasswordDao;
import com.tallentview.tallentview.user.dao.SaveProfile;
import com.tallentview.tallentview.user.dao.Signup;
import com.tallentview.tallentview.user.dao.UserAccountInfoDao;
import com.tallentview.tallentview.user.model.AccountDetails;
import com.tallentview.tallentview.user.model.EducationBean;
import com.tallentview.tallentview.user.model.ForgotLogin;
import com.tallentview.tallentview.user.model.Login;
import com.tallentview.tallentview.user.model.ProfessionBean;
import com.tallentview.tallentview.user.model.Profile;
import com.tallentview.tallentview.user.model.User;

@Controller()
public class UserControler {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET) //Login Controler
	public ModelAndView login( ModelMap modelmap,HttpSession session) {
		 
		ModelAndView model;
		try{ 
			User user=(User)session.getAttribute("userSession");
			if(user==null) {
				modelmap.put("login", new Login());
				 model = new ModelAndView("login");
			}else {
				model = new ModelAndView("redirect:/");
			}
		}
		catch(Exception e){
			modelmap.put("login", new Login());
			 model = new ModelAndView("login");
		}
		return model;
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)// Login authentication Controler
	public String authenticate(@Valid @ModelAttribute("login")  Login login,BindingResult result,HttpSession session) {
		
		if(result.hasErrors()){
			
			return "login";
		}
		else{
		LoginAuthenticate loginAuthenticate = new LoginAuthenticate();
		
		return loginAuthenticate.authenticate(login,session,result);
		}
	}
	
	@RequestMapping(value = "/logout")//Logout Controler
	public ModelAndView logout(HttpSession session ) {
		

		session.removeAttribute("userSession");
		session.invalidate();
		
		ModelAndView model = new ModelAndView("redirect:/");
				
		return model;
	}
	
	@RequestMapping(value = "/register") //Signup Controler
	public ModelAndView signup(ModelMap modelmap,HttpSession session) {
		
		
		ModelAndView model;
		try{ 
			User user=(User)session.getAttribute("userSession");
			if(user==null) {
				modelmap.put("signup", new User());
				model = new ModelAndView("signup");
			}else {
				model = new ModelAndView("redirect:/");
			}
		}
		catch(Exception e){
			modelmap.put("signup", new User());
			
			model = new ModelAndView("signup");
		}
						
		return model;
	} 
	@RequestMapping(value = "/signup", method = RequestMethod.POST)//Signup Page Controler
	public ModelAndView signupsus(@Valid @ModelAttribute("signup") User user,BindingResult result,HttpSession session) {
		ModelAndView model;
		if(result.hasErrors()){
			model = new ModelAndView("signup");
			return model;
		}else{
			Signup signup = new Signup();
			try{
			model = signup.signup(user, session);
			return model;
			}catch(Exception e){
				result.rejectValue("email", "error.user", "An account already exists for this email.");
				model = new ModelAndView("signup");
				return model;
			}
			
		}
	}
	@RequestMapping(value = "/profile") //Profile Controler
	public ModelAndView profile(HttpSession session,HttpServletRequest request) { 
		ModelAndView model;
		try{ 
			User user=(User)session.getAttribute("userSession");
			
			if(user==null) {
				model = new ModelAndView("redirect:login");
	   		}
	       else{
				DIsplayProfile dispProf = new DIsplayProfile();
			 model = dispProf.displayProfile(user,request); //Return Result Of user profile Details .
			 model.addObject("name", user.getFname()+" "+user.getLname());
			 model.addObject("emailId", user.getEmail());
	       }	 
		}catch(NullPointerException e){
			model = new ModelAndView("redirect:login");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/editProfile") //Edit Profile
	public ModelAndView editProfile(ModelMap modelmap,HttpSession session) {
		ModelAndView model;
		try{
				User user=(User)session.getAttribute("userSession");
				
				
				if(user==null) {
					model = new ModelAndView("redirect:login");
		   		}
		       else{
		    	   DIsplayProfile dispprof = new DIsplayProfile();
					Profile profile = dispprof.dispEditProfile(user);//returns Current ser Profile Details.
					
					modelmap.put("profile", profile);
		    	  model = new ModelAndView("editProfile");
		       }	
				}catch(NullPointerException e){
				model = new ModelAndView("redirect:login"); 
			}
				
		return model;
	}
	
	@RequestMapping(value = "/saveProfile" )// Save Profile Details From Edit Profile
	public ModelAndView saveProfile(@Valid @ModelAttribute("profile")Profile profile, BindingResult result,HttpSession session) {
		
		
		SaveProfile saveProfile = new SaveProfile();
		if(result.hasErrors()){
			
			return new ModelAndView("editProfile");// If Validation Problem return results on same Page
		}
		else{		
		return saveProfile.saveProfile(profile,session);//else return to profile page
		}
	} 
	
	@RequestMapping(value = "/addEducation") //Edit Profile
	public ModelAndView addEducation(ModelMap modelmap,HttpSession session){
		ModelAndView model = new ModelAndView("addEducation");
		EducationBean educationBean = new EducationBean();
		modelmap.put("addEducation", educationBean);
		return model;
	}
	
	@RequestMapping(value = "/editEducation",method = RequestMethod.GET) //Edit Profile
	public ModelAndView editEducation(ModelMap modelmap,@ModelAttribute("edu_id") long edu_id,HttpSession session){
		EducationDao educationDao = new EducationDao();
		ModelAndView model =  educationDao.getEducation(edu_id, session,modelmap);
		return model;
	}
	
	@RequestMapping(value = "/saveEducation",method = RequestMethod.GET )// Save Profile Details From Edit Profile
	public ModelAndView saveEducation(@Valid @ModelAttribute("addEducation")EducationBean educationBean, BindingResult result,HttpSession session) {
		if(result.hasErrors()){
			return new ModelAndView("addEducation");// If Validation Problem return results on same Page
		}
		else{
		EducationDao educationDao = new EducationDao();
		
		return educationDao.saveEducation(educationBean, session);
		}
	}
	@RequestMapping(value = "/saveEditedEducation",method = RequestMethod.GET )// Save Profile Details From Edit Profile
	public ModelAndView saveEditedEducation(@Valid @ModelAttribute("addEducation")EducationBean educationBean, BindingResult result,HttpSession session) {
		if(result.hasErrors()){
			return new ModelAndView("editEducation");// If Validation Problem return results on same Page
		}
		else{
		EducationDao educationDao = new EducationDao();
		
		return educationDao.saveEducation(educationBean, session);
		}
	}
	
	@RequestMapping(value = "/addProfession") //Edit Profile
	public ModelAndView addProfession(ModelMap modelmap,HttpSession session){
		ModelAndView model = new ModelAndView("addProfession");
		ProfessionBean professionBean = new ProfessionBean();
		modelmap.put("profession", professionBean);
		return model;
	}
	
	@RequestMapping(value = "/editProfession",method = RequestMethod.GET) //Edit Profile
	public ModelAndView editProfession(ModelMap modelmap,@ModelAttribute("prof_id") long prof_id,HttpSession session){
		ProfessionDao professionDao = new ProfessionDao();
		ModelAndView model =  professionDao.getProfesson(prof_id, session,modelmap);
		return model;
	}
	
	@RequestMapping(value = "/saveProfession",method = RequestMethod.GET )// Save Profile Details From Edit Profile
	public ModelAndView saveProfession(@Valid @ModelAttribute("profession")ProfessionBean professionBean, BindingResult result,HttpSession session) {
		if(result.hasErrors()){
			return new ModelAndView("addProfession");// If Validation Problem return results on same Page
		}
		else{
		ProfessionDao professionDao = new ProfessionDao();
		
		return professionDao.saveProfession(professionBean, session);
		}
	}
	
	@RequestMapping(value = "/saveEditProfession",method = RequestMethod.GET )// Save Profile Details From Edit Profile
	public ModelAndView saveEditProfession(@Valid @ModelAttribute("profession")ProfessionBean professionBean, BindingResult result,HttpSession session) {
		if(result.hasErrors()){
			return new ModelAndView("editProfession");// If Validation Problem return results on same Page
		}
		else{
		ProfessionDao professionDao = new ProfessionDao();
		
		return professionDao.saveProfession(professionBean, session);
		}
	}
	
	
	@RequestMapping(value = "/contestResult") //User results displayed here
	public ModelAndView contestResult(HttpServletRequest request,HttpSession session) {
		ContestResult contestResult = new ContestResult();
		ModelAndView model = contestResult.getUserContestResult(request, session);
				
		return model;
	}
	
	@RequestMapping(value = "/groupDetails",method = RequestMethod.GET) //User results displayed here
	public ModelAndView groupDetails(HttpServletRequest request,HttpSession session
			,@RequestParam("groupid") long groupid,@RequestParam("contid") long contid) {
		ContestGroupResul contestGroupResul = new ContestGroupResul();
		ModelAndView model = contestGroupResul.getGroupContestResult(request, session, groupid, contid);
				  
		return model;
	}
	
	@RequestMapping(value = "/forgot", produces = {"text/plain"}, method = RequestMethod.GET)
	@ResponseBody
	public String forgot(@RequestParam("forgot_email") String email) {
		System.out.println("from valid"+email);
		ForgotDao forgotDao =new ForgotDao();
		   
	    return forgotDao.setForgot(email);
	}
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public ModelAndView resetPassword(@Valid @ModelAttribute("forgotLogin") ForgotLogin forgotLogin, BindingResult result,HttpSession session) {
		ModelAndView model = new ModelAndView("resetPassword");
		if(result.hasErrors()){
			return new ModelAndView("index");// If Validation Problem return results on same Page
		}
		session.setAttribute("email", forgotLogin.getEmail());
		ForgotResetPassword forgotResetPassword = new ForgotResetPassword();
		
	    return forgotResetPassword.resetForgotAuthentication(forgotLogin);
	}
	
	
	@RequestMapping(value = "/resetAuth", method = RequestMethod.GET)
	public ModelAndView resetAuth(HttpSession session,@RequestParam("password") String password,@RequestParam("repassword") String repassword) {
		
		System.out.println("password :: "+password);
		System.out.println("Repassword :: "+repassword);
		System.out.println("email :: "+session.getAttribute("email"));
		String email = (String)session.getAttribute("email");
		session.removeAttribute("email");
		ResetPasswordDao resetPasswordDao = new ResetPasswordDao();
		
	    return resetPasswordDao.resetPassword(email, password);
	}
	
	
	@RequestMapping(value = "/claim", method = RequestMethod.GET)
	public ModelAndView claim(ModelMap modelmap, HttpSession session) {
		//ModelAndView model = new ModelAndView("claim");	
		
		ModelAndView model;
		try{ 
			User user=(User)session.getAttribute("userSession");
			if(user==null) {
				model = new ModelAndView("redirect:/");
			}else {
				modelmap.put("account", new AccountDetails());
				 model = new ModelAndView("claim");
				
			}
		} 
		catch(Exception e){
			model = new ModelAndView("redirect:/");
		}
		return model;
	}
	
	@RequestMapping(value = "/authnticateAccountInfo", method = RequestMethod.POST)
	public ModelAndView authnticateAccountInfo(@Valid @ModelAttribute("account") AccountDetails accountDetails, BindingResult result,HttpSession session) {
		
		ModelAndView model;
		if(result.hasErrors()){
			return new ModelAndView("claim");// If Validation Problem return results on same Page
		}
		try{
			User user=(User)session.getAttribute("userSession");
			if(user==null) {
				model = new ModelAndView("redirect:/");
			}else {
				UserAccountInfoDao userAccountInfoDao  = new UserAccountInfoDao();
				model = userAccountInfoDao.saveAccountInfo(accountDetails, user.getUserid());
				 
				
			}
		} 
		catch(Exception e){
			model = new ModelAndView("redirect:/");
		}
		return model;
	}
	
	
}
