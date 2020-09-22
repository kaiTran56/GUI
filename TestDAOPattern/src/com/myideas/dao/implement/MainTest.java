package com.myideas.dao.implement;

public class MainTest {
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		System.out.println(dao.searchByAuhtor("Tran Kai"));
		System.out.println(dao.searchByName("Tran Quyet"));
		System.out.println(dao.get(1).toString());
	}
}
