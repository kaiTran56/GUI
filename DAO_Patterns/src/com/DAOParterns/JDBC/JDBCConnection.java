package com.DAOParterns.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	@SuppressWarnings("null")
	public static Connection getConnection() {
		Properties pro = new Properties();
		String user = null;
		String password = null;
		String url = null;
		Connection connect = null;
		try {
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			if (connect.isClosed() || connect == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Successful!");
				return DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
