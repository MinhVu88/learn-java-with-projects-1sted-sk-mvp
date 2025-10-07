// Figures 14.9 & 14.10 (UnaryOperator & BinaryOperator) - pgs 412 & 413  
package ch14.samples;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CoreFunctionalInterfaces4 {
	public static void main(String[] args) {
		UnaryOperator<String> unaryOperatorDemo0 = str -> str.toUpperCase();
		System.out.println("unaryOperatorDemo0 | tokyo => " + unaryOperatorDemo0.apply("tokyo"));

		UnaryOperator<Integer> unaryOperatorDemo1 = val -> val + 1;
		System.out.println("unaryOperatorDemo1 | 7 + 1 => " + unaryOperatorDemo1.apply(7));

		UnaryOperator<String> unaryOperatorDemo2 = str -> str.trim().toLowerCase();
		System.out.println("'     UNARYOPERATORDEMO2     ' => " + unaryOperatorDemo2.apply("     UNARYOPERATORDEMO2     "));

		UnaryOperator<String> unaryOperatorDemo3 = str -> new StringBuilder(str).reverse().toString();
		Function<String, String> unaryOperatorDemo4 = unaryOperatorDemo2.andThen(unaryOperatorDemo3);
		System.out.println("'     UNARYOPERATORDEMO4     ' => " + unaryOperatorDemo4.apply("     UNARYOPERATORDEMO4     "));

		System.out.println("-----------------------------------------------------------");

		BinaryOperator<Integer> binaryOperatorDemo0 = (val0, val1) -> val0 + val1;
		System.out.println("binaryOperatorDemo0 | 3 + 4 => " + binaryOperatorDemo0.apply(3, 4));

		BinaryOperator<String> binaryOperatorDemo1 = (str0, str1) -> str0.length() > str1.length() ? str0 : str1;
		System.out.println("binaryOperatorDemo1 => " + binaryOperatorDemo1.apply("str", "string"));

		BinaryOperator<String> binaryOperatorDemo2 = BinaryOperator.minBy(
			Comparator.comparingInt(String::length)
		);
		System.out.println("binaryOperatorDemo2 => " + binaryOperatorDemo2.apply("plane", "planet"));

		BinaryOperator<Integer> binaryOperatorDemo3 = BinaryOperator.maxBy(Integer::compareTo);
		System.out.println("binaryOperatorDemo3 => " + binaryOperatorDemo3.apply(3, 4));
	}
}
