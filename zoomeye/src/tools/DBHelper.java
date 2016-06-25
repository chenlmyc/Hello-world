package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBHelper {
	
	private static String url = "jdbc:mysql://localhost:3306/zoomeye";
	private static String username = "root";
	private static String password = "123456";
	
	public DBHelper(){};
	public static Connection DBFactory() {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1){
			e1.printStackTrace();
		}
		Connection con = null;
		try{
			con = DriverManager.getConnection(url,username,password);
		}catch (SQLException e){
			
			e.printStackTrace();
		}
		return con; 
	}
}
