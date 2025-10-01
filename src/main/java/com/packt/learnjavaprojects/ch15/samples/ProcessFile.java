// Streaming from a file - pg 438
package ch15.samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProcessFile {
	public static List<Animal> listAnimals(String filename) {
		List<Animal> animalsList = new ArrayList<>();

		try(
			Stream<String> streamedFileLines = Files.lines(Paths.get(filename))
		) {
			streamedFileLines.forEach(line -> {
				String[] animalsArray = line.split("/");
				
				animalsList.add(new Animal(
					animalsArray[0],
					animalsArray[1]
				));
			});
		} catch(IOException e) {
			e.printStackTrace();
		}

		return animalsList;
	}

	public static void main(String[] args) {
		List<Animal> animals = listAnimals("src\\ch15\\samples\\animals.txt");
		animals.forEach(System.out::println);
	}
}
