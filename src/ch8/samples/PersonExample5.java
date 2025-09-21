// Figure 8.10
package ch8.samples;

class Person5 {
	private String name; // default value is null

	Person5(String name) {
		// Without the "this" ref, the compiler assigns the param name to itself & the instance var name remains untouched.
		// Thus the instance var's default value is null when getName() is invoked via the p ref in main().
		// This is called shadowing/hiding an instance variable. 
		name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
}

public class PersonExample5 {
	public static void main(String[] args) {
		Person5 p = new Person5("Chris Cornell");
		System.out.println(p.getName()); // null
	}
}