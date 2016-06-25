package timerTask;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import service.CaculateTime;
import service.RunNmap;

public class NmapBackgroundTask implements ServletContextListener {
	private RunNmap runNmap = new RunNmap();
	
	private Timer timer;

	public NmapBackgroundTask() {

	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		timer.cancel();
	}
	/*
	 * 定时任务：1 每隔一天运行一次nmap，获取数据储存到本地文件result.xml中
	 * 		  
	 * */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		timer = new Timer();
		int delay = 0;
		delay = CaculateTime.nmapTime;
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				String cmd = CaculateTime.cmd;
				runNmap.runCommand(cmd);
				
			}
		},delay , 24*60 * 60 * 1000);
	}
}
