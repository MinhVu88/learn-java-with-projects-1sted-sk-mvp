// Figure 10.12
package ch10.samples;

sealed interface Describable permits Animal {
	String describe();

	default String getDescription() {
		return describe();
	}
}

sealed interface Animal extends Describable permits Vertebrate2, Invertebrate {
	String categorize();
}

sealed interface Vertebrate2 extends Animal permits WarmBlood2, ColdBlood1 {
	@Override
	default String categorize() {
		return "Vertebrates";
	}
}

non-sealed interface Invertebrate extends Animal {
	@Override
	default String categorize() {
		return "Invertebrates";
	}
}

final class WarmBlood2 implements Vertebrate2 {
	@Override
	public String describe() {
		return "Warm-blooded vertebrates: mammals & birds";
	}
}

final class ColdBlood1 implements Vertebrate2 {
	@Override
	public String describe() {
		return "Cold-blooded vertebrates: fish, amphibians & reptiles";
	}
}

class Jellyfish implements Invertebrate {
	@Override
	public String describe() {
		return "Jellyfish: a floating invertebrate";
	}
}

public class SealedPermitsNonsealed {
	static String describeAnimal(Describable animal) {
		return switch(animal) {
			case WarmBlood2 w -> w.getDescription();
			case ColdBlood1 c -> c.getDescription();
			case Invertebrate i -> i.getDescription();
			case Animal a -> a.getDescription();
		};
	}

	public static void main(String[] args) {
		Describable bird = new WarmBlood2();
    System.out.println(describeAnimal(bird));  

    Describable reptile = new ColdBlood1();
    System.out.println(describeAnimal(reptile)); 

    Describable jelly = new Jellyfish();
    System.out.println(describeAnimal(jelly));
	}
}
