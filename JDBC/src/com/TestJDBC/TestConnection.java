package com.TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	public static Connection connect;
	public static PreparedStatement statement;
	public static ResultSet result;
	public static final String user = "root";
	public static final String password = "54935620tQ.";
	public static final String address = "jdbc:mysql://localhost:3306/password_website";

	public static void main(String[] args) {
		checkAccount();
	}

	public static void getAccess() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(address, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void checkAccount() {
		String person = "quyet";
		String pass = "danhbomlieuchet";
		getAccess();
		String sql = "select * from admin where user like ? And password like ?";

		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, person);
			statement.setNString(2, pass);
			result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("user") + ":::::" + result.getString("password"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
