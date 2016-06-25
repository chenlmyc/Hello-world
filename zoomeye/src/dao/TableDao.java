package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Table;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tools.DBHelper;

public class TableDao {
	private Connection con;

	public ArrayList<Table> findHostFromIP(String ip) throws SQLException {

		con = (Connection) DBHelper.DBFactory ();
		ArrayList<Table> tables = new ArrayList<Table> ();
		String sql = "select ip,os,port,service,city from server_info where ip='" + ip +"'";
		Statement stms = (Statement) con.createStatement ();
		System.out.println(sql);
		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			Table table = new Table (rs.getString ("ip"), rs.getString ("city"), rs.getString ("os"), rs.getString ("port"), rs.getString ("service"));
			tables.add (table);
		}
		con.close ();
		return tables;
	}

	public String ip2ips(String ip) {
		String result = "";
		if (ip.endsWith ("0")) {
			ArrayList<String> list = new ArrayList<String> ();
			String[] ips = ip.split ("\\.");
			String ipsuff = "";
			for (int i = 0; i < ips.length - 1; i++) {
				ipsuff = ipsuff + ips[i] + ".";
			}
			int ip1 = Integer.parseInt (ips[3]);
			for (int i = ip1 + 1; i <= Integer.parseInt (ips[3]) + 253; i++) {
				list.add (ipsuff + String.valueOf (i));
			}
			Iterator<String> it = list.iterator ();
			while (it.hasNext ()) {
				result += "'" + it.next () + "',";
			}
		}
		System.out.println ("result:"+result);
		return result.substring (0, result.length () - 1);
	}

	public ArrayList<Table> findHostFromIPs(String ip) throws SQLException {
		con = (Connection) DBHelper.DBFactory ();
		String ips = ip2ips (ip);
		System.out.println ("conver: " + ips);
		String sql = "select ip,os,port,service,city from server_info where ip in" + "(" + ips + ")";

		System.out.println ("sql: " + sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		ArrayList<Table> tables = new ArrayList<Table> ();
		while (rs.next ()) {
			Table table = new Table (rs.getString ("ip"), rs.getString ("city"), rs.getString ("os"), rs.getString ("port"), rs.getString ("service"));
			tables.add (table);
		}
		con.close ();
		return tables;
	}

	public ArrayList<Table> findHostFromOs(String os) throws SQLException {
		con = (Connection) DBHelper.DBFactory ();

		String sql = "select ip,os,port,service,city from server_info where os  ='" + os + "'";
		System.out.println ("sql: " + sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		ArrayList<Table> tables = new ArrayList<Table> ();
		while (rs.next ()) {
			Table table = new Table (rs.getString ("ip"), rs.getString ("city"), rs.getString ("os"), rs.getString ("port"), rs.getString ("service"));
			tables.add (table);
		}
		con.close ();
		return tables;
	}

	public ArrayList<Table> findHostFromIPsOs(String ip, String os) throws SQLException {
		con = (Connection) DBHelper.DBFactory ();
		String ips = ip2ips (ip);
		System.out.println ("conver: " + ips);
		String sql = "select ip,os,port,service,city from server_info where ip in" + "(" + ips + ") and os='"+os+"'";

		System.out.println ("sql: " + sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		ArrayList<Table> tables = new ArrayList<Table> ();
		while (rs.next ()) {
			Table table = new Table (rs.getString ("ip"), rs.getString ("city"), rs.getString ("os"), rs.getString ("port"), rs.getString ("service"));
			tables.add (table);
		}
		con.close ();
		return tables;
	}

	public ArrayList<Table> findHostFromIPOs(String ip, String os) throws SQLException {
		con = (Connection) DBHelper.DBFactory ();
		ArrayList<Table> tables = new ArrayList<Table> ();
		String sql = "select ip,os,port,service,city from server_info where ip='" + ip +"'and (os='"+os+"')";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();

		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			Table table = new Table (rs.getString ("ip"), rs.getString ("city"), rs.getString ("os"), rs.getString ("port"), rs.getString ("service"));
			tables.add (table);
		}
		con.close ();
		return tables;
	}

}
