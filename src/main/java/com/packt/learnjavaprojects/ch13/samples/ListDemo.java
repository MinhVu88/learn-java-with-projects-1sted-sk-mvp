// ArrayList & LinkedList
package ch13.samples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

record Person0(int id, String name) {}

public class ListDemo {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();

		names.add("Mark Scout");
		names.add(0, "Helly Riggs");
		names.add("Harmony Cobel");
		names.add("Dylan George");

		System.out.println("names -> " + names);
		
		System.out.print(names.get(0) + " => ");
		names.set(0, "Helena Eagan");
		System.out.println(names.get(0));

		names.remove(names.size() - 1);
		names.remove("Harmony Cobel");

		for(int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i) + "     ");
		}

		System.out.println("\n-----------------------------------------------------------");

		List<Person0> employees = new LinkedList<>();
		
		employees.add(new Person0(32, "Seth Milchick"));
		employees.addFirst(new Person0(54, "Irving Bailiff"));
		employees.addLast(new Person0(56, "Burt Goodman"));
		employees.add(1, new Person0(30, "Devon Scout-Hale"));

		System.out.println(
			"id #" + employees.get(2).id() + ": " + employees.get(2).name() + " | " +
			"id #" + employees.getFirst().id() + ": " + employees.getFirst().name() + " | " +
			"id #" + employees.getLast().id() + ": " + employees.getLast().name()
		);

		System.out.println("-----------------------------------------------------------");

		Person0 e0 = new Person0(88, "Kier Eagan");
		employees.add(e0);

		System.out.println(
			e0.name() + " still an employee? -> " + employees.contains(e0) + 
			" | index: " + employees.indexOf(e0)
		);

		System.out.println("-----------------------------------------------------------");

		for(Person0 p : employees) {
			System.out.print("#" + p.id() + "-" + p.name() + "     ");
		}

		System.out.println(
			"\n\n" + employees.getFirst().name() + " still an employee? -> " + 
			employees.contains(employees.removeFirst()) +
			" | " + employees.getLast().name() + " still an employee? -> " + 
			employees.contains(employees.removeLast()) +
			" | " + employees.get(employees.size() - 1).name() + " still an employee? -> " + 
			employees.contains(employees.remove(employees.size() - 1)) + "\n"
		);

		ListIterator<Person0> employeesIterator = employees.listIterator();

		while(employeesIterator.hasNext()) {
			System.out.print(employeesIterator.next().name() + "     ");
		}
		
		System.out.println();
		
		while(employeesIterator.hasPrevious()) {
			System.out.print(employeesIterator.previous().name() + "     ");
		}
	}
}
