// Figure 9.10
package ch9.samples;

class Person2 {
	private int id;
	private String name;
	
	public Person2(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "id: " + this.id + " | name: " + this.name;
	}
}

class Employee extends Person2 {
	private String role;

	Employee(int id, String name, String role) {
		super(id, name);
		this.role = role;
	}

	@Override
	public String toString() {
		return super.toString() + " | role: " + this.role;
	}
}

class Manager extends Employee {
	private double salary;

	Manager(
		int id,
		String name,
		String role,
		double salary
	) {
		super(id, name, role);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + " | monthly salary: $" + this.salary;
	}
}

public class SuperKeyword {
	public static void main(String[] args) {
		Person2 employee = new Manager(7, "Elliot Alderson", "team leader", 123.45);
		System.out.println(employee);
	}	
}
