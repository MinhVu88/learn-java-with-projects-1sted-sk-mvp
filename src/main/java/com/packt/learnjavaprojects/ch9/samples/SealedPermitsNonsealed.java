// Figure 9.17 
package ch9.samples;

sealed class Animal1 permits Vertebrate1, Invertebrate1 {
	public String toString() {
		return "an animal is either a vertebrate or an invertebrate";
	}
}

sealed class Vertebrate1 extends Animal1 permits WarmBlood1, ColdBlood1 {
	public String toString() {
		return "a vertebrate has a spine";
	}
}

non-sealed class Invertebrate1 extends Animal1 {
	public String toString() {
		return "an invertebrate doesn't have a spine";
	}
}

final class WarmBlood1 extends Vertebrate1 {
	public String toString() {
		return "warm-blooded vertebrates consist of mammals & birds";
	}
}

final class ColdBlood1 extends Vertebrate1 {
	public String toString() {
		return "cold-blooded vertebrates consist of fish, amphibians & reptiles";
	}
}

public class SealedPermitsNonsealed {
	static String describeAnimal(Animal1 animal) {
		return switch(animal) {
			case WarmBlood1 w -> w.toString();
			case ColdBlood1 c -> c.toString();
			case Invertebrate1 i -> i.toString();
			case Animal1 a -> a.toString();
		};
	}

	public static void main(String[] args) {
		Animal1 animal = new Animal1();
    System.out.println(describeAnimal(animal));

    Animal1 vertebrate = new Vertebrate1();
    System.out.println(describeAnimal(vertebrate));

    Animal1 bird = new WarmBlood1();
    System.out.println(describeAnimal(bird));

    Animal1 reptile = new ColdBlood1();
    System.out.println(describeAnimal(reptile));

    Animal1 invertebrate = new Invertebrate1();
    System.out.println(describeAnimal(invertebrate));
	}
}
