// Figure 15.7 - pg 439
package ch15.samples;

import java.util.stream.Stream;

public class InfiniteStreamsGenerate {
	public static void generateInfiniteStreams() {
		// infinite stream of random unordered numbers between 0 & 9 inclusive
		Stream<Integer> infiniteStream = Stream.generate(() -> (int) (Math.random() * 10));
		infiniteStream.forEach(System.out::println);
	}

	public static void main(String[] args) {
		generateInfiniteStreams();
	}
}
