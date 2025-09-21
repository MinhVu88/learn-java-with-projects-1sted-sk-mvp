// Figure 8.18
package ch8.samples;

class People0 {
	private int quantity;
	private int[] ages = new int[2];

	People0() {
		this.quantity = 2;
		this.ages[0] = 30;
		this.ages[1] = 40;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public int[] getAges() {
		// simply returning the array object reference/private instance var ages breaks encapsulation
		return this.ages; 
	}
}

public class AdvancedEncapsulation0 {
	public static void main(String[] args) {
		People0 users = new People0();

		// Based on Java’s call-by-value mechanism, numberOfUsers is assigned a copy of quantity returned from getQuantity().
		// But changes made to a copy of a primitive data type don't affect the value of the original one (2 in this case). 
		// Thus encapsulation remains intact as long as a class's private instance var isn't a reference to an object.
		int numberOfUsers = users.getQuantity();
		System.out.println(numberOfUsers);
		numberOfUsers = -100;
		numberOfUsers = users.getQuantity();
		System.out.println(numberOfUsers);

		// as copiesOfAges & ages both point to the same array object (new int[2]) stored on the heap,
		// it's then possible for any changes made to copiesOfAges to also affect the original array object.
		// Thus encapsulation becomes insecure
		int[] copiesOfAges = users.getAges();
		System.out.println(copiesOfAges[0] + " | " + copiesOfAges[1]);

		copiesOfAges[0] = -9;
		copiesOfAges[1] = -19;
		
		System.out.println(users.getAges()[0] + " | " + users.getAges()[1]);	
	}
}
