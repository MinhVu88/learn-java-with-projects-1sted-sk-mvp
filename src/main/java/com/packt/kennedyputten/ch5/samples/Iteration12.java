// Figure 5.18      
package ch5.samples;

public class Iteration12 {
	public static void main(String[] args) {
		System.out.println("i | j");

		OUTERLOOP:
		for(int i = 1; i <= 3; i++) {			
			for(int j = 1; j <= 5; j++) {
				if(j == 3) {
					break OUTERLOOP;
				}

				System.out.println(i + " | " + j);
			}
		}

		System.out.println("here");
	}
}
