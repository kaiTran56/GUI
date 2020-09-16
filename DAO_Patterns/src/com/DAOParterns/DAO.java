package com.DAOParterns;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	public List<T> getAll();

	public Optional<T> get(int id);

	public void save(T t);

	public void update(T t);

	public void delete(T t);
}
