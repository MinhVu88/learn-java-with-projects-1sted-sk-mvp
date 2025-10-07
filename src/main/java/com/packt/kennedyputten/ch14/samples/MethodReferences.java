// Figures 14.11 (Bound), 14.12 (Unbound), 14.13 (Static) & 14.14 (Constructor) - pgs 415, 417, 418 & 419
// Figure 14.15 (Method references & context) - pg 421
package ch14.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
	public static void main(String[] args) {
		// BOUND
		String name = "Walter Hartwell White Sr.";
		Supplier<String> boundMethodRef = name::toUpperCase;
		System.out.println("Bound => " + boundMethodRef.get()); 

		// UNBOUND
		Function<String, Integer> unboundMethodRef0 = String::length;
		System.out.println("Unbound0 => " + unboundMethodRef0.apply(boundMethodRef.get()));

		BiFunction<String, String, Integer> unboundMethodRef1 = String::compareToIgnoreCase;
		System.out.println("Unbound1 => " + unboundMethodRef1.apply(name, boundMethodRef.get()));

		// STATIC
		Function<String, Integer> staticMethodRef = Integer::parseInt;
		System.out.println(
			"Static => " + staticMethodRef.apply(
				String.valueOf(
					unboundMethodRef0.apply(boundMethodRef.get())
				)
			)
		);

		// CONSTRUCTOR
		Supplier<List<String>> constructorMethodRef0 = ArrayList::new;
		List<String> names = constructorMethodRef0.get();
		names.add(name);
		names.add("Jesse Pinkman");
		names.add("Gus Fring");
		System.out.println("constructor0 => " + names);

		Function<String, StringBuilder> constructorMethodRef1 = StringBuilder::new;
		System.out.println("constructor1 => " + constructorMethodRef1.apply(name).reverse());

		// METHOD REFERENCES & CONTEXT
		Supplier<Integer> methodRefsCtx0 = () -> User1.countInstances();
		Supplier<Integer> methodRefsCtx1 = User1::countInstances;
		System.out.println(
			"methodRefsCtx0.get() => " + methodRefsCtx0.get() + 
			" | methodRefsCtx1.get() => " + methodRefsCtx1.get()
		);

		Function<User1, Integer> methodRefsCtx2 = user -> User1.countInstances(user);
		Function<User1, Integer> methodRefsCtx3 = User1::countInstances;
		System.out.println(
			"methodRefsCtx2.apply(new User1()) => " + methodRefsCtx2.apply(new User1()) + 
			" | methodRefsCtx3.apply(new User1()) => " + methodRefsCtx3.apply(new User1())
		);

		BiFunction<User1, User1, Integer> methodRefsCtx4 = (user0, user1) -> User1.countInstances(user0, user1);
		BiFunction<User1, User1, Integer> methodRefsCtx5 = User1::countInstances;
		System.out.println(
			"methodRefsCtx4.apply(new User1(), new User1()) => " + methodRefsCtx4.apply(new User1(), new User1()) + 
			" | methodRefsCtx5.apply(new User1(), new User1()) => " + methodRefsCtx5.apply(new User1(), new User1())
		);
	}
}