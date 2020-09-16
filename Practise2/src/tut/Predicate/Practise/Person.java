package tut.Predicate.Practise;

public class Person implements Comparable<Person> {
	private String name;
	private String id;
	private int age;

	public Person(String name, String id, int age) {
		this.age = age;
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "\nName: " + this.name + "\nID: " + this.id + "\nAge: " + this.age + "\n-------------------- ";
	}

	@Override
	public int compareTo(Person o) {

		return this.getId().compareTo(o.getId());
	}
}
