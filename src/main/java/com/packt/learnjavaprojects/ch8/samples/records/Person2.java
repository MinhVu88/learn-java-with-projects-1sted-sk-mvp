// Figure 8.31
package ch8.samples.records;

public record Person2(String name, Integer age) {
	/*
	// compact canonical constructor (v.1) 
	public Person2(String name, Integer age) {
		if(age < 18) {
			this.name = "Error";
			this.age = -1;
		}

		this.name = name;
		this.age = age;
	}
	*/	

	// compact constructor (v.2)
	public Person2 {
		if(age < 18) {
			name = "Error";
			age = -1;
		}
	}
}

class Person2Test {
	public static void main(String[] args) {
		Person2 p0 = new Person2("Walter White", 50);
		System.out.println(p0 + " | name: " + p0.name() + " | age: " + p0.age());

		Person2 p1 = new Person2("Krazy-8", 17);
		System.out.println(p1 + " | name: " + p1.name() + " | age: " + p1.age());
	}
}