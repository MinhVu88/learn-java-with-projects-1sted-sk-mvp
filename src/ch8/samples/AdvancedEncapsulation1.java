// Figure 8.20
package ch8.samples;

import java.util.Arrays;

class People1 {
	private int quantity;
	private int[] ages = new int[2];

	People1() {
		this.quantity = 2;
		this.ages[0] = 30;
		this.ages[1] = 40;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public int[] getAges() {
		// proper encapsulation: instead of directly returning the array object reference/instance var ages, 
		// a copied array object of the reference is returned by calling the static copyOf() on the Arrays class.
		// Consequently, getAges() now returns the reference that points to the copied array object  
		return Arrays.copyOf(this.ages, this.ages.length); 
	}
}

public class AdvancedEncapsulation1 {
	public static void main(String[] args) {
		People1 users = new People1();

		// copiesOfAges & ages now refer to different array objects on the heap
		// copiesOfAges is a reference to the copied array object & ages points to the original one (new int[2])
		int[] copiesOfAges = users.getAges();
		System.out.println(copiesOfAges[0] + " | " + copiesOfAges[1]);

		// any changes made to the copy won't affect the original, thus encapsulation is secure
		copiesOfAges[0] = -9;
		copiesOfAges[1] = -19;

		System.out.println(users.getAges()[0] + " | " + users.getAges()[1]);	
	}
}
