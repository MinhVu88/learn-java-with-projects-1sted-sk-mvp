// Figure 5.2
package ch5.samples;

public class Iteration0 {
	public static void main(String[] args) throws Exception {
		int x = 1;

		while(x <= 3) {
			System.out.println("loop: " + x);
			x++;
		}

		System.out.println("final x value: " + x);
	}
}
