package tut.Predicate.Practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Function {

	private List<Person> listPerson;

	public Function() {
		this.listPerson = new ArrayList<Person>();
	}

	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
	}

	public List<Person> getListPerson() {
		return this.listPerson;
	}

	public void addPerson(Person person) {
		this.listPerson.add(person);
	}

	public void show() {
		this.listPerson.stream().forEach(p -> System.out.println(p.toString()));
	}

	public void search(String id) {
		Person person = this.listPerson.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
		if (!person.equals(null))
			printf(person);
		else
			printf("Nothing");
	}

	public Predicate<Person> predicateIsAdult() {
		return p -> p.getAge() > 18;
	}

	public void showBaby() {
		listPerson.stream().filter(p -> p instanceof Baby).forEach(p -> {
			if (!p.equals(null))
				System.out.println(p.toString());
		});

	}

	public Predicate<Person> predicateIsBaby() {
		return p -> p.getAge() < 18 && p instanceof Baby;
	}

	public List<Person> filterPredicatePerson(Predicate<Person> predicatePerson, List<Person> listPerson) {
		return listPerson.stream().filter(predicatePerson).collect(Collectors.<Person>toList());
	}

	public void sortByName() {
		Collections.sort(listPerson, new SortByNameComparator());
		show();
	}

	public void sortById() {
		Collections.sort(listPerson);
		show();
	}

	public <T> void printf(T t) {
		System.out.println(t.toString());
	}
}
