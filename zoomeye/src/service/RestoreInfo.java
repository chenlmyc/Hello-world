package service;

import java.sql.SQLException;
import java.util.Map;

import org.dom4j.DocumentException;

import dao.ServiceDao;
import tools.ParseXMLFile;
public class RestoreInfo {
	private ParseXMLFile pxf = new ParseXMLFile();
	private ServiceDao serviceDao = new ServiceDao();
	/*
	 * 把存入数据库
	 * */
	public void restore(String url) throws DocumentException, NumberFormatException, SQLException{
		Map map = pxf.xml2Host(url);
		String ip = (String) map.get("address");
		Integer port = Integer.parseInt((String) map.get("port"));
		String s = (String) map.get("service");
		String os = (String) map.get("os");
		String city = (String) map.get("city");
		serviceDao.insertFromXML(ip, port, s, os, city);
	}
}
