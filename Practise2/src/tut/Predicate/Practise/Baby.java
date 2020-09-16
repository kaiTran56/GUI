package tut.Predicate.Practise;

public class Baby extends Person {
	private String family;

	public Baby(String name, String id, int age, String family) {
		super(name, id, age);
		this.family = family;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}
	public String toString() {
		return "\nName: "+this.getName()
				+"\nID: "+this.getId()
				+"\nAge: "+this.getAge()
				+"\n Family of Baby: "+this.getFamily()
				+"\n-------------------- ";
	}
}
