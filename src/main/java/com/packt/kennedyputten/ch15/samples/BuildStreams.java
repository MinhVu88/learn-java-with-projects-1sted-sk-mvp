// Figure 15.6 - pg 436
package ch15.samples;

import java.util.stream.Stream;

class Animal {
	private String species, color;
	public Animal(){}
	public Animal(String species, String color) {
		this.species = species;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Animal species: " + species + " | color: " + color;
	}
}

public class BuildStreams {
	public static void main(String[] args) {
		String[] cities = {"Tokyo", "Munich", "Tehran"};
		Stream<String> streamedCities = Stream.of(cities);
		System.out.println("number of streamed cities: " + streamedCities.count());

		Stream<Integer> streamedNumbers = Stream.of(1, 2, 3);
		System.out.println("number of streamed numbers: " + streamedNumbers.count());

		Stream<String> streamedLetters = Stream.of("a", "b", "c", "d");
		System.out.println("number of streamed letters: " + streamedLetters.count());

		Stream<Animal> streamedAnimals = Stream.of(new Animal(), new Animal(), new Animal());
		System.out.println("number of streamed Animal instances: " + streamedAnimals.count());
	}
}
