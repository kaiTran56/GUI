package learn.JDBC;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SaveFileJDBC {

	public static Connection connect;
	
	public static ResultSet result;
	public static PreparedStatement myStmt;
	public static String user;
	public static String password;
	public static String url;
	public static void main(String[] args) {
		Properties pro = new Properties();
		try {
			System.out.println("Connecting...");
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
			File file = new File("text1.txt");
			file.createNewFile();
			FileInputStream fileInputStream = new FileInputStream(file);
			BufferedInputStream bufferInputStream = new BufferedInputStream(fileInputStream);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url,user,password);
			System.out.println("Access granted !");
			connect.setAutoCommit(false);
			myStmt = connect.prepareStatement("insert into save_file (name, file) value (?,?);");
			
			myStmt.setString(1,"text1.txt");
			myStmt.setBinaryStream(2, bufferInputStream);
			myStmt.executeUpdate();
			System.out.println("Save successfully");
			boolean ok = true;
			if(ok) {
				connect.commit();
			}
			else {
				connect.rollback();
			}
			
			connect.close();
			fileInputStream.close();
			bufferInputStream.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
