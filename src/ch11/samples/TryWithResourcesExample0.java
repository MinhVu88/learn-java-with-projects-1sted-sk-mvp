// What is try-with-resources? - pg 307
package ch11.samples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesExample0 {
	public static void main(String[] args) {
		// 1 resource
		try(FileReader fr = new FileReader("src\\ch11\\samples\\input.txt")) {
			int character;
			StringBuilder fileContent = new StringBuilder();

			while((character = fr.read()) != -1) {
				fileContent.append((char) character);
			}

			System.out.println(fileContent.toString());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("-----------------------------------------------------------");

		// multiple resources
		try(
			FileReader fr = new FileReader("src\\ch11\\samples\\input.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("src\\ch11\\samples\\output.txt");
			BufferedWriter bw = new BufferedWriter(fw)
		) {
			String line;

			while((line = br.readLine()) != null) {
				String uppercaseLine = line.toUpperCase();
				bw.write(uppercaseLine);
				bw.newLine();
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
