package com.tutorial2.OOP;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle() {

	}

	@Override
	double getArea() {

		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	double getPerimeter() {

		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {

		return "Area of Circle: " + this.getArea() + "\nPerimeter of Circle: " + this.getPerimeter()
				+ "\nColor of Rectangle: " + super.getColor() + "\nFilled of Rectangle: " + super.isFilled();
	}

}
