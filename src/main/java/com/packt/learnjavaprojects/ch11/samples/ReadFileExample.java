// Reading from a file using FileReader - pg 297
package ch11.samples;

import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("src\\ch11\\samples\\input.txt");
			int character;

			while((character = fileReader.read()) != -1) {
				System.out.print((char) character);
			}

			fileReader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
