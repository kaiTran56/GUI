package prac.ManagerPeople;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionPredicate {
	private List<Person> listPerson;

	public FunctionPredicate() {
		this.listPerson = new ArrayList<Person>();
	}

	public List<Person> getListPerson() {
		return this.listPerson;
	}

	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
	}

	public void addPerson(List<Person> list) {
		this.listPerson = list;
	}

	public Predicate<Person> predicateIsAdult() {
		return p -> p.getAge() > 18 && !p.equals(null);
	}

	public Predicate<Person> searchByName(String name) {
		return p -> p.getName().equals(name);
	}

	public Predicate<Person> showStudent() {
		return p -> p instanceof Student;
	}

	public Predicate<Person> showEngineer() {
		return p -> p instanceof Engineer;
	}

	public Predicate<Person> showWorker() {
		return p -> p instanceof Worker;
	}

	public List<Person> filterPredicate(List<Person> listPerson, Predicate<Person> predicatePerson) {
		return listPerson.stream().filter(predicatePerson).collect(Collectors.<Person>toList());
	}

	public void show() {
		this.listPerson.stream().forEach(p -> System.out.println(p.toString()));
	}

	public <T> void printf(T t) {
		System.out.println(t.toString());
	}

	public void sortByName() {
		Collections.sort(this.listPerson);
		show();
	}

	public Predicate<Person> predicateSalary() {
		return p -> p instanceof Engineer || p instanceof Worker;
	}

	public void showSalary() {
		List<Engineer> list1 = new ArrayList<Engineer>();
		this.listPerson.stream().filter(p -> p instanceof Engineer).forEach(p -> {
			if (((Engineer) p).getSalary() > 0) {
				list1.add((Engineer) p);
			}

		});
		List<Worker> list2 = new ArrayList<Worker>();
		this.listPerson.stream().filter(p -> p instanceof Worker).forEach(p -> {
			if (((Worker) p).getSalary() > 0) {
				list2.add((Worker) p);
			}

		});
		prinf(list1, list2);
	}

	public <T> void prinf(T t1, T t2) {
		System.out.println(t1.toString());
		System.out.println(t2.toString());
	}

	public void sortBySalary() {
		List<Engineer> list = new ArrayList<Engineer>();
		this.listPerson.stream().filter(p -> p instanceof Engineer).forEach(p -> {
			list.add((Engineer) p);
		});
		Collections.sort(list, new SortBySalary());
		printf(list);
	}

	public void convertSaveIO(String data) {
		String address = "C:\\Users\\Admin\\Downloads\\Final\\Text.text";
		FileWriter writer;
		try {
			writer = new FileWriter(address, false);
			PrintWriter pw = new PrintWriter(writer);
			pw.write(data);
			pw.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
