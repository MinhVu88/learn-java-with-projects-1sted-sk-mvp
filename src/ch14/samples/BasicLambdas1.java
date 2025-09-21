// Figure 14.2 
package ch14.samples;

interface Evaluation<T> {
	boolean check(T t);
}

public class BasicLambdas1 {
	public static void main(String[] args) {
		Evaluation<Integer> isWholeNumber = (Integer number) -> number >= 0;
		System.out.println(isWholeNumber.check(-1) + " | " + isWholeNumber.check(0));

		Evaluation<String> isMale = honorific -> honorific.startsWith("Mr.");
		System.out.println(isMale.check("Mr. Smith") + " | " + isMale.check("Mrs. Smith"));
	}
}
