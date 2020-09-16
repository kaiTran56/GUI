package com.tutorial2.OOP;

public class Main {
	public static void main(String[] args) {
		Shape circle = new Circle(10, "Red", true);
		System.out.println(circle.toString());
		System.out.println("----------------------------");
		Shape square = new Square(10, "Yellow", false);
		System.out.println(square.toString());
	}
}
