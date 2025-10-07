// Figure 8.26 
package ch8.samples;

class Dog {}
class Cat {}

public class InstanceOfExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();

		if(dog instanceof Dog) System.out.println("dog instanceof Dog -> " + (dog instanceof Dog));

		if(cat instanceof Cat) System.out.println("cat instanceof Cat -> " + (cat instanceof Cat));

		// if(cat instanceof Dog) System.out.println("cat instanceof Dog -> " + (cat instanceof Dog));
	}
}
