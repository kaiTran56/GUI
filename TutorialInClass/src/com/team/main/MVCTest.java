package com.team.main;

import com.team.controller.EmployeeController;
import com.team.model.Employee;
import com.team.view.EmployeeView;

public class MVCTest {
	public static void main(String[] args) {
		MVCTest test = new MVCTest();
		Employee e1 = test.retrieveEmployeefo(123, "Quyet", "ten");
		new EmployeeController(e1, new EmployeeView()).updateView();
	}

	public Employee retrieveEmployeefo(int code, String name, String position) {
		return new Employee(code, name, position);
	}
}
