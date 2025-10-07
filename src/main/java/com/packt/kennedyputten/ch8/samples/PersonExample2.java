// Figure 8.3
package ch8.samples;

class Person2 {
	// instance variables (defined within the class but outside every method)
	private String name;
	private int count;

	Person2(String n) {
		name = n;
		count++;
	}

	// instance methods (getName, setName & getCount)
	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public int getCount() {
		return count;
	}
}

public class PersonExample2 {
	public static void main(String[] args) {
		Person2 p1 = new Person2("Maynard");
		System.out.println(p1.getName());
		p1.setName("Maynard James Keenan");
		System.out.println(p1.getName());

		Person2 p2 = new Person2("Adam");
		System.out.println(p2.getName());
		p2.setName("Adam Thomas Jones");
		System.out.println(p2.getName());
	}
}