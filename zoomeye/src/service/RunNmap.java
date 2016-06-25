package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class RunNmap {
	/*
	 * 运行nmap命令
	 * */
	public void runCommand(String cmd) {
		BufferedReader br = null;
		try{
			Process p = Runtime.getRuntime().exec(cmd + " -oX result.xml --unprivileged",null,new File("F:\\书籍\\工程实践\\zoomeye\\zoomeye\\WebContent\\result"));
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null){
				System.out.println(line);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{

			if(br != null){
				try{
					br.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
