package com.tutorial2.OOP;

public class Rectangle extends Shape {
	private double width;
	private double length;

	public Rectangle() {
		super();
	}

	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}

	public Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	double getArea() {

		return this.width * this.length;
	}

	@Override
	double getPerimeter() {

		return 2 * (width + length);
	}

	@Override
	public String toString() {

		return "Area of Rectangle: " + this.getArea() + "\nPerimeter of Rectangle: " + this.getPerimeter();
	}

}
