// Figure 15.4 - pg 434
package ch15.samples;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStreams0 {
	public static void main(String[] args) {
		Double[] values = {1.1, 2.2, 3.3};
		Stream<Double> streamedNumbers = Arrays.stream(values);
		long numberOfValues = streamedNumbers.count();
		System.out.println("number of 'values' elements: " + numberOfValues);
	}
}
