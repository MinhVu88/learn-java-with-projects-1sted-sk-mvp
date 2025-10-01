// Multiple catch blocks - pg 304
package ch11.samples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultipleCatchExample {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src\\ch11\\samples\\input.txt");
			int character;

			while((character = fr.read()) != -1) {
				System.out.print((char) character);
			}

			fr.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
