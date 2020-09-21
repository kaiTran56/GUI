package com.myideas.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	void insert(T t);

	void edit(T t);

	void delete(int id);

	Optional<T> get(int id);

	List<T> getAll();

	List<T> searchByName(String name);

	List<T> searchByAuhtor(String author);
}
