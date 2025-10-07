// Figure 5.15      
package ch5.samples;

public class Iteration10 {
	public static void main(String[] args) {
		int[] numbers = {9, 3, 5, 7};

		System.out.println("[]\t[n]\tHistogram");

		for(int i = 0; i < numbers.length; i++) {
			System.out.print(i + "\t" + numbers[i] + "\t");
			
			for(int j = 1; j <= numbers[i]; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
}
