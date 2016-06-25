package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CaculateTime;
import service.RunNmap;

/**
 * Servlet implementation class BackServlet
 */
@WebServlet(
		urlPatterns = { "/BackServlet" }, 
		initParams = { 
				@WebInitParam(name = "BackServlet", value = "servlet.BackServlet")
		})
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RunNmap runmap = new RunNmap();  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date start = new Date();
		String ip = request.getParameter("ip");
		String port = request.getParameter("port");
		String os = request.getParameter("os");
		String nmapTime = request.getParameter("nmapTime");
		String dbTime = request.getParameter("dbTime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date end = new Date();
		Date endD = new Date();
		try {
			end = sdf.parse(nmapTime);
			endD = sdf.parse(dbTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int delayN = (int) (end.getTime() - start.getTime());
		int delayD = (int) (endD.getTime() - start.getTime());
		String cmd = "";
		// nmap  -v 202.141.160.8 -p 80
		if (port != null && os != null) {
			cmd = "nmap -v " + ip + " -p " + port + "-O " + os;
		} 
		else if (port != null && os == null) {
			cmd = "nmap -v " + ip + " -p " + port;
		}
		else if (port == null && os != null) {
			cmd = "nmap -v " + ip + " -O " + os;
		}
		else {
			cmd = null;
		}
		CaculateTime.cmd = cmd;
		CaculateTime.dbTime = delayD;
		CaculateTime.nmapTime = delayN;
	}

}
