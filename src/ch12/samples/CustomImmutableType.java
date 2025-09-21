// Designing a custom immutable type - pg 331
package ch12.samples;

import java.util.ArrayList;
import java.util.List;

final class Company {
	private final String name;
	private final int totalEmployees;
	private final List<String> departments;

	private Company(
		final String name,
		final int numberOfEmployees,
		final List<String> departments
	) {
		this.name = name;
		this.totalEmployees = numberOfEmployees;
		// this.departments = departments; // broken encapsulation 
		this.departments = new ArrayList<>(departments); // properly encapsulated
	}

	public String getName() {
		return this.name;
	}

	public int getTotalEmployees() {
		return this.totalEmployees;
	}

	public List<String> getDepartments() {
		// return this.departments; // broken encapsulation
		return new ArrayList<>(this.departments); // properly encapsulated
	}

	public static Company found(
		String name, 
		int employees, 
		List<String> departments
	) {
		return new Company(name, employees, departments);
	}

	@Override
	public String toString() {
		return "Company name: " + this.name + 
					 " | total employees: " + this.totalEmployees + 
					 " | departments: " + this.departments;
	}
}

// ERROR: The type Umbrella cannot subclass the final class Company
// class Umbrella extends Company {}

public class CustomImmutableType {
	public static void main(String[] args) {
		List<String> departments = new ArrayList<>();
		departments.add("IT");

		Company company = Company.found("Weyland-Yutani", 69, departments);
		System.out.println(company);

		String name = company.getName();
		int numberOfEmployees = company.getTotalEmployees();
		departments = company.getDepartments();
		System.out.println(name + " | " + numberOfEmployees + " | " + departments);

		name = "Vault-Tec";
		numberOfEmployees = 88;
		departments.add("HR");
		departments.add("Marketing");
		System.out.println(company);
	}
}
