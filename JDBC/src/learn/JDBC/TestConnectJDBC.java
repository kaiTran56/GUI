package learn.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnectJDBC {
	public static Connection connect;

	public static void main(String[] args) {
		TestConnectJDBC test = new TestConnectJDBC();
		test.initialize();

	}

	public Connection initialize() {
		Properties pro = new Properties();
		String user, password, url;
		System.out.println("Connection ...");
		try {
			pro.load(new FileInputStream("mysql.properties"));
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			url = pro.getProperty("url");

			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, password);
			System.out.println("Access Granted....!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}
}
