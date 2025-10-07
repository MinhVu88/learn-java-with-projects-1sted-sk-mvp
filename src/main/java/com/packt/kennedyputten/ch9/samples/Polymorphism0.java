// Figure 9.4
package ch9.samples; 

class WarmBlooded {
	public void move() {
		System.out.println("WarmBlooded::move()");
	}
}

class Mammal extends WarmBlooded {
	@Override
	public void move() {
		System.out.println("Mammal::move()");
	}

	public void birth() {
		System.out.println("Mammal::birth()");
	}
}

class Bird extends WarmBlooded {
	@Override
	public void move() {
		System.out.println("Bird::move()");
	}

	public void fly() {
		System.out.println("Bird::fly()");
	}
}

class Wolf extends Mammal {
	@Override
	public void move() {
		System.out.println("Wolf::move()");
	}
}

class Elephant extends Mammal {}

public class Polymorphism0 {
	public static void main(String[] args) {
		WarmBlooded animal = new Mammal();
		animal.move();

		animal = new Bird();
		animal.move();
		// animal.fly(); // fly() is undefined for the type WarmBlooded

		animal = new Wolf();
		animal.move();

		animal = new Elephant();
		animal.move();

		// Wolf wolf = new WarmBlooded(); // Type mismatch: cannot convert from WarmBlooded to Wolf
		Wolf wolf = (Wolf) new WarmBlooded(); // Exception in thread "main" java.lang.ClassCastException
	}
}