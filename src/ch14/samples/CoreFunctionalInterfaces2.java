// Figures 14.6 & 14.7 (Consumer & BiConsumer) - pgs 407 & 408
package ch14.samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class CoreFunctionalInterfaces2 {
	public static void main(String[] args) {
		Consumer<String> consumerDemo0 = str -> System.out.println(str);
		consumerDemo0.accept("consumerDemo0"); 

		List<String> names = new ArrayList<>(List.of("maynard", "adam", "danny"));
		
		Consumer<List<String>> consumerDemo1 = list -> {
			for(int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i).toUpperCase());
			}
		};

		consumerDemo1.accept(names);
		System.out.println("consumerDemo1 => " + names);

		Consumer<String> greet = name -> System.out.print("consumerDemo2 => Bonsoir, " + name);
		Consumer<String> getInfo = id -> {
			id = "ER28-0652";
			System.out.println(" (employee number: " + id + ")");
		};
		Consumer<String> consumerDemo2 = greet.andThen(getInfo);
		consumerDemo2.accept("Elliot");

		DoubleConsumer consumerDemo3 = val -> System.out.println("consumerDemo3 => " + val);
		consumerDemo3.accept(Math.PI);

		System.out.println("-----------------------------------------------------------");

		Map<String, Integer> cities = new HashMap<>();

		BiConsumer<String, Integer> biConsumerDemo0 = (key, value) -> cities.put(key, value);

		biConsumerDemo0.accept("Osaka", 5300016);
		biConsumerDemo0.accept("Munich", 80333);
		biConsumerDemo0.accept("Münster", 48143);
		System.out.println("biConsumerDemo0 => " + cities);

		BiConsumer<String, Integer> biConsumerDemo1 = (city, zipcode) -> System.out.println(
			"biConsumerDemo1 => city: " + city + " | zipcode: " + zipcode
		);

		cities.forEach(biConsumerDemo1);

		BiConsumer<String, Integer> biConsumerDemo2 = biConsumerDemo0.andThen(biConsumerDemo1);
		biConsumerDemo2.accept("Tokyo", 1000000);
	}
}
