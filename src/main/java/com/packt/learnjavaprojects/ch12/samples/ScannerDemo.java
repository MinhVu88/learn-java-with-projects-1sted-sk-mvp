// Understanding the Scanner class - pg 316
package ch12.samples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerDemo {
	// Using Scanner to read from the keyboard - pg 317
	private static void readFromKeyboard0() {
		Scanner sc0 = new Scanner(System.in);
		System.out.print("enter age #0: ");

		if(sc0.hasNextInt()) {
			int age = sc0.nextInt();
			System.out.println("age #0 entered: " + age);
		}

		sc0.close();

		try(Scanner sc1 = new Scanner(System.in)) {
			System.out.print("enter age #1: ");
			int age = sc1.nextInt();
			System.out.println("age #1 entered: " + age);
		} catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void readFromKeyboard1() {
		Scanner sc0 = new Scanner(System.in);
		System.out.print("enter name #0: ");
		System.out.println("sc0.next() => " + sc0.next());

		Scanner sc1 = new Scanner(System.in);
		System.out.print("enter name #1: ");
		System.out.println("sc1.nextLine() => " + sc1.nextLine());
		
		sc0.close();
		sc1.close();
	}

	// Using Scanner to read from a file - pg 319
	private static void readFromFile() {
		try(Scanner sc = new Scanner(new File("src\\ch12\\samples\\ages.txt"))) {
			if(sc.hasNextInt()) System.out.println("from ages.txt => " + sc.nextInt());
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// Using Scanner to read from a string - pg 320
	private static void readFromString() {
    Scanner sc = new Scanner("Maaike   delim vandelim Putten delim 22")
								 .useDelimiter("\\s*delim\\s*");    
		System.out.println(sc.next());
    System.out.println(sc.next());
    System.out.println(sc.next());
    System.out.println(sc.nextInt());
    sc.close();
	}

	public static void main(String[] args) {
		// readFromKeyboard0();
		// readFromKeyboard1();
		// readFromFile();
		readFromString();
	}
}
