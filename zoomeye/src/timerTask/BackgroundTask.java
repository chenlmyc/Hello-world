package timerTask;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import service.RunNmap;

public class BackgroundTask implements ServletContextListener {
	private RunNmap runNmap;
	private Timer timer;

	public BackgroundTask() {

	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				runNmap = new RunNmap();
				runNmap.runCommand(null);
			}
		}, 0, 24*60 * 60 * 1000);
	}
}
