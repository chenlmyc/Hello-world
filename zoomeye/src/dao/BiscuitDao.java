package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import tools.DBHelper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BiscuitDao {
	private Connection con;

	public int getOsCount(String ip,String os) throws SQLException {
		int result = 0;
		con = (Connection) DBHelper.DBFactory ();
		String sql = "  (select count(distinct os) os"
				+ " from server_info where ip='" + ip+"') ";
		System.out.println(sql);
		Statement stms = (Statement) con.createStatement ();
		ResultSet rs = stms.executeQuery (sql);
		while (rs.next ()) {
			result = Integer.parseInt(rs.getString ("os"));
		}
		con.close ();
		return result;
	}
}
