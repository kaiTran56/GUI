package prac.ManagerPeople;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import prac.ManagerPeople.Person.Gender;

public class Main {
	public Scanner scanner = new Scanner(System.in);

	public void passWord() {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("Property.properties"));
			String user = pro.getProperty("User");
			String pass = pro.getProperty("PassWord");
			System.out.println("Enter the User: ");
			String name = scanner.nextLine();
			System.out.println("Enter the PassWord: ");
			String passWord = scanner.nextLine();
			if (!name.equalsIgnoreCase(user) || !passWord.equals(pass)) {
				System.out.println("Bye!");
				System.exit(0);
			} else {
				System.out.println("Welcome!");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		FunctionPredicate function = new FunctionPredicate();
		Person e1 = new Engineer("Quyet", "10", 20, Gender.MALE, 6000);
		Person e2 = new Engineer("Ngan", "09", 20, Gender.FEMALE, 600);
		Person e3 = new Student("Ha", "06", 21, Gender.FEMALE, "4C18");
		Person e4 = new Worker("Tome", "11", 29, Gender.MALE, 850);
		Person e5 = new Student("Min", "12", 17, Gender.FEMALE, "12A5");
		Person e6 = new Engineer("Tome1", "15", 28, Gender.FEMALE, 0);
		Person e7 = new Worker("Tome2", "16", 27, Gender.MALE, 0);
		List<Person> list = new ArrayList<Person>();
		list.addAll(Arrays.asList(new Person[] { e1, e2, e3, e4, e5, e6, e7 }));
		function.addPerson(list);
		function.show();
		function.printf("----------predicateIsAdult----------------");
		function.printf(function.filterPredicate(function.getListPerson(), function.predicateIsAdult()));
		function.printf("-------------ShowEngineer-------------");
		function.printf(function.filterPredicate(function.getListPerson(), function.showEngineer()));
		function.printf("--------------ShowStudent------------");
		function.printf(function.filterPredicate(function.getListPerson(), function.showStudent()));
		function.printf("------------ShowWorker--------------");
		function.printf(function.filterPredicate(function.getListPerson(), function.showWorker()));
		function.printf("-------------SearchbyName-------------");
		function.printf(function.filterPredicate(function.getListPerson(), function.searchByName("Quyet")));
		function.printf("-----------SortByName---------------");
		function.sortByName();
		function.printf("-----------SortBySalary---------------");
		function.sortBySalary();
		function.printf("------------Predicate Salary--------------");
		function.printf(function.filterPredicate(function.getListPerson(), function.predicateSalary()));
		function.printf("-------------ShowSalary---------------");
		function.showSalary();
		StringBuilder str = new StringBuilder();
		function.getListPerson().stream().forEach(p->{
			str.append("\n"+p.toString());
		});
		function.convertSaveIO(str.toString());
		System.out.println("-Done-");
	}
}
