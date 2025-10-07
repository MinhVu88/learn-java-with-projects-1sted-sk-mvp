// Figure 10.5
package ch10.samples;

interface Vertebrate1 {
	void live(); // abstract method

	// default method (must be public)
	// automatically inheritable & optionally implemented by implementing classes
	default void fly() {} 
}

class WarmBlood1 implements Vertebrate1 {
	@Override
	public void live() {
		System.out.println("most warm-blooded vertebrates live on land");
	}
	
	@Override
	public void fly() {
		System.out.println("birds & bats are the only modern warm-blooded vertebrates that can fly");
	}
}

class ColdBlood0 implements Vertebrate1 {
	@Override
	public void live() {
		System.out.println("many cold-blooded vertebrates live both on land & in water");
	}
}

public class DefaultInterfaceMethod0 {
	public static void main(String[] args) {
		Vertebrate1 wolf = new WarmBlood1();
		wolf.live();
		wolf.fly();

		System.out.println("-----------------------------------------------------------");

		Vertebrate1 eagle = new WarmBlood1();
		eagle.live();
		eagle.fly();

		System.out.println("-----------------------------------------------------------");

		Vertebrate1 frog = new ColdBlood0();
		frog.live();
		frog.fly();
	}
}
