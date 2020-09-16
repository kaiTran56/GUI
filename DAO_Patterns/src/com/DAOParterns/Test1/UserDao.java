package com.DAOParterns.Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.DAOParterns.User;

public class UserDao implements Dao<User> {

	public List<User> users = new ArrayList<User>();

	public UserDao() {
		users.add(new User(1, "GP Coder", "contact@gpcoder.com"));
		users.add(new User(2, "Giang Phan", "gpcodervn@gmail.com"));
	}

	@Override
	public List<User> getAll() {

		return users;
	}

	@Override
	public Optional<User> get(int id) {

		return users.stream().filter(p -> p.getId() == id).findFirst();
	}

	@Override
	public void save(User user) {
		users.add(user);

	}

	@Override
	public void update(User user) {
		get(user.getId()).ifPresent(existUser -> {
			user.setName(user.getName());
			user.setEmail(user.getEmail());
		});

	}

	@Override
	public void delete(User user) {
		get(user.getId()).ifPresent(existUser -> users.remove(existUser));

	}

}
