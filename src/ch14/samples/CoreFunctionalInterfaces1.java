// Figure 14.5 (Supplier) - pg 405
package ch14.samples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

class User0 {
  String name;
  public User0() {
    this.name = "Anonymous";
  }
}

public class CoreFunctionalInterfaces1 {
	// Retry utility using Supplier
	public static <T> T retry(int attempts, Supplier<T> supplier) {
		for(int i = 0; i < attempts; i++) {
			try {
				return supplier.get();
			} catch(Exception e) {
				System.out.println("failed attempt #" + (i + 1));
			}
		}

		throw new RuntimeException("all attempts failed");
	}

	public static void main(String[] args) {
		Supplier<String> supplierDemo0 = () -> "supplierDemo0";
		System.out.println(supplierDemo0.get());
		
		Supplier<LocalDateTime> supplierDemo1 = () -> LocalDateTime.now();
		System.out.println("supplierDemo1 => " + supplierDemo1.get());
		
		Supplier<Double> supplierDemo2 = () -> Math.random();
		System.out.println("supplierDemo2 => " + supplierDemo2.get());
		
		// DoubleSupplier - getAsDouble() | IntSupplier - getAsInt() | LongSupplier - getAsLong()
		BooleanSupplier supplierDemo3 = () -> LocalDate.now().isLeapYear();
		System.out.println("supplierDemo3 => " + supplierDemo3.getAsBoolean());

		System.out.println("-----------------------------------------------------------");

		// Custom Object Factory
		Supplier<User0> supplierDemo4 = () -> new User0();
		User0 user = supplierDemo4.get();
		System.out.println("supplierDemo4 => " + user.name);

		System.out.println("-----------------------------------------------------------");

		// Use case: Retry Logic or Deferred Execution
		Supplier<String> supplierDemo5 = () -> "heavy/expensive/slow operation";
		System.out.println("supplierDemo5 => " + retry(3, supplierDemo5));
	}
}
