package com.tutorial2_2.OOP;

public class Main {
	public static void main(String[] args) {
		Measurable[] m = new Measurable[3];
		m[0] = new Employee("Quyet", 9000);
		m[1] = new Employee("Kai", 10000);
		m[2] = new Employee("Tran", 9000);
		double numberAverage = new MeasureCalculation().average(m);
		System.out.println("Average: " + numberAverage);
		System.out.println("Find the highist Person: \n" + new MeasureCalculation().findHighestEmpoloyee(m).toString());
	}
}
