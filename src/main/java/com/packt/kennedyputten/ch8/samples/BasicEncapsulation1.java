// Figure 8.17
package ch8.samples;

class Person8 {
	private String name;
	private int age;
	
	Person8(String name, int age) {
		setAge(age);
		this.name = name;
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
		if(isAgeOver17(age)) {
			this.age = age;
			System.out.println("age: " + this.age);
		} else {
			this.age = -1;
			System.out.println("age: " + this.age + " -> invalid age");
		}
	}

	private boolean isAgeOver17(int age) {
		return age >= 18 ? true : false;
	}
}

public class BasicEncapsulation1 {
	public static void main(String[] args) {
		Person8 p = new Person8("Keanu Reeves", 18);				
		p.setAge(17);
	}
}
