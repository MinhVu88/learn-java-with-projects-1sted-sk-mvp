// Figure 8.22 (original program: Cow.java)
package ch8.samples;

class Person9 {}

public class PersonExample8 {
	Person9 employee;
	String country;

	void setCountry(String country) {
		this.country = country;
	}

	void profile(PersonExample8 pe) {
		this.employee = new Person9();
		pe.setCountry("Japan");
	}

	public static void main(String[] args) {
		PersonExample8 pe0 = new PersonExample8();
		PersonExample8 pe1 = pe0;
		pe1.profile(pe0);
	}
}
