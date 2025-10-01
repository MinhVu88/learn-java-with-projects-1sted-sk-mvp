// Figure 9.8
package ch9.samples;

// import java.io.IOException;

class Person1 {
	public void walk() {
		System.out.println("Person1::walk()");
	}

	public Person1 run() {
		return new Person1();
	}
}

class Athlete extends Person1 {
	// The return type is incompatible with Person1.walk()
	// public String walk() {return "walk everyday";}
	
	// Cannot reduce the visibility of the inherited method from Person1
	// private void walk();

	// IOException is not compatible with throws clause in Person1.walk()
	// public void walk() throws IOException {}

	// this's an overload method, not an override one
	// public void walk(int distance) {}

	@Override
	public void walk() {
		System.out.println("Athlete::walk()");
	}

	/*
	// ok 
	@Override
	public Person1 run() {
		return new Person1();
	}
	*/	

	/* 
	// ok
	@Override
	public Athlete run() {
		return new Athlete();
	}
	*/

	@Override
	public Person1 run() {
		return new Athlete();
	}
}

public class MethodOverriding {
	public static void main(String[] args) {
		Person1 p0 = new Athlete();
		p0.walk();

		Person1 p1 = p0.run();
		
		if(p1 instanceof Athlete) {
			System.out.println("an Athlete object");
		}
	}
}
