package com.DAOParterns.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoImpl extends JDBCConnection implements BookDao {

	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<Book>();
		String sql = "select * from libary;";
		Connection connect = super.getConnection();
		try {
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				Book book = new Book(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4));
				books.add(book);
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Optional<Book> search(int id) {

		return this.getAll().stream().filter(p -> p.getId() == id).findFirst();
	}

	@Override
	public void insert(Book book) {
		String sql = "INSERT INTO libary (id, name, author, prive) value(?,?,?,?)";
		Connection connect = super.getConnection();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, book.getId());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthor());
			statement.setDouble(4, book.getPrice());
			statement.executeUpdate();
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void edit(Book book) {
		String sql = "UPDATE libary SET name = ?, author = ?, price =? WHERE id = ?";
		Connection connect = super.getConnection();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setDouble(3, book.getPrice());
			statement.setInt(4, book.getId());
			statement.executeUpdate();
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Book book) {
		String sql = "DELETE FROM libary WHERE id = ?";
		Connection connect = super.getConnection();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, book.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Book get(int id) {
		String sql = "SELECT * FROM libary WHERE id = ?;";
		Connection connect = super.getConnection();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Book book = new Book(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
