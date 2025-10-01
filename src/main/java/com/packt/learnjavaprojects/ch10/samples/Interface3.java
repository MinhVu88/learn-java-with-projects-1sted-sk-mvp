// Figure 10.4
package ch10.samples;

interface Vertebrate0 {}

interface WarmBlood0 {
	void regulateBodyTemp();
}

interface Flyable extends Vertebrate0, WarmBlood0 {
	void fly();
}

abstract class Bird implements Flyable {}

class Bat implements Flyable {
	@Override
	public void regulateBodyTemp() {
		System.out.println("bats are warm-blooded mammals that can regulate body temp");
	}

	@Override
	public void fly() {
		System.out.println("bats are the only mammals that can fly");		
	}
}

public class Interface3 {
	public static void main(String[] args) {
		Flyable mammal = new Bat();
		mammal.regulateBodyTemp();
		mammal.fly();
	}
}
