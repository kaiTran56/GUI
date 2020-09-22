package com.myideas.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	private Connection connection;

	public Connection getConnectionJDBC() {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("mysql.properties"));
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String url = properties.getProperty("url");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection successd!");
			return DriverManager.getConnection(url, user, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void getDisconnectionJDBC(Connection connection) {
		try {
			if (this.connection != null || connection.isClosed()) {
				System.out.println("Disconnect ...!");
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { JDBCConnection jdbc = new
	 * JDBCConnection(); System.out.println("Checking connection....");
	 * jdbc.getConnectionJDBC(); }
	 */
}
