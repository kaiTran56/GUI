package learn.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PreparerStatement {
	public static Connection connect;
	
	public static ResultSet result;
	public static PreparedStatement myStmt;
	public static String user;
	public static String password;
	public static String url;
	public static void main(String[] args) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("mysql.properties"));
			String user = pro.getProperty("user");
			String password = pro.getProperty("password");
			String url = pro.getProperty("url");
			initialize(user,password,url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialize(String user, String password, String url) {
		try {
			System.out.println("Connecting...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url,user,password);
			System.out.println("Access granted !");
			connect.setAutoCommit(false);
			myStmt = connect.prepareStatement("Select name from student where point= ?;");
			
			myStmt.setInt(1,10);
			result = myStmt.executeQuery();
			boolean ok = true;
			if(ok) {
				connect.commit();
			}
			else {
				connect.rollback();
			}
			while(result.next()) {
				System.out.println(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
