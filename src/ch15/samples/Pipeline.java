// Figure 15.1 - pg 430
package ch15.samples;

import java.util.Arrays;

public class Pipeline {
	public static void main(String[] args) {
		var values = Arrays.asList(98.4, 100.2, 87.9, 102.8);
		
		long numberOfValues = values.stream()
																.peek(System.out::println)
																.filter(val -> val > 100)
																.peek(System.out::println)
																.count();

		System.out.println("numberOfValues => " + numberOfValues);
	}
}
