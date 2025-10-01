// HashMap, TreeMap & LinkedHashMap
package ch13.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class LeastRecentlyUsedCache1<K, V> extends LinkedHashMap<K, V> {
	private final int capacity;

	public LeastRecentlyUsedCache1(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > this.capacity;
	}
}

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer, String> hashMap0 = new HashMap<>();
		TreeMap<Integer, String> treeMap0 = new TreeMap<>();
		Map<Integer, String> linkedHashMap0 = new LinkedHashMap<>();

		for(Map<Integer, String> map : Arrays.asList(hashMap0, treeMap0, linkedHashMap0)) {
			map.put(7, "seven");
			map.put(4, "four");
			map.put(2, "two");
			map.put(5, "five");
			map.put(0, "zero");
			map.put(3, "three");
			map.put(6, "six");
			map.put(1, "one");
		}

		for(Map<Integer, String> map : Arrays.asList(hashMap0, treeMap0, linkedHashMap0)) {
			System.out.println(map.getClass().getSimpleName() + " -> " + map);
		}

		System.out.println("-----------------------------------------------------------");

		Map<String, Integer> hashMap1 = new HashMap<>();

		hashMap1.put("Bastardometer", 27);
		hashMap1.put("Membranophones", 0);
		hashMap1.put("Möstresticator", -9999);
		hashMap1.put("Bottom Feeder", 3);

		System.out.println(new TreeMap<>(hashMap1)); // HashMap sorted by keys

		List<Map.Entry<String, Integer>> list0 = new ArrayList<>(hashMap1.entrySet());
		list0.sort(Map.Entry.comparingByValue());
		Map<String, Integer> hashMap1SortedByValues = new LinkedHashMap<>();

		for(Map.Entry<String, Integer> entry : list0) {
			hashMap1SortedByValues.put(entry.getKey(), entry.getValue());
		}

		System.out.println(hashMap1SortedByValues);

		System.out.println("-----------------------------------------------------------");

		System.out.println(
			"key(s) < 0 -> " + treeMap0.headMap(0) + 
			" | key(s) >= 8 " + treeMap0.tailMap(8) + 
			" | 3 <= key(s) < 7 -> " + treeMap0.subMap(3, 7)
		);

		System.out.println("-----------------------------------------------------------");

		Map<Integer, String> treeMap1 = new TreeMap<>(Collections.reverseOrder());

    treeMap1.put(3, "C");
    treeMap1.put(27, "D");
    treeMap1.put(0, "B");
    treeMap1.put(-9999, "A");
    System.out.println(treeMap1);

		System.out.println("-----------------------------------------------------------");

		String[] members = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice"};

		Map<String, Integer> hashMap2 = new HashMap<>();

		for(String member : members) {
			hashMap2.put(
				member, 
				hashMap2.getOrDefault(member, 0) + 1
			);
		}
		
		String mostValuedMember = hashMap2.entrySet()
														.stream()
														.max(Map.Entry.comparingByValue())
														.map(Map.Entry::getKey)
														.orElse("none");
		
		System.out.println(
			"hashMap2 | members (unordered) -> " + hashMap2 + 
			" | most valued member -> " + mostValuedMember
		);
		
		TreeMap<String, Integer> treeMap2 = new TreeMap<>();

		for(String member : members) {
			treeMap2.put(
				member, 
				treeMap2.getOrDefault(member, 0) + 1
			);
		}
		
		System.out.println(
			"treeMap2 | members (sorted by keys) -> " + treeMap2 + 
			" | 1st member -> " + treeMap2.firstKey()
		);

		Map<String, Integer> linkedHashMap1 = new LinkedHashMap<>();
		
		for(String member : members) {
			linkedHashMap1.put(
				member, 
				linkedHashMap1.getOrDefault(member, 0) + 1
			);
		}
		
		System.out.println(
			"linkedHashMap1 | members (retained insertion order) -> " + 
			linkedHashMap1.keySet()
		);

		System.out.println("-----------------------------------------------------------");

		System.out.println("hashMap2 | Charlie before merge -> " + hashMap2.get("Charlie"));
		hashMap2.merge("Charlie", 2, (_, newVal) -> newVal);
		System.out.println("hashMap2 | Charlie after merge -> " + hashMap2.get("Charlie"));

		System.out.println("\ntreeMap2 | Alice before merge -> " + treeMap2.get("Alice"));
		treeMap2.merge("Alice", 1, (_, newVal) -> newVal);
		System.out.println("treeMap2 | Alice after merge -> " + treeMap2.get("Alice"));

		System.out.println("\nlinkedHashMap1 | Bob before merge -> " + linkedHashMap1.get("Bob"));
		linkedHashMap1.merge("Bob", 0, (_, newVal) -> newVal);
		System.out.println("linkedHashMap1 | Bob after merge -> " + linkedHashMap1.get("Bob"));

		System.out.println("-----------------------------------------------------------");

		LeastRecentlyUsedCache1<Integer, String> cache = new LeastRecentlyUsedCache1<>(3);
		
		cache.put(1, "One");
    cache.put(2, "Two");
    cache.put(3, "Three");
    System.out.println(cache);

    cache.get(2);
    cache.put(4, "Four");
    System.out.println(cache);

		System.out.println("-----------------------------------------------------------");

		Map<Person0, String> employees0 = new HashMap<>();
		Map<Person0, String> employees1 = new TreeMap<>(Comparator.comparingInt(p -> p.id()));
		Map<Person0, String> employees2 = new LinkedHashMap<>();

		for(Map<Person0, String> lumonIndustries : Arrays.asList(employees0, employees1, employees2)) {
			lumonIndustries.put(new Person0(40, "Harmony Cobel"), "manager");
			lumonIndustries.put(new Person0(27, "Mark Scout"), "engineer");
			lumonIndustries.put(new Person0(25, "Helena Eagan"), "accountant");
			lumonIndustries.put(new Person0(27, "Mark Scout"), "engineer");
			lumonIndustries.put(new Person0(40, "Harmony Cobel"), "manager");
		}

		for(Map<Person0, String> innies : Arrays.asList(employees0, employees1, employees2)) {
			System.out.println("\n" + innies.getClass().getSimpleName() + " ->");
			for(Map.Entry<Person0, String> innie : innies.entrySet()) {
				System.out.println(
					"\t. name: " + innie.getKey().name() + 
					" | id: " + innie.getKey().id() + 
					" | role: " + innie.getValue()
				);
			}
		}
	}
}
