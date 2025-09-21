// Figure 9.13
package ch9.samples.protected_access_modifier.pkg1;

import ch9.samples.protected_access_modifier.pkg0.Person3;

public class Reader1 extends Person3 {
	public void read() {
		turnPage();
		this.turnPage();

		Reader1 r = new Reader1();
		r.turnPage();

		Person3 p = new Person3();
		// p.turnPage(); // The protected turnPage() from the type Person3 isn't visible here
	}
}

class Reader2 extends Reader1 {
	public void read() {
		turnPage();

		// turnPage() from the type Person3 isn't visible here
		// new Person3().turnPage();

		// turnPage() isn't visible here
		// new Reader1().turnPage();

		new Reader2().turnPage();
	}
}

class ProtectedDemo {
	public void demo() {
		Person3 p = new Person3();
		// p.turnPage(); // turnPage() isn't visible here

		Reader1 r = new Reader1();
		// r.turnPage(); // turnPage() isn't visible here
	}
}