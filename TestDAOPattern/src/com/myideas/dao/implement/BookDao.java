package com.myideas.dao.implement;

import java.util.List;
import java.util.Optional;

import com.myideas.dao.Dao;
import com.myideas.jdbc.JDBCConnection;
import com.myideas.model.Book;

public class BookDao extends JDBCConnection implements Dao<Book> {

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
		
		return null;
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByAuhtor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
