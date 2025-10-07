// Figure 14.4 (Predicate & BiPredicate) - pg 403
package ch14.samples;

import java.util.Random;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CoreFunctionalInterfaces0 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] alphabet = {
			"a", "b", "c", "d", "e", "f", "g", "h", 
			"i", "j", "k", "l", "m", "n", "o", "p", 
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
		};

		String randomLetter0 = alphabet[new Random().nextInt(alphabet.length + 1)];

		Predicate<String> predicateDemo0 = str -> str.startsWith(randomLetter0);
		
		System.out.print("- Enter word #0: ");
		String word0 = scanner.nextLine();

		System.out.println(
			"  . Does '" + word0 + "' start with '" + randomLetter0 + 
			"'? => " + predicateDemo0.test(word0.toLowerCase())
		);

		Predicate<Integer> predicateDemo1 = number -> number % 2 == 0;

		System.out.println(
			"- Is 2 even? => " + predicateDemo1.test(2) +
			" | Is 7 even? => " + predicateDemo1.test(7)
		);

		System.out.println("-----------------------------------------------------------");

		BiPredicate<String, String> biPredicateDemo0 = (str, letter) -> str.contains(letter);

		System.out.print("- Enter word #1: ");
		String word1 = scanner.nextLine();

		String randomLetter1 = alphabet[new Random().nextInt(alphabet.length + 1)];

		System.out.println(
			"  . Does '" + word1 + "' contain '" + randomLetter1 + 
			"'? => " + biPredicateDemo0.test(word1.toLowerCase(), randomLetter1)
		);

		BiPredicate<Integer, Integer> biPredicateDemo1 = (num0, num1) -> num0 % num1 == 0;

		System.out.println(
			"- Is 10 divisible by 2? => " + biPredicateDemo1.test(10, 2) +
			" | Is 10 divisible by 4? => " + biPredicateDemo1.test(10, 4)
		);

		System.out.println("-----------------------------------------------------------");

		Predicate<String> predicateDemo2 = str -> str.endsWith(randomLetter0);
		Predicate<String> predicateDemo3 = predicateDemo0.or(predicateDemo2);

		System.out.print("- Enter word #2: ");
		String word2 = scanner.nextLine();

		System.out.println(
			"  . Does '" + word2 + "' start or end with '" + randomLetter0 + 
			"'? => " + predicateDemo3.test(word2.toLowerCase())
		);
		
		BiPredicate<Integer, Integer> biPredicateDemo2 = (num0, num1) -> (num0 >= 0 || num0 <= 0) && num1 > 0;
		BiPredicate<Integer, Integer> biPredicateDemo3 = biPredicateDemo1.and(biPredicateDemo2);

		try {
			System.out.println(
				"- Is 10 divisible by 2? => " + biPredicateDemo3.test(10, 2) +
				" | Is 9 divisible by 4? => " + biPredicateDemo3.test(9, 4) +
				" | Is 0 divisible by 5? => " + biPredicateDemo3.test(0, 5) +
				" | Is -3 divisible by 7? => " + biPredicateDemo3.test(-3, 7)
			);
			System.out.println(biPredicateDemo3.test(4, 0));
		} catch(ArithmeticException e) {
			System.out.println("  . Error: " + e.getMessage());
		}

		BiPredicate<Integer, Integer> biPredicateDemo4 = biPredicateDemo3.negate();
		System.out.println("- Is -3 divisible by 7? => " + biPredicateDemo4.test(-3, 7));

		scanner.close();
	}
}
