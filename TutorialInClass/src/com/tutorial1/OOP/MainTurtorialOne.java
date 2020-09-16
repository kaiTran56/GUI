package com.tutorial1.OOP;

public class MainTurtorialOne {
	public static void main(String[] args) {
		Student student = new Student("1801040175", "TranQuyet");
		Course course = new Course("SAD", "System analysis and Design");
		Enrolment enrol = new Enrolment(student, course, 10, 9, 10);
		System.out.println(enrol.toString());
	}
}
