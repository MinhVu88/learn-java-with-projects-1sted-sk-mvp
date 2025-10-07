// Figure 5.3 
package ch5.samples;

import java.util.Scanner;

public class Iteration1 {
	public static void main(String[] args) {
		Scanner sc = null;
		int sum = 0;
		boolean keepGoing = true;

		while(keepGoing) {
			sc = new Scanner(System.in);
			System.out.print("enter a number (negative number to exit) -> ");
			int number = sc.nextInt();
			
			if(number < 0) {
				keepGoing = false;
			} else {
				sum += number;
			}
		}
		
		System.out.println("sum: " + sum);
		sc.close();
	}
}
