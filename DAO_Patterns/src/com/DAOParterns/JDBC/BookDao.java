package com.DAOParterns.JDBC;

import java.util.List;
import java.util.Optional;

public interface BookDao {
	List<Book> getAll();

	Optional<Book> search(int id);

	void insert(Book book);

	void edit(Book book);

	void delete(Book book);

	Book get(int id);

	Book get(String name);
}
