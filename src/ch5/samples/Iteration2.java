// Figure 5.5 
package ch5.samples;

import java.util.Scanner;

public class Iteration2 {
	public static void main(String[] args) {
		Scanner sc = null;
		int sum = 0;
		boolean keepGoing = true;

		do {
			sc = new Scanner(System.in);
			System.out.print("enter a number (negative number to exit) -> ");
			int number = sc.nextInt();
			
			if(number < 0) {
				keepGoing = false;
			} else {
				sum += number;
			}
		} while(keepGoing);
		
		System.out.println("sum: " + sum);
		sc.close();
	}
}
