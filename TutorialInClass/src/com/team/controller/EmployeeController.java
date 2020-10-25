package com.team.controller;

import com.team.model.Employee;
import com.team.view.EmployeeView;

public class EmployeeController {
	private Employee model;
	private EmployeeView view;

	public EmployeeController(Employee model, EmployeeView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void setEmployeeName(String name) {
		model.setName(name);
	}

	public String getEmployeeName() {
		return model.getName();
	}

	public void setEmployeeCode(int code) {
		model.setCode(code);
	}

	public int getEmployeeCode() {
		return model.getCode();
	}

	public void setEmployeePosition(String position) {
		model.setPosition(position);
	}

	public String getEmployeePosition() {
		return model.getPosition();
	}

	public void updateView() {
		view.printEmployeeDetails(model);
	}
}
