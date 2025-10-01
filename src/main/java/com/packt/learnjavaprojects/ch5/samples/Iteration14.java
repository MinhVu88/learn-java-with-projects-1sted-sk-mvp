// Figure 5.20      
package ch5.samples;

public class Iteration14 {
	public static void main(String[] args) {
		System.out.println("i | j\n====");

		OUTERLOOP:
		for(int i = 1; i <= 3; i++) {			
			for(int j = 1; j <= 5; j++) {
				if(j == 3) {
					continue OUTERLOOP;
				}

				System.out.println(i + " | " + j);
			}
		}
	}
}
