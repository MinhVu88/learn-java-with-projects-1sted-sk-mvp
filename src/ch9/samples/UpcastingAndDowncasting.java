// Figures 9.20 & 9.21
package ch9.samples;

class Machine {
	void turnOn() {
		System.out.println("Machine::turnOn()");
	}
}

class Toaster extends Machine {
	@Override
	void turnOn() {
		System.out.println("Toaster::turnOn()");
	}

	void toast() {
		System.out.println("Toaster::toast()");
	}
}

public class UpcastingAndDowncasting {
	public static void demo0(Machine m) {
		m.turnOn();
	}

	public static void demo1(Machine m) {
		// m.toast(); // toast() is undefined for the type Machine

		((Toaster) m).toast(); // Exception in thread "main" java.lang.ClassCastException

		if(m instanceof Toaster t) {
			t.toast();
		}
	}

	public static void main(String[] args) {
		Machine m = new Toaster(); // upcasting
		demo0(m); // polymorphism
		demo0(new Toaster()); // polymorphism

		demo1(new Machine());
		demo1(new Toaster());
	}
}
