// Figure 8.29 (equivalent to Figure 8.30)
package ch8.samples.records;

import java.util.Objects;

public final class Person0 {
	private final String name;
	private final Integer age;

	public Person0(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

	public String name() {
		return this.name;
	}

	public Integer age() {
		return this.age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}

		if(obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		
		var that = (Person0) obj;
		
		return Objects.equals(this.name, that.name) &&
					 Objects.equals(this.age, that.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.age);
	}

	@Override
	public String toString() {
		return "name: " + this.name + " | age: " + this.age;
	}
}
