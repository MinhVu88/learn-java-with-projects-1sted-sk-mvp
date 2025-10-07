// Figure 15.2 - pg 432
package ch15.samples;

import java.util.Arrays;
import java.util.List;

public class Laziness {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");

		names.stream()
				 .peek(System.out::println)
				 .filter(name -> {
						System.out.println("filtered layer 0: " + name);
						return name.startsWith("B") || name.startsWith("C");
				 })
				 .filter(name -> {
						System.out.println("filtered layer 1: " + name);
						return name.length() > 3;
				 })
				 .limit(1)
				 .forEach(System.out::println);
	}
}
