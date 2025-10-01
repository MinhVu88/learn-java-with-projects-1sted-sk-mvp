// Figure 10.6
package ch10.samples;

interface Arithmetic {
	static int add(int val0, int val1) {
		return val0 + val1;
	}
}

public class StaticInterfaceMethod {
	public static void main(String[] args) {
		System.out.println(Arithmetic.add(3, 4));
	}
}
