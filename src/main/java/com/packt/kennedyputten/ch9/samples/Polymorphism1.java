// Figure 9.5
package ch9.samples; 

class ColdBlooded {
	public void move() {
		System.out.println("ColdBlooded::move()");
	}
}

class Fish extends ColdBlooded {
	@Override
	public void move() {
		System.out.println("Fish::move()");
	}

	public void breatheThruGills() {
		System.out.println("Fish::breatheThruGills()");
	}
}

class Reptile extends ColdBlooded {
	@Override
	public void move() {
		System.out.println("Reptile::move()");
	}

	public void breatheThruLungs() {
		System.out.println("Reptile::breatheThruLungs()");
	}
}

class Shark extends Fish {
	@Override
	public void move() {
		System.out.println("Shark::move()");
	}
}

class Piranha extends Fish {}

public class Polymorphism1 {
	public static void demo(ColdBlooded animal) {
		animal.move();
	}

	public static void main(String[] args) {
		ColdBlooded animal = new Fish();
		demo(animal);
		demo(new Reptile());
		demo(new Shark());
		demo(new Piranha());
	}
}