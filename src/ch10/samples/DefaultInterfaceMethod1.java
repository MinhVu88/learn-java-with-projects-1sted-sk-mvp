// Figure 10.7
package ch10.samples;

interface Terrain {
	default void live() {
		System.out.println("live on land");
	}
}

interface Aquatic {
	default void live() {
		System.out.println("live in water");
	}
}

class Amphibian implements Terrain, Aquatic {
	@Override
	public void live() {
		// this makes the compiler look for a non-existent static method named live() in Terrain
		// Terrain.live();

		Terrain.super.live();
		Aquatic.super.live();
	}
}

public class DefaultInterfaceMethod1 {
	public static void main(String[] args) {
		// Aquatic.super.live(); // can't use "super" in a static method/context

		Amphibian toad = new Amphibian();
		toad.live();
	}
}
