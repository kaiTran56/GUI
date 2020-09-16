package tut.Predicate.Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	public Scanner scanner;

	public Main() {
		this.scanner = new Scanner(System.in);
	}

	public void PassWord() {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("Property.properties"));
			String user = pro.getProperty("User");
			String pass = pro.getProperty("PassWord");
			System.out.println("Enter the USER: ");
			String name = scanner.nextLine();
			System.out.println("Enter the PassWord: ");
			String enterPass = scanner.nextLine();
			if (!(name.equalsIgnoreCase(user) || enterPass.equals(pass))) {
				System.out.println("Wrong PassWord!");
				System.exit(0);
			} else
				System.out.print("Wellcome!");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.PassWord();
		Function function = new Function();
		Person p1 = new Person("Quyet", "111", 20);
		Person p2 = new Person("Thao", "333", 22);
		Person p3 = new Person("Chau", "222", 20);
		Person p4 = new Person("Ha", "444", 21);
		Person p5 = new Baby("Minh Anh", "1122", 2, "Quyet-Ngan");
		Person p6 = new Baby("Minh ", "1124", 1, "Quyet-Thao");
		Person p7 = new Baby("Chi", "1123", 3, "Quyet-Chau");
		Person p8 = new Baby("Anh", "1125", 5, "Quyet-Ha");
		function.addPerson(p1);
		function.addPerson(p2);
		function.addPerson(p3);
		function.addPerson(p4);
		function.addPerson(p5);
		function.addPerson(p6);
		function.addPerson(p7);
		function.addPerson(p8);
		function.show();
		System.out.println("__________Next Function______");
		function.search("111");
		System.out.println("__________Next Function______");
		function.showBaby();
		System.out.println("__________Next Function______");
		System.out.println(function.filterPredicatePerson(function.predicateIsAdult(), function.getListPerson()));
		System.out.println("-----------------SORT By ID------------------");
		function.sortById();
		System.out.println("-----------------SORT By Name------------------");
		function.sortByName();
		System.out.println("New Function printt the BABY:");
		function.printf(function.filterPredicatePerson(function.predicateIsBaby(), function.getListPerson()));
	}
}
