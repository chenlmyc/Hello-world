package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import model.Table;
import service.Parse;
import dao.TableDao;

@WebServlet(urlPatterns = { "/TableServlet" }, initParams = { @WebInitParam(name = "TableServlet", value = "servlet.TableServlet") })
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Parse parse = new Parse ();
	private TableDao tableDao = new TableDao ();
	private static String searchText;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TableServlet() {
		super ();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println ("search: " + searchText);
		HashMap<String, String> tokens = parse.getToken (searchText);
		System.out.println ("tokens: " + tokens);
		
		if (tokens.get("ip")!=null && tokens.get("os")!=null ) {
			if (tokens.get ("ip").endsWith ("0")) {
				String ips = tokens.get ("ip");
				String os = tokens.get ("os");
				ArrayList<Table> list = new ArrayList<Table> ();
				try {
					list = tableDao.findHostFromIPsOs (ips, os);
				} catch (SQLException e) {
					e.printStackTrace ();
				}
				JSONArray data = new JSONArray ();
				JSONObject jsonobj = new JSONObject ();
				Table host = null;
				Iterator<Table> iterator = list.iterator ();
				while (iterator.hasNext ()) {
					host = iterator.next ();
					jsonobj.put ("ip", host.getIp ());
					jsonobj.put ("city", host.getCity ());
					jsonobj.put ("os", host.getOs ());
					jsonobj.put ("port", host.getPort ());
					jsonobj.put ("service", host.getService ());
					data.add (host);
				}
				System.out.println ("data" + data.get (0));
				response.getWriter ().write (data.toString ());
			} else {
				ArrayList<Table> list = new ArrayList<Table> ();
				try {
					list = tableDao.findHostFromIPOs (tokens.get ("ip"), tokens.get ("os"));
				} catch (SQLException e) {
					e.printStackTrace ();
				}
				JSONArray data = new JSONArray ();
				JSONObject jsonobj = new JSONObject ();
				Table host = null;
				Iterator<Table> iterator = list.iterator ();
				while (iterator.hasNext ()) {
					host = iterator.next ();
					jsonobj.put ("ip", host.getIp ());
					jsonobj.put ("city", host.getCity ());
					jsonobj.put ("os", host.getOs ());
					jsonobj.put ("port", host.getPort ());
					jsonobj.put ("service", host.getService ());
					data.add (host);
				}
				System.out.println ("data" + data.get (0));
				response.getWriter ().write (data.toString ());
			}
		}
		else if (tokens.get("ip")!=null && tokens.get("os")==null) {
			if (tokens.get ("ip").endsWith ("0")) {
				String ips = tokens.get ("ip");
				ArrayList<Table> list = new ArrayList<Table> ();
				try {
					list = tableDao.findHostFromIPsOs (ips, "windows' or os = 'linux");
				} catch (SQLException e) {
					e.printStackTrace ();
				}
				JSONArray data = new JSONArray ();
				JSONObject jsonobj = new JSONObject ();
				Table host = null;
				Iterator<Table> iterator = list.iterator ();
				while (iterator.hasNext ()) {
					host = iterator.next ();
					jsonobj.put ("ip", host.getIp ());
					jsonobj.put ("city", host.getCity ());
					jsonobj.put ("os", host.getOs ());
					jsonobj.put ("port", host.getPort ());
					jsonobj.put ("service", host.getService ());
					data.add (host);
				}
				System.out.println ("data" + data.get (0));
				response.getWriter ().write (data.toString ());
			} else {
				ArrayList<Table> list = new ArrayList<Table> ();
				try {
					list = tableDao.findHostFromIPOs (tokens.get ("ip"), "windows' or os = 'linux");
				} catch (SQLException e) {
					e.printStackTrace ();
				}
				JSONArray data = new JSONArray ();
				JSONObject jsonobj = new JSONObject ();
				Table host = null;
				Iterator<Table> iterator = list.iterator ();
				while (iterator.hasNext ()) {
					host = iterator.next ();
					jsonobj.put ("ip", host.getIp ());
					jsonobj.put ("city", host.getCity ());
					jsonobj.put ("os", host.getOs ());
					jsonobj.put ("port", host.getPort ());
					jsonobj.put ("service", host.getService ());
					data.add (host);
				}
				System.out.println ("data" + data.get (0));
				response.getWriter ().write (data.toString ());
			}
		}
		else if(tokens.get("ip")==null && tokens.get("os")==null) {
			response.sendRedirect ("500.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		searchText = request.getParameter ("searchString");
		System.out.println ("查询字符串：" + searchText);
		HashMap<String, String> tokens = parse.getToken (searchText);
		if(tokens.size ()>0){
			response.sendRedirect ("result.jsp?search=" + searchText);
		}else{
			response.sendRedirect ("500.jsp");
		}
		
	}

}
