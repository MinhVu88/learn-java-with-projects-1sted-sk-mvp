// Figure 5.6  
package ch5.samples;

import java.util.Scanner;

public class Iteration3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("your age: ");
		int age = sc.nextInt();

		while(age >= 18) {
			System.out.println("=> You can buy alcohol");
			System.out.print("your age: ");
			age = sc.nextInt();
		}
		
		sc.close();
	}
}
