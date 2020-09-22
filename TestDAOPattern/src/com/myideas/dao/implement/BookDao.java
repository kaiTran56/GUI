package com.myideas.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myideas.dao.Dao;
import com.myideas.jdbc.JDBCConnection;
import com.myideas.model.Book;

public class BookDao extends JDBCConnection implements Dao<Book> {
	private Connection connect;

	@Override
	public void insert(Book t) {

	}

	@Override
	public void edit(Book t) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public Optional<Book> get(int id) {
		return getAll().parallelStream().filter(p -> p.getId() == id).findFirst();
	}

	@Override
	public List<Book> getAll() {
		this.connect = super.getConnectionJDBC();
		String sql = "select b.id, b.name, b.author, c.content from book as b inner join contentbook c on b.id = c.id_book";
		List<Book> listBook = new ArrayList<Book>();
		try {
			Statement statement = this.connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String author = result.getString("author");
				String content = result.getString("content");
				Book book = new Book(id, name, author, content);
				listBook.add(book);
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBook;
	}

	@Override
	public List<Book> searchByName(String name) {
		List<Book> listBook = new ArrayList<Book>();
		connect = super.getConnectionJDBC();
		String sql = "select b.id, b.name, b.author, c.content from book b inner join contentbook c on b.id = c.id_book where b.name like ?";
		try {
			PreparedStatement statement = this.connect.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String nameBook = result.getString("name");
				String author = result.getString("author");
				String content = result.getString("content");
				listBook.add(new Book(id, nameBook, author, content));
			}
			statement.close();
			result.close();
			connect.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBook;
	}

	@Override
	public List<Book> searchByAuhtor(String author) {
		List<Book> listBook = new ArrayList<Book>();
		connect = super.getConnectionJDBC();
		String sql = "select b.id, b.name, b.author, c.content from book b inner join contentbook c on b.id = c.id_book where b.author like ?";
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, author);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				listBook.add(new Book(result.getInt("id"), result.getString("name"), result.getString("author"),
						result.getString("content")));
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBook;
	}

}
