// Figure 9.7
package ch9.samples;

class Person0 {
	public void eat() {}
}

class Customer extends Person0 {
	public void eat() {}
	public void eat(String food) {}
}

public class MethodOverloading {
	public void calculate(int val1, double val2) {} // calculate(int, double)
	public void calculate() {} // calculate()
	public void calculate(int val) {} // calculate(int)
	public void calculate(double val) {} // calculate(double)
	public void calculate(double val1, int val2) {} // calculate(double, int)

	// Duplicate methods: calculate(int, double)
	// public void calculate(int val3, double val4) {}
	// public double calculate(int val5, double val6) {return val5 + val6;}

	public static void main(String[] args) {
		Person0 p0 = new Person0();
		p0.eat();
		// p0.eat("pizza"); // eat() in the type Person0 isn't applicable for the args (String)

		Person0 p1 = new Customer();
		p1.eat();
		// p1.eat("pizza"); // eat() in the type Person0 isn't applicable for the args (String)

		Customer p2 = new Customer();
		p2.eat();
		p2.eat("pizza");
	}
}
