package com.myideas.model;

public class Book {
	private String name;
	private int id;
	private String author;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Book(int id, String name, String author, String content) {
		super();
		this.name = name;
		this.id = id;
		this.author = author;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {

		return "ID: " + id + "\nName: " + name + "\nAuthor: " + author + "\nContent: " + content;
	}
}
