// Figure 5.7  
package ch5.samples;

import java.util.Scanner;

public class Iteration4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("your age: ");
		int age = sc.nextInt();

		do {
			System.out.println("=> You can buy alcohol");
			System.out.print("your age: ");
			age = sc.nextInt();
		} while(age >= 18);
		
		sc.close();
	}
}
