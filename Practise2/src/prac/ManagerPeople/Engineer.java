package prac.ManagerPeople;

public class Engineer extends Person {
	private double salary;

	public Engineer(String name, String id, int age, Gender sex, double salary) {
		super(name, id, age, sex);
		this.salary = salary;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int compareTo(Engineer o1) {
		if (this.getSalary() > o1.getSalary())
			return 1;
		else
			return -1;
	}

	public String toString() {
		return "\nJob: Engineer " + "\nName: " + this.getName() + "\nID:  " + this.getID() + "\nAge: " + this.getAge()
				+ "\nSex: " + this.getAge() + "\nSalary: " + this.getSalary();
	}

}
