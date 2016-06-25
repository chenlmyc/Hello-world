package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import tools.DBHelper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PillarDao {
	private Connection con;

	public int getOsCount(String ip,String os) throws SQLException {
		int result = 0;
		con = (Connection) DBHelper.DBFactory ();
		String sql = "  (select count(distinct os) os"
				+ " from server_info where ip='" + ip+"' and (os='"+os+"')) ";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			result = Integer.parseInt(rs.getString ("os"));
		}
		con.close ();
		return result;
	}
	
	public int getCityCount(String ip,String os) throws SQLException {
		int result = 0;
		con = (Connection) DBHelper.DBFactory ();
		String sql = "(select count(distinct city) city"
				+ " from server_info where ip='" + ip+"' and (os='"+os+"')) ";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			result = Integer.parseInt(rs.getString ("city"));
		}
		con.close ();
		return result;
	}
	
	public int getPortCount(String ip,String os) throws SQLException {
		int result = 0;
		con = (Connection) DBHelper.DBFactory ();
		String sql = "(select count(distinct port) port"
				+ " from server_info where ip='" + ip+"' and (os='"+os+"')) ";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			result = Integer.parseInt(rs.getString ("port"));
		}
		con.close ();
		return result;
	}
	
	public int getServiceCount(String ip,String os) throws SQLException {
		int result = 0;
		con = (Connection) DBHelper.DBFactory ();
		String sql = " (select count(distinct service) service"
				+ " from server_info where ip='" + ip+"' and (os='"+os+"')) ";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			result = Integer.parseInt(rs.getString ("service"));
		}
		con.close ();
		return result;
	}
	
	public int getIpCount(String ip,String os) throws SQLException {
		int result = 0;
		con = (Connection) DBHelper.DBFactory ();
		String sql = "(select count(distinct ip) ip"
				+ " from server_info where ip='" + ip+"' and (os='"+os+"')) ";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			result = Integer.parseInt(rs.getString ("ip"));
		}
		con.close ();
		return result;
	}
	
	public int[] getCount(String ip, String os) throws SQLException{
		int result[] = new int[5];
		result[0] = getIpCount(ip, os);
		result[1] = getCityCount(ip, os);
		result[2] = getPortCount(ip, os);
		result[3] = getOsCount(ip, os);
		result[4] = getServiceCount(ip, os);
		return result;
	}
}
