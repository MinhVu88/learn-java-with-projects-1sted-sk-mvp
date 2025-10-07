// Figures 15.8, 15.9 & 15.10 - pgs 440 & 441
package ch15.samples;

import java.util.stream.Stream;

public class InfiniteStreamsIterate {
	public static int getRandomNumber() {
		return (int) (Math.random() * 10);
	}

	public static void iterateInfinitely() {
		// loop thru infinite stream of ordered numbers (Ex: 2, 4, 6, 8, 10, 12 etc.)
		Stream<Integer> infiniteStream = Stream.iterate(2, number -> number + 2);
		infiniteStream.forEach(System.out::println);
	}

	public static void iterateFinitely() {
		// loop thru finite stream of ordered numbers (Ex: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20) 
		Stream.iterate(2, number -> number + 2)
					.limit(10)
					.forEach(System.out::println);
	}

	public static void iterateWithPredicate() {
		// loop thru // finite stream of ordered numbers (Ex: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
		Stream.iterate(
			2, 
			number -> number <= 20,
			number -> number + 2
		).forEach(System.out::println);
	}

	public static void main(String[] args) {
		// for(int i = 1; i < 100; i++) {
		// 	System.out.println(getRandomNumber());
		// }

		iterateInfinitely();
		// iterateFinitely();
		// iterateWithPredicate();
	}
}
