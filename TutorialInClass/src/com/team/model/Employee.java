package com.team.model;

public class Employee {
	private int code;
	private String name;
	private String position;

	public Employee(int code, String name, String position) {
		super();
		this.code = code;
		this.name = name;
		this.position = position;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String toString() {
		return "code: " + code + " ,name: " + name + " ,position: " + position;
	}
}
