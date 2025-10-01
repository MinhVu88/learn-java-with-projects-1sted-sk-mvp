// Figure 8.6
package ch8.samples;

class Person3 {
	private String name; // instance variable
	private static int count; // class/static variable (shared by all instances of the class)

	Person3(String n) {
		name = n;
		Person3.count++;
	}

	// instance/non-static method
	public String getName() {
		// class members can be accessed within an instance method but not vice versa
		System.out.println("Person3.count -> " + Person3.count);
		return name;
	}

	// instance/non-static method
	public void setName(String n) {
		name = n;
	}

	// class/static method
	public static int getCount() {
		// System.out.println(name); // ERROR! Class members can't access instance members explicitly/directly
		return Person3.count;
	}
}

public class PersonExample3 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Person3 p1 = new Person3("Maynard");
		Person3 p2 = new Person3("Adam");

		// System.out.println(p1.getCount()); // possible but not recommended
		System.out.println(p1.getName());
		System.out.println("the number of Person3 instances: " + Person3.getCount());
	}
}