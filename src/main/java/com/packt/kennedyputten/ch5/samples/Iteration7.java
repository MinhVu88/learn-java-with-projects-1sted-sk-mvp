// Figure 5.11    
package ch5.samples;

public class Iteration7 {
	public static void main(String[] args) {
		for(int i = 1; i <= 3; i++); {
			System.out.println("Looping");
		}

		for(int i = 10; i <= 50; i += 10) {
			System.out.println(i);
		}
		// System.out.println(i); // i is out of scope
		
		for(
			int i = 0, j = 0;
			i < 1 && j < 1;
			i++, j++
		) {
			System.out.println("i: " + i + " | j: " + j);
		}
	}
}
