package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tools.DBHelper;

public class ServiceDao {
	private static Connection con;
	/*
	 * 添加xml中数据到数据库
	 * */
	public void insertFromXML(String ip,Integer port,String s, String os ,String city) throws NumberFormatException, SQLException{
		con = (Connection) DBHelper.DBFactory ();
		String sql = "insert into server_info(ip,city,country,app,device,os,port,service) value('"+ip+"','"+city+"','china','"+s+" server','host','"+os+"','"+port+"','"+s+"')";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();
		stms.executeUpdate(sql);
		con.close ();
	}
}
