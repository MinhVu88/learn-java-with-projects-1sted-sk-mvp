// Figure 14.8 (Function & BiFunction) - pg 410
package ch14.samples;

import java.util.function.BiFunction;
import java.util.function.Function;

class User1 {
  String name, email;

	public User1() {}
    
  public User1(String name, String email) {
    this.name = name;
    this.email = email;
  }

	public static Integer countInstances(User1... instances) {
		return instances.length;
	}
}

public class CoreFunctionalInterfaces3 {
	public static void main(String[] args) {
		Function<String, Integer> functionDemo0 = str -> str.length();
		System.out.println("functionDemo0 => " + functionDemo0.apply("functionDemo0"));
		
		Function<Double, Double> functionDemo1 = celsius -> (celsius * 9 / 5) + 32;
		System.out.println("functionDemo1 | 25.0 Celsius => " + functionDemo1.apply(25.0) + " Fahrenheit");

		Function<Integer, Integer> functionDemo2 = val -> val * 2;
		Function<Integer, Integer> functionDemo3 = val -> val + 10;
		Function<Integer, Integer> functionDemo4 = functionDemo2.andThen(functionDemo3);
		System.out.println("functionDemo4 | andThen() | (3 * 2) + 10 => " + functionDemo4.apply(3));
		
		Function<Integer, Integer> functionDemo5 = functionDemo3.compose(functionDemo2);
		System.out.println("functionDemo5 | compose() | (3 * 2) + 10 => " + functionDemo5.apply(3));

		System.out.println("-----------------------------------------------------------");

		BiFunction<Integer, Integer, Integer> biFunctionDemo0 = (val0, val1) -> val0 + val1;
		System.out.println("biFunctionDemo0 => " + biFunctionDemo0.apply(10, 20));
		
		BiFunction<String, String, String> biFunctionDemo1 = (firstName, lastName) -> firstName + " " + lastName;
		System.out.println("biFunctionDemo1 => " + biFunctionDemo1.apply("Darlene", "Alderson"));

		biFunctionDemo1 = biFunctionDemo1.andThen(emp -> "name | id => " + emp);
		System.out.println(biFunctionDemo1.apply("Elliot Alderson", "| ER28-0652"));

		System.out.println("-----------------------------------------------------------");

		BiFunction<String, String, User1> biFunctionDemo2 = User1::new;
		User1 newUser = biFunctionDemo2.apply("Angela Moss", "angelamoss@ecorp.com");
		System.out.println("biFunctionDemo2 => " + newUser.name + " | " + newUser.email);
	}
}
