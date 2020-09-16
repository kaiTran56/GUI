package com.DAOParterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements DAO<User> {
	private List<User> users = new ArrayList<User>();

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
			existUser.setName(user.getName());
			existUser.setEmail(user.getEmail());
		});

	}

	@Override
	public void delete(User user) {
		get(user.getId()).ifPresent(existUser -> users.remove(existUser));

	}

}
