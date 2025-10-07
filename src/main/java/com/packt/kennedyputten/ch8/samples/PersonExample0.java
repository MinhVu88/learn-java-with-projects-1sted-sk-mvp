// Figure 8.1
package ch8.samples;

class Person0 {}

public class PersonExample0 {
	public static void main(String[] args) {
		// the local var p is a reference (stored on the stack) of type Person0 that
		// points to an object (stored on the heap & created by invoking 
		// the Person0 class's default constructor via the new keyword) of type Person0
		@SuppressWarnings("unused")
		Person0 p = new Person0();
	}
}