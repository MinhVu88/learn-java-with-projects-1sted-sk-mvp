// Figure 8.14
package ch8.samples.animals;

public class Dog {
	private String name; // visible only within the Dog class
	protected int age; // visible for classes within this package (ch8.codes.animals)
	
	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// visible for classes within this package (Dog & Cat)
	void packagePrivate() {}
}

// package-private class & constructor
class Cat {
	Cat() {}

	public void testDogAccess() {
		Dog dog = new Dog("Lucas");
		dog.age = 2;
		dog.packagePrivate();

		// dog.name = "Rex"; 
	}
}
