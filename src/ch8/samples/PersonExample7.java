// Figure 8.12 
package ch8.samples;

public class PersonExample7 {
	int x;

	public void instanceMethod() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		// ERROR! instance members can't explicitly/directly be accessed within a class/static member
		// x = 3; // same as "this.x = 3;"
		// instanceMethod(); // same as "this.instanceMethod();"

		PersonExample7 pe7 = new PersonExample7();
		System.out.println(pe7.x);
		pe7.x = 7;
		System.out.println(pe7.x);
		pe7.instanceMethod();
	}
}