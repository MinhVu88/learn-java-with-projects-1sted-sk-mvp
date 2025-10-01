// Use cases for the finally block - pg 305
package ch11.samples;

import java.io.FileReader;
import java.io.IOException;

public class FileResourceCleanup {
	public static void main(String[] args) {
		FileReader fr = null;

		try {
			fr = new FileReader("src\\ch11\\samples\\input.txt");
			int character;

			while((character = fr.read()) != -1) {
				System.out.print((char) character);
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
