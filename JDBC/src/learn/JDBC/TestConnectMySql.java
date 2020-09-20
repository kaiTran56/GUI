package learn.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestConnectMySql {
	public static Connection connect;

	
	public static ResultSet result;
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
	public static void initialize(String user, String password,String url) {
		try {
			System.out.println("Connecting...");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, password);
			connect.setAutoCommit(false);
			Statement statement = connect.createStatement();
			
			statement.executeUpdate("Insert into student value(14,'Ngoc Anh',7,'End game');");
			//statement.executeUpdate("Delete from student where name like 'Ngoc Anh';");
			result = statement.executeQuery("select * from student ;");
			boolean ok = true;
			if(ok) {
				connect.commit();
				System.out.println("Make commit!");
			}else {
				connect.rollback();
				System.out.println("Make rollback!");
			}
			System.out.println("Access granted !");
			while(result.next()) {
				System.out.println(result.getInt(1)+" - "+result.getString(2)+" - "+result.getInt(3)+" - "+ result.getString(4));    
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
