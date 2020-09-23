package lambda.Intro;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test1 {
	public static void main(String[] args) {

		Person p1 = new Person("Quyet Tran", 20);
		Person p2 = new Person("HA", 20);
		Person p3 = new Person("Ngan", 20);
		Person p4 = new Person("Chau", 20);
		Person p5 = new Person("Huong", 20);
		List<Person> list = Arrays.asList(p1, p2, p3, p4, p5);
//		Collections.sort(list, (per1, per2) -> per1.getName().compareTo(per2.getName()));
//		list.forEach(p -> System.out.println(p.toString()));
		Function<Person, String> upperCase = person -> person.getName().toUpperCase();
		Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));
		Function<Person, String> chainedFunction = upperCase.andThen(firstName);
		System.out.println(chainedFunction.apply(list.get(0)));
	}
}

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
