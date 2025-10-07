// Figure 9.12
package ch9.samples.protected_access_modifier.pkg0;

public class Person3 {
	protected void turnPage() {};
}

class Reader0 extends Person3 {
	public void read() {
		turnPage();
	}
}

class ProtectedDemo {
	void demo() {
		Person3 p = new Person3();
		p.turnPage();
	}
}