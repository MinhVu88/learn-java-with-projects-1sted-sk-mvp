// Figure 9.2
package ch9.samples; 

class Animal0 {
	public String toString() {
		return "Animal0::toString()";
	}
}

class Vertebrate0 extends Animal0 {}
class Invertebrate0 extends Animal0 {}
class WarmBlood0 extends Vertebrate0 {}
class ColdBlood0 extends Vertebrate0 {}

public class InheritanceDemo {
	public static void main(String[] args) {
		Animal0 animal = new Animal0();
		System.out.println("animal.toString() -> " + animal.toString());

		Vertebrate0 vertebrate = new Vertebrate0();
		System.out.println("vertebrate -> " + vertebrate);

		WarmBlood0 bird = new WarmBlood0();
		System.out.println("bird -> " + bird);

		System.out.println("new InheritanceDemo().toString() -> " + new InheritanceDemo().toString());
	}
}