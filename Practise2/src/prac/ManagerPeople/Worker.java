package prac.ManagerPeople;

public class Worker extends Person {
	private double salary;

	public Worker(String name, String id, int age, Gender sex, double salary) {
		super(name, id, age, sex);
		this.salary = salary;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int compareTo(Worker o1) {
		if (this.getSalary() > o1.getSalary())
			return 1;
		else
			return -1;
	}

	public String toString() {
		return "\nJob: Worker" + "\nName: " + this.getName() + "\nID: " + this.getID() + "\nAge: " + this.getAge()
				+ "\nSex: " + this.getGender() + "\nSalary: " + this.getSalary();
	}

}
