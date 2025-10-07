// Figure 14.3
package ch14.samples;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

class Lottery {
	int value;
	Lottery(int v) {
		v = new Random().nextInt(Integer.MAX_VALUE - 0) + 0;
		this.value = v;
	}
}

public class FinalOrEffectivelyFinal {
	public static void main(String[] args) {
		int randomNumber0 = new Random().nextInt(10 - 0) + 0;

		// This works because number is a parameter inside the lambda, not a captured variable
		Predicate<Integer> isEven = number -> number % 2 == 0;
		System.out.println(randomNumber0 + " is even? -> " + isEven.test(randomNumber0));
		
		System.out.println("-----------------------------------------------------------");
		
		// final int divisor = 2; // Explicitly final
		int divisor = 2; // Effectively final (never reassigned)

		// Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		// Local variable divisor defined in an enclosing scope must be final or effectively final
		// divisor = 3;

		Predicate<Integer> isOdd = n -> n % divisor != 0;

		// divisor = 3; // same exception as above
		
		System.out.println(randomNumber0 + " is odd? -> " + isOdd.test(randomNumber0));

		System.out.println("-----------------------------------------------------------");

		// Using an Array Wrapper as a Workaround for Non-Final Variables
		int[] lotteryNumber0 = {(new Random().nextInt(Integer.MAX_VALUE - 0) + 0)};
		
		Predicate<Integer> isEqual = number -> {
			System.out.println(number + " = " + lotteryNumber0[0] + " -> " + (number == lotteryNumber0[0]));
			return number == lotteryNumber0[0];
		};

		isEqual.test((new Random().nextInt(Integer.MAX_VALUE - 0) + 0));
		
		lotteryNumber0[0] = new Random().nextInt(Integer.MAX_VALUE - 0) + 0;
		
		isEqual.test(lotteryNumber0[0]);

		System.out.println("-----------------------------------------------------------");

		// Using AtomicInteger for Thread-Safety
		AtomicInteger lotteryNumber1 = new AtomicInteger(lotteryNumber0[0]);
		
		Predicate<Integer> isGreater = number -> {
			System.out.println(number + " > " + lotteryNumber1.get() + " -> " + (number > lotteryNumber1.get()));
			return number > lotteryNumber1.get();
		};

		isGreater.test((new Random().nextInt(Integer.MAX_VALUE - 0) + 0));
		
		System.out.println("-----------------------------------------------------------");
		
		// Using a Custom Wrapper Class
		Lottery number = new Lottery(lotteryNumber1.get());
		
		Predicate<Integer> isBelow = n -> {
			System.out.println(n + " < " + number.value + " -> " + (n < number.value));
			return n < number.value;
		};
		
		isBelow.test((new Random().nextInt(Integer.MAX_VALUE - 0) + 0));

		System.out.println("-----------------------------------------------------------");

		Predicate<Integer> isOverFive = n -> n > 5;
		Predicate<Integer> isBelowFive = n -> n < 5;
		
		Predicate<Integer> complexPredicate0 = isEven.and(isOverFive);
		Predicate<Integer> complexPredicate1 = isOdd.or(isBelowFive);

		System.out.println(randomNumber0 + " is both even & over 5? -> " + complexPredicate0.test(randomNumber0));
		System.out.println(randomNumber0 + " is either odd or below 5? -> " + complexPredicate1.test(randomNumber0));

		Predicate<Integer> complexPredicate2 = Predicate.not(isOverFive).and(isOdd);
		Predicate<Integer> complexPredicate3 = Predicate.not(isBelowFive).or(isEven);

		System.out.println(randomNumber0 + " is both below 5 & odd? -> " + complexPredicate2.test(randomNumber0));
		System.out.println(randomNumber0 + " is either over 5 or even? -> " + complexPredicate3.test(randomNumber0));
	}
}
