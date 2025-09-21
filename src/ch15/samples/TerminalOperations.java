package ch15.samples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperations {
	// Figure 15.11 - pg 443 
	public static void getCount() {
		long numberOfValues = Stream.of(
			"Neo", "Trinity", 
			"Morpheus", "Agent Smith", 
			"The Oracle", "The Architect").count();
		System.out.println("number of values: " + numberOfValues);
	}

	// Figure 15.12 - pg 443
	public static void getMinMax() {
		Optional<String> minVal = Stream.of(
			"Neo", "Trinity", 
			"Morpheus", "Agent Smith", 
			"The Oracle", "The Architect").min((val0, val1) -> val0.length() - val1.length());
		minVal.ifPresent(System.out::println);
		
		Optional<Integer> maxVal = Stream.of(4, 6, 2, 12, 9)
																		 .max((val0, val1) -> val0 - val1);
		maxVal.ifPresent(System.out::println);

		@SuppressWarnings("unused")
		Optional<Object> emptyStream = Stream.empty().min((val0, val1) -> 0);
		System.out.println(
			"isEmpty() => " + emptyStream.isEmpty() + 
			" | ispresent() => " + emptyStream.isPresent()
		);
	}

	// Figure 15.13 - pg 445
	public static void getFindAnyFindFirst() {
		Optional<String> names0 = Stream.of(
			"Neo", "Trinity", 
			"Morpheus", "Agent Smith", 
			"The Oracle", "The Architect").findAny();
		names0.ifPresent(System.out::println);
		
		Optional<String> names1 = Stream.of(
			"Elliot", "Darlene", 
			"Angela", "Tyrell", 
			"Phillip", "Otto").findFirst();
		names1.ifPresent(System.out::println);	
	}

	// Figures 15.14 & 15.15 - pgs 445 & 446
	public static void getMatches() {
		List<String> names = Arrays.asList(
			"Daisuke Aramaki", "Motoko Kusanagi",
			"Tateaki Koshiki", "Hideo Kuze",
			"Yoko Kayabuki", "Kazundo Gouda"
		);
		Predicate<String> name = n -> n.startsWith("M");
		System.out.println(
			"names: anyMatch() => " + names.stream().anyMatch(name) +
			" | allMatch() => " + names.stream().allMatch(name) +
			" | noneMatch() => " + names.stream().noneMatch(name)
		);

		Stream<String> letters = Stream.generate(() -> "abc");
		Predicate<String> letter0 = l -> l.startsWith("a");
		Predicate<String> letter1 = l -> l.startsWith("b");
		System.out.println("letters.anyMatch(letter0) => " + letters.anyMatch(letter0));
		System.out.println("letters.anyMatch(letter1) => " + letters.anyMatch(letter1));

		System.out.println("letters.noneMatch(letter0) => " + letters.noneMatch(letter0));
		System.out.println("letters.noneMatch(letter1) => " + letters.noneMatch(letter1));

		System.out.println("letters.allMatch(letter0) => " + letters.allMatch(letter0));
		System.out.println("letters.allMatch(letter1) => " + letters.allMatch(letter1));
	}

	// Figure 15.16 - pg 447
	public static void getForEach() {
		Stream<String> names = Stream.of(
			"Walter White", "Jesse Pinkman", "Saul Goodman",
			"Gustavo Fring", "Hank Schrader", "Mike Ehrmantraut"
		);
		names.forEach(System.out::println);

		// Stream<Integer> numbers = Stream.of(7);
		// for(Integer n : numbers) {}
	}

	// Figure 15.17 - pg 448
	public static void getReduce0() {
		String name0 = Stream.of("w", "o", "l", "f", "g", "a", "n", "g")
												 .reduce("", (str0, str1) -> str0 + str1);
		System.out.println("name0 => " + name0);
		
		String name1 = Stream.of("a", "g", "a", "p", "e")
												 .filter(str -> str.length() > 2)
												 .reduce("...", (str0, str1) -> str0 + str1);
		System.out.println("name1 => " + name1);
		
		Integer number = Stream.of(23, 7, 51)
													 .reduce(1, (num0, num1) -> num0 * num1);
		System.out.println("number => " + number);											 
	}

	// Figure 15.18 - pg 450
	public static void getReduce1() {
		Stream<String> letters = Stream.of("abc", "def", "ghijk", "lmnopqrst");
		int numberOfLetters = letters.reduce(
			0,
			(number, str) -> number + str.length(),
			(num0, num1) -> num0 + num1
		);
		System.out.println("number of letters => " + numberOfLetters);
	}

	// Bonus (not in the book)
	public static void getReduce2() {
		BinaryOperator<Integer> accumulator = (val0, val1) -> val0 + val1;
		
		Stream<Integer> emptyVal = Stream.empty();
		emptyVal.reduce(accumulator).ifPresent(System.out::println);

		Stream<Integer> oneVal = Stream.of(8);
		oneVal.reduce(accumulator).ifPresent(System.out::println);
		
		Stream<Integer> values = Stream.of(9, 88, 29);
		values.reduce(accumulator).ifPresent(System.out::println);

		@SuppressWarnings("unused")
		Integer value = Stream.of(1, 1, 1)
													.filter(v -> v > 5)
													.reduce(1, (e0, e1) -> e0);
		System.out.println("value => " + value);
	}

	// Figure 15.19 - pg 451
	public static void getCollect() {
		StringBuilder word = Stream.of("Te", "rmi", "n", "alOp", "er", "a", "tions")
															 .collect(
																	() -> new StringBuilder(),
																	(strBuilder, str) -> strBuilder.append(str),
																	(strBuilder0, strBuilder1) -> strBuilder0.append(strBuilder1)
															 );
		System.out.println("word => " + word);		
	} 

	public static void main(String[] args) {
		getCount();
		System.out.println("-----------------------------------------------------------");
		getMinMax();
		System.out.println("-----------------------------------------------------------");
		getFindAnyFindFirst();
		System.out.println("-----------------------------------------------------------");
		try {
			getMatches();
		} catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-----------------------------------------------------------");
		getForEach();
		System.out.println("-----------------------------------------------------------");
		getReduce0();
		getReduce1();
		getReduce2();
		System.out.println("-----------------------------------------------------------");
		getCollect();
	}
}
