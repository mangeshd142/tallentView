package com.tallentview.contest.Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.contest.model.ContestWinner;
import com.tallentview.contest.model.ProgramBean;
import com.tallentview.contest.model.ProgramLanguage;
import com.tallentview.contest.model.UserContestResult;
import com.tallentview.sampleContest.model.SampleContestResult;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;
import com.tallentview.tallentview.user.dao.WalletUpdate;

public class ProgramControler {

	String path;
	int tstcas;
	String disc;
	String lang;
	String compile_cmd;
	String run_cmd;
	String ext;
	String user_dir;
	long timelimit;

	public String getDisc() {
		return disc;
	}

	public int setPath(long progid) //Used to set path and other information
	{
		try {
			System.out.println();
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			context.registerShutdownHook();
			HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");
			Session ses = hibdaoimpl.getSessionfactory().openSession();

			ProgramBean proginfo = (ProgramBean) ses.get(ProgramBean.class, progid);//Gets all program info from database

			path = proginfo.getPath();
			System.out.println("path::::::" + path);
			tstcas = proginfo.getTestcases();
			disc = proginfo.getProg_disc();
			lang = proginfo.getProg_language();
			timelimit = proginfo.getTimelimit();

			String hql = "from ProgramLanguage where lang_name='" + lang + "'";//gets language information like language name, compile command, run command, program extension.
			Query query = ses.createQuery(hql);

			ProgramLanguage proglang = (ProgramLanguage) query.uniqueResult();
			compile_cmd = proglang.getCompile_cmd();
			run_cmd = proglang.getRun_cmd();
			ext = proglang.getExtension();

			ses.clear();
			ses.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tstcas;
	}
	
	public long getTimeLimit(){
		return timelimit;
	}
	
	/*public void setPath2(long progid) //Used to set path and other information
	{
		try {
			System.out.println();
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			context.registerShutdownHook();
			HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl) context.getBean("sessionfactory");
			Session ses = hibdaoimpl.getSessionfactory().openSession();

			SampleProgramBean proginfo = (SampleProgramBean) ses.get(SampleProgramBean.class, progid);//Gets all program info from database

			path = proginfo.getPath();
			System.out.println("path::::::" + path);
			tstcas = 1;
			disc = proginfo.getProg_disc();
			lang = proginfo.getProg_language();

			String hql = "from SampleProgramLanguage where lang_name='" + lang + "'";//gets language information like language name, compile command, run command, program extension.
			Query query = ses.createQuery(hql);

			SampleProgramLanguage proglang = (SampleProgramLanguage) query.uniqueResult();
			compile_cmd = proglang.getCompile_cmd();
			run_cmd = proglang.getRun_cmd();
			ext = proglang.getExtension();
			System.out.print(compile_cmd + "  " + run_cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public void saveserPath(String userid){
		user_dir=userid;
	}
	
	public void setUserPath(String userid){
		System.out.println("userpath :::: "+userid);
		user_dir=userid;
		String line="",sample="";
		String compilecmd = "cd /media/tallentview/user_dir/contest/ &&mkdir "+userid+" &&cd "+userid
				+"&&mkdir "+lang+" &&cd "+lang+"&&cp -a /media/tallentview/main_contest_dir/contest/"+lang+"/"
						+ path+" /media/tallentview/user_dir/contest/"+userid+"/"+lang;// Create user directory
		
		String user_dir_cmd = "cd /media/tallentview/user_dir/contest/ &&mkdir "+userid;
		String lang_dir_cmd = "cd /media/tallentview/user_dir/contest/"+userid+" &&mkdir "+lang;
		String copy_cmd = "cp -a /media/tallentview/main_contest_dir/contest/"+lang+"/"
						+ path+" /media/tallentview/user_dir/contest/"+userid+"/"+lang;
		
		try {
			ProcessBuilder builder;
			builder = new ProcessBuilder("sh", "-c", user_dir_cmd);//run command into terminal.
			builder.redirectErrorStream(true);
			Process p = builder.start();
			
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while (true) {
				line = r.readLine();

				if (line == null) {
					break;
				}
				if (line != null) {
					
				}
			}
			
			
			ProcessBuilder builder2 = new ProcessBuilder("sh", "-c", lang_dir_cmd);
			builder2.redirectErrorStream(true);
			Process p2 = builder2.start();
			
			BufferedReader r2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));

			while (true) {
				line = r2.readLine();

				if (line == null) {
					break;
				}
				if (line != null) {
					
				}
			}
			
			ProcessBuilder builder3 = new ProcessBuilder("sh", "-c", copy_cmd);
			builder3.redirectErrorStream(true);
			Process p3 = builder3.start();
			 
			BufferedReader r3 = new BufferedReader(new InputStreamReader(p3.getInputStream()));

			while (true) {
				line = r3.readLine();

				if (line == null) {
					break;
				}
				if (line != null) {
					
				}
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public String getProg() throws IOException {

		StringBuilder result = new StringBuilder();
		String getpro = "/media/tallentview/user_dir/contest/"+user_dir+"/"+lang+"/" + path + "/samplecod.txt";// gets sample program structure from saved file of "samplecode.txt".

		try {
			BufferedReader reader = new BufferedReader(new FileReader(getpro));

			char[] buf = new char[1024];
			int r = 0;

			while ((r = reader.read(buf)) != -1) {
				result.append(buf, 0, r);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.println(result);
		return result.toString();//returns sample program structure.

	}

	public void saveProg(String prog) {
		String savecmd = "/media/tallentview/user_dir/contest/"+user_dir+"/"+lang+"/" + path + "/CandidateCode." + ext; //save written program in to CandidateCode.ext....
		System.out.println("file saved sucess");
		try {
			FileWriter fw = new FileWriter(savecmd);
			fw.write(prog);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("success");
	}

	public HashMap runProg(int tstcases)//compiles and run program
	{
		HashMap resultmap = new HashMap();
			CompileRunProg compileRunProg = new CompileRunProg(user_dir,lang,path, compile_cmd, ext, run_cmd, tstcases);//sets all program details
			ExecutorService executor = Executors.newSingleThreadExecutor();
	        
	        try {
				executor.invokeAll(Arrays.asList(compileRunProg), 30, TimeUnit.SECONDS);//Compile and run program here if result not get within defined second then it means multiple time loop, and returns default result
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("program run sucessifully.....");
	        resultmap = compileRunProg.getResultmap();
		return resultmap;//returns program result
	}

	public void saveResult(long user_id, long contest_id, int result, long complition_time,long requiredTime, Date sub_date,double price) //Save Result with its parameter
	{
		try {
				UserContestResult contestResult = new UserContestResult();//Gates Results into data base
				contestResult.setUser_id(user_id);
				contestResult.setContest_id(contest_id);
				contestResult.setResult(result);
				contestResult.setComplition_time(complition_time);
				contestResult.setSub_date(sub_date);
				contestResult.setRequired_time(requiredTime);
	
				AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
				context.registerShutdownHook();
				HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
				Session ses = hibdaoimpl.getSessionfactory().openSession();
				
				
				long count=0,max_grpid=0,group_id=0;
				try{
				String hql="select max(group_id) from UserContestResult where contest_id="+contest_id;
				Query query = ses.createQuery(hql);
				List listResult = query.list();
				Number number = (Number) listResult.get(0);
				max_grpid = number.intValue();
				System.out.println(max_grpid);
				
				
				String hql2="select count(group_id) from UserContestResult where contest_id="+contest_id+" and group_id="+max_grpid;
				Query query2 = ses.createQuery(hql2);
				List listResult2 = query2.list();
				Number number2 = (Number) listResult2.get(0);
				count = number2.intValue();
				System.out.println("count: "+count);
				}catch(Exception e){count=0;max_grpid=1;}
				
					
					if(count>=10){
						group_id=max_grpid+1;
					}
					else{
						group_id = max_grpid;
					}
				
					contestResult.setGroup_id(group_id);
				
				
				ses.saveOrUpdate(contestResult);// Saves into Database
				ses.beginTransaction().commit();
				ses.evict(contestResult);
				
				
					ContestReseletDao contestReseletDao = new ContestReseletDao();
					List<UserContestResult> contestResults = contestReseletDao.getContestResult(group_id, contest_id);
					int i=1;
					for(UserContestResult userContestResult : contestResults){
						System.out.println("res:: "+userContestResult);
						userContestResult.setRank(i);
						ses.update(userContestResult);
						ses.beginTransaction().commit();
						ses.evict(userContestResult);
						i++;
					}
					if(count==9){
						UserContestResult contestResult2 = contestResults.get(0);
						
						ContestWinner contestWinner = new ContestWinner();
						contestWinner.setComplition_time(contestResult2.getComplition_time());
						contestWinner.setContest_id(contestResult2.getContest_id());
						contestWinner.setGoup_id(contestResult2.getGroup_id());
						
						contestWinner.setResult(contestResult2.getResult());
						if(contestResult2.getResult()>=50){	
							contestWinner.setUser_id(contestResult2.getUser_id());
							WalletUpdate walletUpdate = new WalletUpdate();
							double walletAmount = walletUpdate.getWalletAmount(contestResult2.getUser_id())+price;
							System.out.println("winner:::::: "+contestResult2.getUser_id());
							walletUpdate.upadteWallet(contestResult2.getUser_id(), walletAmount);
						}
						else {
							contestWinner.setUser_id(0);
						}
						WinnerDao winnerDao = new WinnerDao();
						winnerDao.winnerDetailsSaave(contestWinner);
					}
					
					i=0;
					
					ses.clear();
					ses.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ProgramControler() {
		// TODO Auto-generated constructor stub
	}

}
