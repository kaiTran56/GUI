package prac.ManagerPeople;

public class Student extends Person {
	private String room;

	public Student(String name, String id, int age, Gender sex, String room) {
		super(name, id, age, sex);
		this.room = room;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String toString() {
		return "\nJob: Student" + "\nName: " + this.getName() + "\nID: " + this.getID() + "\nAge: " + this.getAge()
				+ "\nGender: " + this.getGender() + "\nRoom: " + this.getRoom();
	}
}
