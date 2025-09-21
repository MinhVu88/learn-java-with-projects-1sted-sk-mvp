// Figure 8.8
package ch8.samples;

class Person4 {
	private String name;

	Person4(String n) {
		// name = n;
		this.name = n;
	}

	public String getName() {
		// return name;
		return this.name;
	}

	public void setName(String n) {
		// name = n;
		this.name = n;
	}
}

public class PersonExample4 {
	public static void main(String[] args) {
		Person4 p1 = new Person4("Justin");
		System.out.println(p1.getName());
		p1.setName("Justin Chancellor");
		System.out.println(p1.getName());

		Person4 p2 = new Person4("Paul");
		System.out.println(p2.getName());
		p2.setName("Paul D'Amour");
		System.out.println(p2.getName());
	}
}