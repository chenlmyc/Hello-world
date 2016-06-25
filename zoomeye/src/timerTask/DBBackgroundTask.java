package timerTask;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.DocumentException;

import service.RestoreInfo;

public class DBBackgroundTask implements ServletContextListener {
	private Timer timer;
	private RestoreInfo restoreInfo = new RestoreInfo();
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
				try{
					restoreInfo.restore("F:\\书籍\\工程实践\\zoomeye\\zoomeye\\WebContent\\result\\result.xml");
				}catch (DocumentException | NumberFormatException | SQLException e){
					e.printStackTrace();
				}
			}
		}, 60*1000, 24*60 * 60 * 1000);
	}

}
