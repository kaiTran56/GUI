package com.tutorial2_2.OOP;

import java.util.Arrays;

public class MeasureCalculation {
	public double average(Measurable[] obj) {
		int n = obj.length;
		if (!(n > 0)) {
			System.out.println("!Empty");
		}
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += obj[i].getMeasurable();
		}
		return sum / n;
	}

	public Employee findHighestEmpoloyee(Measurable[] obj) {
		int n = obj.length;
		if (!(n < 0)) {
			System.out.println("Empty!");
		}
		double tempMax = obj[0].getMeasurable();
		for (int i = 0; i < n; i++) {
			if (tempMax < obj[i].getMeasurable()) {
				tempMax = obj[i].getMeasurable();
			}
		}
		double number = tempMax;
		Employee highistPerson = (Employee) Arrays.stream(obj).filter(p -> ((Employee) p).getSalary() == number)
				.findFirst().orElse(null);
		return highistPerson;
	}
}
