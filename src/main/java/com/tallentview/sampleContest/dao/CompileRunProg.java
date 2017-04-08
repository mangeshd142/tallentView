package com.tallentview.sampleContest.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompileRunProg implements Callable<String> {
	
	
	HashMap resultmap = new HashMap();
	
	String line, sample = "";
	
	
	String outputres="";
	String inp="";
	String cmdOutput = "";
	String codeOutput = "";
	String runtimeCompile="";
	
	String progpath="";
	String path="";
	String compile_cmd="";
	String ext="";
	String run_cmd="";
	String user_dir="";
	String lang = "";
	int testcs=0;
	
	int count = 0;
	
	public static void main(String[] args) throws InterruptedException {
		HashMap res =new HashMap();
		CompileRunProg compileRunProg = new CompileRunProg("1","java","prog1", "javac", "java", "java", 2);
		ExecutorService executor = Executors.newSingleThreadExecutor();
        
        executor.invokeAll(Arrays.asList(compileRunProg), 5, TimeUnit.SECONDS);
        
        res=compileRunProg.getResultmap();
        System.out.println(res.toString());
		
		
	}
	public HashMap getResultmap()//Returns all result Hashmap
	{
		return resultmap;
	}
	
	public CompileRunProg(String user_dir,String lang, String path, String compile_cmd, String ext, String run_cmd, int testcs)//Constructor sets Program Detail.
	{
		super();
		System.out.println("Path:: "+user_dir+ " comp cmd:: "+lang+" Extension:: "+ext+" Run cmd:: "+run_cmd+ " testcases:: "+testcs);
		this.path = path;
		this.compile_cmd = compile_cmd;
		this.ext = ext;
		this.run_cmd = run_cmd;
		this.testcs = testcs;
		this.user_dir = user_dir;
		this.lang = lang;
		resultmap.put("compile", "");
		resultmap.put("input", "");
		resultmap.put("expOutput", "");
		resultmap.put("output", "");
		resultmap.put("pasedTestcases", "");
		resultmap.put("runTime", "0");
	}

	
	@Override
	public String call() throws Exception//Callable Interface runs Task that perform compile Program and runs it
	{
		if(lang.equals("java"))
			runJava();
		else if(lang.equals("c#"))
			runCs();
		
		return null;
	}
	
	public void runJava(){
		
		System.out.println("compilig... "+run_cmd+" "+compile_cmd);
		String compilecmd = "cd /media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/ &&cd " + path + "&&" + compile_cmd + " MainProgram." + ext;// compile command
		try {
			ProcessBuilder builder2;
			builder2 = new ProcessBuilder("sh", "-c", compilecmd);//run command into terminal.
			builder2.redirectErrorStream(true);
			Process p2 = builder2.start();

			BufferedReader r2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));

			while (true) {
				line = r2.readLine();

				if (line == null) {
					break;
				}
				if (line != null) {
					sample = sample + "\n" + line;
				}
			}
			//if compile gets error it sets following results into hash map
			resultmap.put("compile", sample);
			resultmap.put("input", "");
			resultmap.put("expOutput", "");
			resultmap.put("output", "");
			resultmap.put("pasedTestcases", "");
			resultmap.put("runTime", "0");
			try{
				Thread.sleep(300);
			}
			 catch (InterruptedException e)
			  {
			       // restore interrupted status
			       e.printStackTrace();
			  }
			
			
			resultmap.get("compile").toString();
			long totalTime = 0;
			if (!resultmap.get("compile").toString().contains("error")) //if compile dosen't have any error then it goes to run program command
			{
				resultmap.put("compile", "Time Out..");
				resultmap.put("input", "");
				resultmap.put("expOutput", "");
				resultmap.put("output", "");
				resultmap.put("pasedTestcases", "");
				resultmap.put("runTime", "0");
				
				for (int i = 0; i < testcs; i++) {//It gets test cases and sets path
					progpath = "Test" + String.valueOf(i + 1);//It sets testcase path like "Test1" runs upto all test cases ends.
					cmdOutput="";
					runtimeCompile="";
					//int count = 0;
					// Input File Red----------
					StringBuilder input = new StringBuilder();
					StringBuilder output = new StringBuilder();
					String getpro = "/media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/"+path+"/"+progpath+"/inp.txt";//gets input test file form inp.txt

					try {
						BufferedReader reader = new BufferedReader(new FileReader(getpro));

						char[] buf = new char[1024];
						int r = 0;

						while ((r = reader.read(buf)) != -1) {
							input.append(buf, 0, r);
						}
					} catch (Exception e) {
						System.out.print(e);
					}

					String outputfile = "/media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/"+path+"/"+progpath+"/opt.txt";//gest output from opt.txt

					try {
						BufferedReader reader2 = new BufferedReader(new FileReader(outputfile));

						char[] buf = new char[1024];
						int r = 0;

						while ((r = reader2.read(buf)) != -1) {
							output.append(buf, 0, r);
						}
					} catch (Exception e) {
						System.out.print(e);
					}

					String runcmd = "cd /media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/&&cd "+path+"&&"+run_cmd+" MainProgram " + input; //run  command with input parameter
					ProcessBuilder builder;
					  long startTime = System.currentTimeMillis(); 
					  
					builder = new ProcessBuilder("sh", "-c", runcmd);
					builder.redirectErrorStream(true);
					Process p = builder.start();
					
					
					BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
					
					
					String line2;
					while (true) {
						line2 = r.readLine();

						if (line2 == null) {
							break;
						}
						if (line2 != null) {
							runtimeCompile =runtimeCompile+"\n"+ line2;
							cmdOutput =line2;
							
						}

					}
					long endTime = System.currentTimeMillis();
					 totalTime = endTime - startTime;
					 System.out.println("time to run rogram:::  "+totalTime);	
					
					
					
					outputres = output.toString().trim();
					inp = input.toString();
					if (cmdOutput.equals(outputres)){
						count++;
						System.out.println("if:::'"+outputres+"'"+" "+"'"+cmdOutput+"'");
					}

				}
				if(runtimeCompile.contains("Exception")){
					cmdOutput = "Run Time Exception Occured";
				}
				
				
				System.out.println("'"+outputres+"'"+" "+"'"+cmdOutput+"'");
				//after program run complete following results sets into hash map.
				resultmap.put("input", inp);
				resultmap.put("expOutput", outputres);
				resultmap.put("output", cmdOutput);
				resultmap.put("pasedTestcases", count+" / "+testcs);
				resultmap.put("compile", "Compile Sucess...\nOutput:\n"+runtimeCompile);
				resultmap.put("runTime",  ""+totalTime);
				sample = String.valueOf(count);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(sample);
	}
	
	
	

	public void runCs(){
		
		System.out.println("compilig... "+run_cmd+" "+compile_cmd);
		String compilecmd = "cd /media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/ &&cd " + path + "&&" + compile_cmd + " MainProgram." + ext+" CandidateCode."+ext;// compile command
		try {
			ProcessBuilder builder2;
			builder2 = new ProcessBuilder("sh", "-c", compilecmd);//run command into terminal.
			builder2.redirectErrorStream(true);
			Process p2 = builder2.start();

			BufferedReader r2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));

			while (true) {
				line = r2.readLine();

				if (line == null) {
					break;
				}
				if (line != null) {
					sample = sample + "\n" + line;
				}
			}
			//if compile gets error it sets following results into hash map
			resultmap.put("compile", sample);
			resultmap.put("input", "");
			resultmap.put("expOutput", "");
			resultmap.put("output", "");
			resultmap.put("pasedTestcases", "");
			resultmap.put("runTime", "0");
			try{
				Thread.sleep(300);
			}
			 catch (InterruptedException e)
			  {
			       // restore interrupted status
			       e.printStackTrace();
			  }
			
			
			resultmap.get("compile").toString();
			long totalTime = 0;
			if (!resultmap.get("compile").toString().contains("error")) //if compile dosen't have any error then it goes to run program command
			{
				resultmap.put("compile", "Time Out..");
				resultmap.put("input", "");
				resultmap.put("expOutput", "");
				resultmap.put("output", "");
				resultmap.put("pasedTestcases", "");
				resultmap.put("runTime", "0");
				
				for (int i = 0; i < testcs; i++) {//It gets test cases and sets path
					progpath = "Test" + String.valueOf(i + 1);//It sets testcase path like "Test1" runs upto all test cases ends.
					cmdOutput="";
					runtimeCompile="";
					//int count = 0;
					// Input File Red----------
					StringBuilder input = new StringBuilder();
					StringBuilder output = new StringBuilder();
					String getpro = "/media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/"+path+"/"+progpath+"/inp.txt";//gets input test file form inp.txt

					try {
						BufferedReader reader = new BufferedReader(new FileReader(getpro));

						char[] buf = new char[1024];
						int r = 0;

						while ((r = reader.read(buf)) != -1) {
							input.append(buf, 0, r);
						}
					} catch (Exception e) {
						System.out.print(e);
					}

					String outputfile = "/media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/"+path+"/"+progpath+"/opt.txt";//gest output from opt.txt

					try {
						BufferedReader reader2 = new BufferedReader(new FileReader(outputfile));

						char[] buf = new char[1024];
						int r = 0;

						while ((r = reader2.read(buf)) != -1) {
							output.append(buf, 0, r);
						}
					} catch (Exception e) {
						System.out.print(e);
					}

					String runcmd = "cd /media/tallentview/user_dir/sampleContest/"+user_dir+"/"+lang+"/&&cd "+path+"&&"+run_cmd+" MainProgram.exe " + input; //run  command with input parameter
					ProcessBuilder builder;
					  long startTime = System.currentTimeMillis(); 
					  
					builder = new ProcessBuilder("sh", "-c", runcmd);
					builder.redirectErrorStream(true);
					Process p = builder.start();
					
					
					BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
					
					
					String line2;
					while (true) {
						line2 = r.readLine();

						if (line2 == null) {
							break;
						}
						if (line2 != null) {
							runtimeCompile =runtimeCompile+"\n"+ line2;
							cmdOutput =line2;
							
						}

					}
					long endTime = System.currentTimeMillis();
					 totalTime = endTime - startTime;
					 System.out.println("time to run rogram:::  "+totalTime);	
					
					
					
					outputres = output.toString().trim();;
					inp = input.toString();
					if (cmdOutput.equals(outputres))
						count++;

				}
				if(runtimeCompile.contains("Exception")){
					cmdOutput = "Run Time Exception Occured";
				}
				
				
				
				//after program run complete following results sets into hash map.
				resultmap.put("input", inp);
				resultmap.put("expOutput", outputres);
				resultmap.put("output", cmdOutput);
				resultmap.put("pasedTestcases", count+" / "+testcs);
				resultmap.put("compile", "Compile Sucess...\nOutput:\n"+runtimeCompile);
				resultmap.put("runTime",  ""+totalTime);
				sample = String.valueOf(count);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(sample);
	}

}
