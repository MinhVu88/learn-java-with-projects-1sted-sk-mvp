// Figure 8.16
package ch8.samples;

class Person7 {
	private String name;
	private int age;
	
	Person7(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class BasicEncapsulation0 {
	public static void main(String[] args) {
		Person7 p = new Person7("Luke Kemp", 23);
		
		// age is a private instance var, thus can't be accessed/modified directly via the object ref p
		// it must be accessed/modified via the getter/setter instance methods invoked by p
		// p.age = -99; 
		
		System.out.println("name: " + p.getName() + " | age: " + p.getAge());
		
		p.setAge(-99);
		System.out.println("name: " + p.getName() + " | age: " + p.getAge());
	}
}
