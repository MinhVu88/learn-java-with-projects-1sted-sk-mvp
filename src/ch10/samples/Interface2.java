// Figure 10.3
package ch10.samples;

interface Demonstrable0 {
	double PI_VAL = Math.PI; // implicitly "public static final" (constant)
	void demo(); // "public abstract" by default (instance member/method)
}

public class Interface2 implements Demonstrable0 {
	// In a class, a method that doesn't have an access modifier is package-private by default.
	// Therefore, demo() must be public here as "public" can't be reduced to "package-private".
	// void demo();

	@Override
	public void demo() {
		System.out.println("Interface2::demo()");
	}

	public static void main(String[] args) {
		// PI_VAL = 3.2; // can't modify a final variable
		// demo(); // can't refer to an instance member from a static context

		System.out.println("Demonstrable0.PI_VAL -> " + Demonstrable0.PI_VAL + " | PI_VAL -> " + PI_VAL);
		new Interface2().demo();
	}
}
