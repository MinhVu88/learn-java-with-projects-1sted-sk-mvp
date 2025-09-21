// Figure 8.2
package ch8.samples;

class Person1 {
	// a default, compiler-defined constructor 
	Person1() {
		super();
	}
}

public class PersonExample1 {
	// a default, compiler-defined constructor
	public PersonExample1() {
		super();
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Person1 p = new Person1();
	}
}