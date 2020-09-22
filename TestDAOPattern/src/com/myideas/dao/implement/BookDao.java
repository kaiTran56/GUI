package com.myideas.dao.implement;

import java.sql.Connection;
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
			super.getDisconnectionJDBC(this.connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBook;
	}

	@Override
	public List<Book> searchByName(String name) {
		
		return null;
	}

	@Override
	public List<Book> searchByAuhtor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
