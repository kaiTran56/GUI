package prac.Learn_Predicate;

public class Employee {
	private Integer id;
	private Integer age;
	private String gender;
	private String name;
	public Employee(Integer id, String name, Integer age, String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String toString() {
		return "\n_________Information_____________"
				+"\nName: "+ this.name 
				+"\nId Card: "+this.id
				+"\nAge: "+this.age
				+"\nGender: "+this.gender;
	}
	
}
