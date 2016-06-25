package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BiscuitDao;
import dao.PillarDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Biscuit
 */
@WebServlet(
		urlPatterns = { "/BiscuitServlet" }, 
		initParams = { 
				@WebInitParam(name = "BiscuitServlet", value = "servlet.BiscuitServlet")
		})
public class BiscuitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PillarDao pillarDao = new PillarDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String ip = request.getParameter("ip");
		String os = request.getParameter("os");
		JSONObject option = new JSONObject();
		option.put("backgroundColor", "#2c343c");
		JSONObject title = new JSONObject();
		title.put("text","Customiszed Pie");
		title.put("left","center");
		title.put("top",20);
		JSONObject textStyle = new JSONObject();
		textStyle.put("color", "#ccc");
		title.put("textStyle",textStyle);
		option.put("title",title);
		JSONObject tooltip = new JSONObject();
		tooltip.put("trigger","item");
		tooltip.put("formatter","{a}<br/>{b}:{c}({d}%)");
		option.put("tooltip",tooltip);
		JSONObject visualMap = new JSONObject();
		visualMap.put("show", false);
		visualMap.put("min", 80);
		visualMap.put("max",600);
		JSONObject inRange  = new JSONObject();
		int []colorLightness = {0, 1};
		inRange.put("colorLightness", colorLightness);
		option.put("visualMap",visualMap);
		JSONArray series = new JSONArray();
		JSONObject s = new JSONObject();
		s.put("name","访问来源");
		s.put("type","pie");
		String[] center = {"50%","50%"};
		s.put("radius","55%");
		s.put("center",center);
		JSONArray data = new JSONArray();
		JSONObject d1 = new JSONObject();
		try {
			int osv = pillarDao.getOsCount(ip, os);
			d1.put("value",osv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			d1.put("value",120);
			e.printStackTrace();
		}
		d1.put("name","os");
		JSONObject d2 = new JSONObject();
		try {
			int servicev = pillarDao.getServiceCount(ip, os);
			int ipv = pillarDao.getIpCount(ip, os);
			int portv = pillarDao.getPortCount(ip, os);
			d2.put("value",servicev);
			
		} catch (SQLException e) {
			d2.put("value",310);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		d2.put("name","service");
		JSONObject d3 = new JSONObject();
		try {
			int ipv = pillarDao.getIpCount(ip, os);
			d3.put("value",ipv);
		} catch (SQLException e){
			d3.put("value",200);
			e.printStackTrace();
		}
		d3.put("name","ip");
		JSONObject d4 = new JSONObject();
		try {
			int cityv = pillarDao.getCityCount(ip, os);
			d4.put("value",cityv);
		} catch (SQLException e) {
			d4.put("value",100);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d4.put("name","city");
		JSONObject d5 = new JSONObject();
		try {
			int portv = pillarDao.getPortCount(ip, os);
			d5.put("value",portv);
		} catch (SQLException e) {
			d5.put("value",432);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d5.put("name","port");
		data.add(d1);
		data.add(d2);
		data.add(d3);
		data.add(d4);
		data.add(d5);		
		s.put("data",data);
		s.put("roseType","angle");
		JSONObject label = new JSONObject();
		JSONObject l1 =new JSONObject();
		JSONObject l11 = new JSONObject();
		l11.put("color","rgba(255,255,255,0.3)");
		l1.put("lineStyle",l11);
		label.put("normal",l1);
		s.put("label",label);
		JSONObject labelLine = new JSONObject();
		labelLine.put("normal",new JSONObject().put("color", "rgba(255,255,255,255,0/3)"));
		labelLine.put("smooth",0.2);
		labelLine.put("length",10);
		labelLine.put("length2",20);
		JSONObject normal = new JSONObject();
		normal.put("color","#c23531");
		normal.put("shadowBlur",200);
		normal.put("shadowColor","rgba(0,0,0,0.5)");
		JSONObject itemStyle =new JSONObject();
		itemStyle.put("normal",normal);
		series.add(s);
		option.put("series",series);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(option.toString());
	}

}
