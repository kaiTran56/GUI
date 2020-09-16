package prac.Learn_Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		EmployeePredicate employeePredicate = new EmployeePredicate();
		Employee e1 = new Employee(1, "Quyet1", 20, "Male");
		Employee e2 = new Employee(2, "Quyet2", 28, "Male");
		Employee e3 = new Employee(3, "Quyet3", 27, "FeMale");
		Employee e4 = new Employee(4, "Quyet4", 29, "Male");
		Employee e5 = new Employee(5, "Quyet5", 25, "FeMale");
		Employee e6 = new Employee(6, "Quyet6", 23, "Male");
		Employee e7 = new Employee(7, "Quyet7", 22, "Male");
		Employee e8 = new Employee(8, "Quyet8", 15, "FeMale");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8 }));
		System.out.println(employeePredicate.filterEmployees(employeeList, employeePredicate.isAdultMale()));
		System.out.println("________________________________________________________");
		System.out.println(employeePredicate.filterEmployees(employeeList, employeePredicate.isAdultFemale()));
		System.out.println("________________________________________________________");
		System.out.println(employeePredicate.filterEmployees(employeeList, employeePredicate.isAdultFemale().negate()));
			}
}
