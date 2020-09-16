package com.DAOParterns.Test1;

public class DaoPatternExample {
	
	/* 
	 * Successfull! 
	 * 
	 */
	
	private static Dao<com.DAOParterns.User> userDao;

	public static void main(String[] args) {
		userDao = new UserDao();
		com.DAOParterns.User user1 = userDao.get(1).get();
		System.out.println(user1.toString());
		user1.setName("updated." + user1.getName());
		userDao.update(user1);
		System.out.println("All users: ");
		userDao.getAll().forEach(user -> System.out.println(user.toString()));

	}

}
