package com.tutorial1.OOP;

public class Enrolment {
	private Student student;
	private Course course;
	private int attendanceMark;
	private float midtermMark;
	private float finalMark;

	public Enrolment(Student student, Course course, int attendanceMark, float midtermMark, float finalMark) {
		super();
		this.student = student;
		this.course = course;
		this.attendanceMark = attendanceMark;
		this.midtermMark = midtermMark;
		this.finalMark = finalMark;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getAttendanceMark() {
		return attendanceMark;
	}

	public void setAttendanceMark(int attendanceMark) {
		this.attendanceMark = attendanceMark;
	}

	public float getMidtermMark() {
		return midtermMark;
	}

	public void setMidtermMark(float midtermMark) {
		this.midtermMark = midtermMark;
	}

	public float getFinalMark() {
		return finalMark;
	}

	public void setFinalMark(float finalMark) {
		this.finalMark = finalMark;
	}

	public double getOverall() {
		return (attendanceMark * 1 + midtermMark * 3 + finalMark * 6) / 10;
	}

	@Override
	public String toString() {
		return "Student: " + student.getStudentName() + " ,Whose id is " + this.student.getStudentId()
				+ " got attdance mark = " + this.getAttendanceMark() + " ,midterm = " + this.getMidtermMark()
				+ " and final = " + this.getFinalMark() + " .Overall is " + this.getOverall();
	}
}
