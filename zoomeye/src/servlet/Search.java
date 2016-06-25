package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.HostDao;
import service.Parse;
import tools.JsonHelper;
import model.Host;

@WebServlet(
		urlPatterns = { "/Search" }, 
		initParams = { 
				@WebInitParam(name = "Search", value = "servlet.Search")
		})
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Parse parse;
	private HostDao hostDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order = request.getParameter("order");
		String limit = request.getParameter("limit");
		String offset = request.getParameter("offset");
		request.setCharacterEncoding("utf-8");
		//response.getWriter().write("[ {'ip' : '01,'location' : 'Item 0','port' : '$0','service' : 'http'}]");
		Object object = hostDao.findHostFromIP("123.123.123.123");
		JSONObject data = new JSONObject(JsonHelper.obj2json(object));
		request.setAttribute("ojb", data);
		response.getWriter().write(data.toString());
		//request.getRequestDispatcher("result.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchText = request.getParameter("searchString");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("查询字符串："+searchText);
		parse = new Parse();
		HashMap<String, String> tokens =  parse.getToken(searchText);
		System.out.println(tokens.size());
		hostDao = new HostDao();
		Iterator it = tokens.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = (Entry<String, String>) it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			
			Object object = hostDao.findHostFromIP(value);
			JSONObject data = new JSONObject(JsonHelper.obj2json(object));
			request.setAttribute("ojb", data);
			response.getWriter().write(data.toString());

			
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
