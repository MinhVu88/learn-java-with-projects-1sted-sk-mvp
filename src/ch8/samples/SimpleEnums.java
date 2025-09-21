// Figure 8.27
package ch8.samples;

enum Animal {
	WOLF, 
	LAMB;
};

public class SimpleEnums {
	public static void main(String[] args) {
		// Animal elephant = new Animal(); // compiler error
		// Animal rat = Animal.EXTRA_LAMB; // type safety

		Animal animal0 = Animal.WOLF;

		System.out.println(
			"animal == Animal.WOLF -> " + (animal0 == Animal.WOLF) +
			" | animal.equals(Animal.WOLF) -> " + (animal0.equals(Animal.WOLF)) 
		);

		switch(animal0) {
			case LAMB:
				System.out.println("lamb");
				break;
			case WOLF:
				System.out.println("wolf");
				break;
			// case Animal.LAMB: // Error: unqualified enum value required
			// case 1: // can't use an int here	
		}

		// if(Animal.LAMB == 1) {}

		Animal animal1 = Animal.valueOf("LAMB");
		System.out.println("animal1 -> " + animal1);

		for(Animal animal : Animal.values()) {
			System.out.println("#" + animal.ordinal() + ": " + animal.name());
		}
	}
}
