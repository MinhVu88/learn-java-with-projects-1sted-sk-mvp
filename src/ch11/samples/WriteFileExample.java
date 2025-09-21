// Writing to a file using FileWriter - pg 299
package ch11.samples;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {
	public static void main(String[] args) {
		try {
			FileWriter fileWriter = new FileWriter("src\\ch11\\samples\\output.txt");
			String content = "i can write!";

			fileWriter.write(content);
			fileWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
