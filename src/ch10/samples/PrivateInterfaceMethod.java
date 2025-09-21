// Figure 10.8, 10.9 & 10.10
package ch10.samples;

interface ArithmeticMean {
	static double average(double... numbers) {
		return sum(numbers) / numbers.length;
	}

	private static double sum(double[] values) {
		double total = 0.0;
		
		for(double number : values) {
			total += number;
		}

		return total;
	}
}

public class PrivateInterfaceMethod {
	public static void main(String[] args) {
		System.out.println(ArithmeticMean.average(3, -7, 6, 12, -2));
		System.out.println(ArithmeticMean.average(5.5, 5.3, 5.7, 5.9, 6, 5.10, 5.8, 5.6, 5.4, 6));
	}
}
