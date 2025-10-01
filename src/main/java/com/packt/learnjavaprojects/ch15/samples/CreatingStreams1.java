// Figure 15.5 - pg 435
package ch15.samples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CreatingStreams1 {
	public static void main(String[] args) {
		List<String> animals = Arrays.asList("dog", "cat", "sheep");
		Stream<String> streamedAnimals = animals.stream();
		System.out.println("number of 'animals' elements: " + streamedAnimals.count());

		Map<String, Integer> profiles = new HashMap<>();
		profiles.put("Angela Moss", 20);
		profiles.put("Tyrell Wellick", 23);
		profiles.put("Krista Gordon", 27);
		System.out.println("number of profiles: " + profiles.entrySet().stream().count());
	}
}
