package com.myideas.dao.implement;

public class MainTest {
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		System.out.println(dao.searchByAuhtor("Tran Kai"));
	}
}
