package learn.JDBC;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadFileJDBC {
	public static void main(String[] args) {
		TestConnectJDBC test = new TestConnectJDBC();
		Connection connect = test.initialize();
		String sql = "Select*from save_file;";
		try {
			PreparedStatement preStmt = connect.prepareStatement(sql);
			ResultSet result = preStmt.executeQuery();
			while(result.next()) {
				String name = result.getString(1);
				Blob file = result.getBlob(2);
				byte[] word = file.getBytes(1,(int) file.length());
				FileOutputStream fileOut = new FileOutputStream(name);
				fileOut.write(word);
				fileOut.close();
				System.out.println("Success!");
				
			}
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
		
	}
}
