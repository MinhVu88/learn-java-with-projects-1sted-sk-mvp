// Figure 8.11 
package ch8.samples;

// Person6 is a package-private class, which has no access modifier.
// Person6 can't be imported into another package.
class Person6 {
	private String name;

	// Consequently, the constructor is also package-private.
	// That means it's impossible to create any Person6 object from within another package.
	Person6(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
}

public class PersonExample6 {
	public static void main(String[] args) {
		Person6 p = new Person6("Chester Bennington");
		System.out.println(p.getName());
	}
}