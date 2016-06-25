package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PillarDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class PillarServlet
 */
@WebServlet(urlPatterns = { "/PillarServlet" }, initParams = { @WebInitParam(name = "PillarServlet", value = "servlet.PillarServlet") })
public class PillarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PillarDao pillarDao = new PillarDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String ip = request.getParameter("ip");
		String os = request.getParameter("os");
		/*var option = {
				legend : {  
					data : [ '数量' ]
				},
				xAxis : {
					data : [ "ip", "country", "city", "app", "device", "port","os" ]
				},
				series : [ {
					name : '数量',
					type : 'bar',
					data : [ 5, 20, 36, 10, 10, 20,10 ]
				} ]
			};*/
		JSONObject option = new JSONObject();
		JSONObject legend = new JSONObject();
		String data_l[] = {"数量"};
		legend.put("data", data_l);
		JSONObject xAxis = new JSONObject();
		String data_x[] = {"ip", "city", "port","os","service"};
		xAxis.put("data",data_x);
		JSONObject yAxis = new JSONObject();
		JSONArray jsonarray = new JSONArray();
		JSONObject s_1 = new JSONObject();
		int data_s[] = new int[5];
		try {
			data_s = pillarDao.getCount(ip,os);
		} catch (SQLException e) {
			e.printStackTrace();
/*//			for(int i=0;i<5;i++) {
//				data_s[i] = i;
//			}
*/		}
		// int data_s[] ={ 5, 20, 36, 10, 10};
		s_1.put("name", "数量");
		s_1.put("type","bar");
		s_1.put("data",data_s);
		jsonarray.add(s_1);
		option.put("legend",legend);
		option.put("xAxis",xAxis);
		option.put("yAxis",yAxis);
		option.put("series",jsonarray);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(option.toString());
		
	}
}
