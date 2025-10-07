// Figure 14.1
package ch14.samples;

@FunctionalInterface
interface FunctionalInterfaceDemo {
	void getTheOnlyAbstractMethod();

	default void getDefaultMethod0() {
		System.out.println("getDefaultMethod0() | FunctionalInterfaceDemo");
	}

	default void getDefaultMethod1() {
		System.out.println("getDefaultMethod1() | FunctionalInterfaceDemo");
	}

	static void getStaticMethod0() {
		System.out.println("getStaticMethod0() | FunctionalInterfaceDemo");
	}

	static void getStaticMethod1() {
		System.out.println("getStaticMethod1() | FunctionalInterfaceDemo");
	}
}

public class BasicLambdas0 {
	public static void main(String[] args) {
		FunctionalInterfaceDemo lambda0 = () -> {
			System.out.println("lambda0 | getTheOnlyAbstractMethod() | FunctionalInterfaceDemo");
		};

		lambda0.getTheOnlyAbstractMethod();
		lambda0.getDefaultMethod0();
		FunctionalInterfaceDemo.getStaticMethod0();

		FunctionalInterfaceDemo lambda1 = () -> System.out.println("lambda1 | getTheOnlyAbstractMethod() | FunctionalInterfaceDemo");
		
		lambda1.getTheOnlyAbstractMethod();
		lambda1.getDefaultMethod1();
		FunctionalInterfaceDemo.getStaticMethod1();
	}
}
