package com.tutorial2_2.OOP;

public class Employee implements Measurable {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Name: " + this.getName() + "\nSalary: " + this.getSalary();
	}

	@Override
	public double getMeasurable() {
		return salary;
	}
}
