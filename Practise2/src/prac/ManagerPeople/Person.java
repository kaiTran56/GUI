package prac.ManagerPeople;

public class Person implements Comparable<Person> {
	public enum Gender {
		MALE, FEMALE
	};

	private String name;
	private String id;
	private int age;
	private Gender sex;

	public Person(String name, String id, int age, Gender sex) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return this.name;
	}

	public String getID() {
		return this.id;
	}

	public int getAge() {
		return this.age;
	}

	public Gender getGender() {
		return this.sex;
	}

	public boolean setName(String name) {
		return name.equals(null) || name.length() == 30 ? false : true;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	@Override
	public int compareTo(Person o) {

		return this.getName().compareTo(o.getName());
	}

}
