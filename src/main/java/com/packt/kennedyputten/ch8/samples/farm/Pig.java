// Figure 8.15
package ch8.samples.farm;

import ch8.samples.animals.Dog;

public class Pig {
	void testDog() {
		// as the Dog class & its constructor are public, Dog instances can be created here
		// that's why access modifier for a class & its constructor(s) must be the same
		Dog dog = new Dog("Jim");
		System.out.println(dog.getName());

		// but Dog's package-private members can't be accessed here
		// dog.packagePrivate(); 
	}
}
