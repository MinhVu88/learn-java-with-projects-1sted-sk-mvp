package ch15.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Vehicle {
  private String type;
  private int productionYear;
  public Vehicle(String type, int productionYear) {
    this.type = type;
    this.productionYear  = productionYear;
  }
  public String getType() {
    return this.type;
  }
	public int getProductionYear() {
		return this.productionYear;
	}
}

public class CollectorsExamples {
	// Figure 15.20 - pg 452
	public static void collectCollectorsJoining() {
		String values = Stream.of(
			"Neo", "Trinity", 
			"Morpheus", "Agent Smith", 
			"The Oracle", "The Architect").collect(Collectors.joining(", "));
		System.out.println("collectCollectorsJoining() => " + values);	
	}

	// Figure 15.21 - pg 452
	public static void collectCollectorsAveragingInt() {
		Double averageWordLength = Stream.of(
			"armchair", "lamp", "coffee table", "bookshelf", "table"
		).collect(Collectors.averagingInt(word -> word.length()));
		System.out.println("collectCollectorsAveragingInt() => " + averageWordLength);
	}

	// Figures 15.22 & 15.23 - pg 453
	public static void collectCollectorsToList() {
		var vehicles = new ArrayList<Vehicle>();
    vehicles.add(new Vehicle("car", 2021));
    vehicles.add(new Vehicle("train", 2022));
    vehicles.add(new Vehicle("motorbike", 2018));

		List<String> vehicleTypes = vehicles
			.stream()
			.map(vehicle -> vehicle.getType())
			.collect(Collectors.toList());
		System.out.println("collectCollectorsToList() => " + vehicleTypes);
	}

	// Figure 15.24 - pg 454
	public static void collectCollectorsToCollection() {
		var vehicles = new ArrayList<Vehicle>();
    vehicles.add(new Vehicle("car", 2021));
    vehicles.add(new Vehicle("train", 2022));
    vehicles.add(new Vehicle("motorbike", 2018));

		Set<Integer> productionYears = vehicles
			.stream()
			.map(v -> v.getProductionYear())
			.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("collectCollectorsToCollection() => " + productionYears);
	}
 
	public static void collectCollectorsToMap() {
		// Figure 15.25 - pg 455 
		Map<String, Integer> mappedValues0 = Stream
			.of("wolf", "shark", "gold fish")
			.collect(
				// Collectors.toMap(val -> val, val -> val.length())
				Collectors.toMap(String::toString, String::length)
		);
		System.out.println(
			"collectCollectorsToMap()" + 
			"\n- mappedValues0 => " + mappedValues0
		);
		
		// Figure 15.26 - pg 456
		try {
			Map<Integer, String> mappedValues1 = Stream
				.of("Luke", "Kathleen", "Kurt")
				.collect(Collectors.toMap(String::length, String::toString));
			System.out.println(mappedValues1);	
		} catch(IllegalStateException e) {
			System.out.println("- mappedValues1 => " + e.getMessage());
		}

		// Figure 15.27 - pg 456
		Map<Integer, String> mappedValues2 = Stream
			.of("Luke", "Kathleen", "Kurt")
			.collect(Collectors.toMap(
				key -> key.length(),
				val -> val,
				(v0, v1) -> v0 + ", " + v1
		));
		System.out.println("- mappedValues2 => " + mappedValues2);

		// Figure 15.28 - pg 457
		TreeMap<String, Integer> mappedValues3 = Stream
			.of("Luke", "Kathleen", "Kurt")
			.collect(Collectors.toMap(
				String::toString,
				String::length,
				(length0, length1) -> length0 + length1,
				TreeMap::new
		));
		System.out.println(
			"- mappedValues3 => " + mappedValues3 +
			" | mappedValues3.getClass() => " + mappedValues3.getClass()
		);
	}

	public static void collectCollectorsGroupingBy() {
		// Figure 15.29 - pg 458
		Stream<String> names0 = Stream.of("Martin", "Peter", "Tom", "Tom", "Ann");
		Map<Integer, List<String>> mappedNames0 = names0.collect(Collectors.groupingBy(String::length));
		System.out.println(
			"collectCollectorsGroupingBy()" + 
			"\n- mappedNames0 => " + mappedNames0
		);

		// Figure 15.30 - pg 459
		Stream<String> names1 = Stream.of("Martin", "Peter", "Tom", "Tom", "Ann");
		Map<Integer, Set<String>> mappedNames1 = names1.collect(
			Collectors.groupingBy(String::length, Collectors.toSet())
		);
		System.out.println(
			"- mappedNames1 => " + mappedNames1 +
			" | mappedNames1.getClass() => " + mappedNames1.getClass()
		);

		// Figure 15.31 - pg 460
		Stream<String> names2 = Stream.of("Martin", "Peter", "Tom", "Tom", "Ann");
		Map<Integer, List<String>> mappedNames2 = names2.collect(
			Collectors.groupingBy(
				String::length,
				TreeMap::new,
				Collectors.toList()
			)
		);
		System.out.println(
			"- mappedNames2 => " + mappedNames2 +
			" | mappedNames2.getClass() => " + mappedNames2.getClass()
		);
	}

	public static void collectCollectorsPartitioningBy() {
		// Figure 15.32 - pg 461
		Stream<String> users0 = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
		Map<Boolean, List<String>> mappedUsers0 = users0.collect(
			Collectors.partitioningBy(username -> username.startsWith("T"))
		);
		System.out.println(
			"collectCollectorsPartitioningBy()" +
			"\n- mappedUsers0 => " + mappedUsers0
		);
		
		// Figure 15.33 - pg 462
		Stream<String> users1 = Stream.of("Alan", "Teresa", "Mike", "Alan", "Peter");
		Map<Boolean, Set<String>> mappedUsers1 = users1.collect(
			Collectors.partitioningBy(
				username -> username.length() > 4,
				Collectors.toSet()
			)
		);
		System.out.println("- mappedUsers1 => " + mappedUsers1);
	}

	public static void main(String[] args) {
		collectCollectorsJoining();
		System.out.println("-----------------------------------------------------------");
		collectCollectorsAveragingInt();
		System.out.println("-----------------------------------------------------------");
		collectCollectorsToList();
		System.out.println("-----------------------------------------------------------");
		collectCollectorsToCollection();
		System.out.println("-----------------------------------------------------------");
		collectCollectorsToMap();
		System.out.println("-----------------------------------------------------------");
		collectCollectorsGroupingBy();
		System.out.println("-----------------------------------------------------------");
		collectCollectorsPartitioningBy();
	}
}
