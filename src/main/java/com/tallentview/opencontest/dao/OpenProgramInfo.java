package com.tallentview.opencontest.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.opencontest.model.OpenContestResult;
import com.tallentview.opencontest.model.OpenProgramBean;
import com.tallentview.sampleContest.model.SampleProgramLanguage;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;

public class OpenProgramInfo {

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

			OpenProgramBean proginfo = (OpenProgramBean) ses.get(OpenProgramBean.class, progid);//Gets all program info from database

			path = proginfo.getPath();
			System.out.println("path::::::" + path);
			tstcas = proginfo.getTestcases();
			disc = proginfo.getProg_disc();
			lang = proginfo.getProg_language();
			timelimit = proginfo.getTimelimit();

			String hql = "from SampleProgramLanguage where lang_name='" + lang + "'";//gets language information like language name, compile command, run command, program extension.
			Query query = ses.createQuery(hql);

			SampleProgramLanguage proglang = (SampleProgramLanguage) query.uniqueResult();
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
		user_dir=userid;
		String line="",sample="";
		String compilecmd = "cd /media/tallentview/user_dir/openContest/ &&mkdir "+userid+" &&cd "+userid
				+"&&mkdir "+lang+" &&cd "+lang+"&&cp -a /media/tallentview/main_contest_dir/openContest/"+lang+"/"
						+ path+" /media/tallentview/user_dir/openContest/"+userid+"/"+lang;// Create user directory
		
		String user_dir_cmd = "cd /media/tallentview/user_dir/openContest/ &&mkdir "+userid;
		String lang_dir_cmd = "cd /media/tallentview/user_dir/openContest/"+userid+" &&mkdir "+lang;
		String copy_cmd = "cp -a /media/tallentview/main_contest_dir/openContest/"+lang+"/"
						+ path+" /media/tallentview/user_dir/openContest/"+userid+"/"+lang;
		
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
		String getpro = "/media/tallentview/user_dir/openContest/"+user_dir+"/"+lang+"/" + path + "/samplecod.txt";// gets sample program structure from saved file of "samplecode.txt".

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
		String savecmd = "/media/tallentview/user_dir/openContest/"+user_dir+"/"+lang+"/" + path + "/CandidateCode." + ext; //save written program in to CandidateCode.ext....
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

	public void saveResult(long user_id, long contest_id, int result, long complition_time, Date sub_date) //Save Result with its parameter
	{
		try {
			OpenContestResult contres = new OpenContestResult();//Gates Results into data base
				contres.setUser_id(user_id);
				contres.setContest_id(contest_id);
				contres.setResult(result);
				contres.setComplition_time(complition_time);
				contres.setRequired_time(0);
				contres.setSub_date(sub_date);
	
				AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
				context.registerShutdownHook();
				HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
				Session ses = hibdaoimpl.getSessionfactory().openSession();
				
				ses.saveOrUpdate(contres);// Saves into Database
				ses.beginTransaction().commit();
				ses.evict(contres);
				
				ses.clear();
				ses.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public OpenProgramInfo() {
		// TODO Auto-generated constructor stub
	}

}
