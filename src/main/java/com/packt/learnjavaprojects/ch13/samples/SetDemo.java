// HashSet, TreeSet & LinkedHashSet
package ch13.samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Person1 {}

class Person2 implements Comparable<Person2> {
	private String name;
	private double salary;

	public Person2(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int compareTo(Person2 other) {
		int salaryComparator = Double.compare(this.salary, other.salary);
		return (salaryComparator == 0) ? this.name.compareToIgnoreCase(other.name) : salaryComparator;
	}

	@Override
	public String toString() {
		return this.name + " ($" + this.salary + ")";
	}
}

class LeastRecentlyUsedCache0 {
	private final int capacity;
	private final LinkedHashSet<Integer> cache;

	public LeastRecentlyUsedCache0(int capacity) {
		this.capacity = capacity;
		this.cache = new LinkedHashSet<>();
	}

	public LinkedHashSet<Integer> getCache() {
		return this.cache;
	}

	public void access(int key) {
		if(this.cache.contains(key)) {
			this.cache.remove(key);
		} else if(this.cache.size() == this.capacity) {
			Iterator<Integer> cacheIterator = this.cache.iterator();
			cacheIterator.next();
			cacheIterator.remove();
		}

		this.cache.add(key);
	}
}

public class SetDemo {
	public static void main(String[] args) {
		String sentence = "wait a minute wait a minute you ain't heard nothin' yet!";
		System.out.println("sentence -> " + sentence);

		Set<String> uniqueWords = new HashSet<>(Arrays.asList(sentence.split(" ")));
		System.out.println("uniqueWords -> " + uniqueWords);

		uniqueWords.remove("heard");
		System.out.println("'heard' in uniqueWords -> " + uniqueWords.contains("heard") + " -> " + uniqueWords);
		
		uniqueWords.clear();
		System.out.println("is uniqueWords empty? -> " + uniqueWords.isEmpty() + " -> " + uniqueWords);

		System.out.println("-----------------------------------------------------------");

		Set<Integer> intSet0 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
		Set<Integer> intSet1 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
		System.out.println("intSet0 -> " + intSet0 + " | intSet1 -> " + intSet1);

		Set<Integer> union = new HashSet<>(intSet0);
		union.addAll(intSet1);
		System.out.println("Union (intSet0 U intSet1) -> " + union);

		Set<Integer> intersection = new HashSet<>(intSet0);
		intersection.retainAll(intSet1);
		System.out.println("Intersection (intSet0 ∩ intSet1) -> " + intersection);
		
		Set<Integer> difference = new HashSet<>(intSet0);
		difference.removeAll(intSet1);
		System.out.println("Difference (intSet0 - intSet1) -> " + difference);

		Iterator<Integer> unionIterator = union.iterator();

		while(unionIterator.hasNext()) {
			if(unionIterator.next() % 2 == 0) {
				unionIterator.remove();
			}
		}

		System.out.println("Union (odd numbers only) -> " + union);

		System.out.println("-----------------------------------------------------------");

		Set<Integer> threadSafeSet = Collections.synchronizedSet(new HashSet<>(Arrays.asList(7, 8, 9, 10, 11)));

		synchronized(threadSafeSet) {
			for(int val : threadSafeSet) {
				System.out.println(val);
			}
		}

		System.out.println("-----------------------------------------------------------");

		// custom objects without hashCode() & equals()
		Set<Person1> employees0 = new HashSet<>();

		employees0.add(new Person1());
		employees0.add(new Person1());
		employees0.add(new Person1());
		employees0.add(new Person1());
		System.out.println("employees0 -> " + employees0 + " | employees0.size() -> " + employees0.size());

		// custom objects with hashCode() & equals()
		Set<Person0> employees1 = new HashSet<>();

		employees1.add(new Person0(1, "Gemma Scout"));
		employees1.add(new Person0(2, "Ricken Hale"));
		employees1.add(new Person0(3, "Miss Huang"));
		employees1.add(null);
		employees1.add(null);
		employees1.add(null);
		employees1.add(new Person0(1, "Gemma Scout"));
		employees1.add(new Person0(3, "Miss Huang"));
		System.out.println("employees1 -> " + employees1 + " | employees1.size() -> " + employees1.size());

		System.out.println("-----------------------------------------------------------");

		TreeSet<Double> temperatures = new TreeSet<>();

		temperatures.add(-4.9);
		temperatures.add(14.1);
		temperatures.add(23.6);
		temperatures.add(47.2);
		temperatures.add(-4.9);
		temperatures.add(7.5);
		temperatures.add(14.1);
		temperatures.add(23.6);
		temperatures.add(47.2);
		temperatures.add(36.7);
		temperatures.add(7.5);
		// temperatures.add(null); // java.lang.NullPointerException
		
		System.out.println(
			"temperatures -> " + temperatures +
			" | coldest -> " + temperatures.first() +
			" | hottest -> " + temperatures.last() +
			" | above 15 -> " + temperatures.tailSet(15.0) +
			" | below 20 -> " + temperatures.headSet(20.0) +
			" | between 0 & 40 -> " + temperatures.subSet(0.0, 40.0) +
			" | nearly 10 -> " + temperatures.lower(10.0) +
			" | nearly 40 -> " + temperatures.higher(30.0) +
			" | the smallest temp >= 10.0 -> " + temperatures.ceiling(10.0) +
			" | the largest temp <= 30.0 -> " + temperatures.floor(30.0) +
			" | 1st temp -> " + temperatures.pollFirst() +
			" | last temp -> " + temperatures.pollLast()
		);

		System.out.println("-----------------------------------------------------------");

		TreeSet<Integer> numbers = new TreeSet<>(Collections.reverseOrder());

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		System.out.println(numbers);

		System.out.println("-----------------------------------------------------------");

		Comparator<String> stringLengthComparator = (str0, str1) -> {
			int lengthComparator = Integer.compare(str0.length(), str1.length());
			if(lengthComparator == 0) return str0.compareToIgnoreCase(str1);
			return lengthComparator;
		};

		TreeSet<String> words = new TreeSet<>(stringLengthComparator);

		words.add("world");
		words.add("exciting");
		words.add("right");
		words.add("time");
		words.add("in");
		words.add("exciting");
		words.add("now");
		words.add("time");
		words.add("the");
		System.out.println(words);

		System.out.println("-----------------------------------------------------------");

		TreeSet<Person2> employees2 = new TreeSet<>();

		employees2.add(new Person2("Elliot Alderson", Math.PI));
		employees2.add(new Person2("Tyrell Wellick", 743.89));
		employees2.add(new Person2("Darlene Alderson", 392.31));
		employees2.add(new Person2("Elliot Alderson", Math.PI));
		employees2.add(new Person2("Angela Moss", 569.48));
		employees2.add(new Person2("Elliot Alderson", Math.PI));
		employees2.add(new Person2("Phillip Price", 120.97));
		employees2.add(new Person2("Elliot Alderson", Math.PI));
		System.out.println(employees2);

		System.out.println("-----------------------------------------------------------");

		LeastRecentlyUsedCache0 cache = new LeastRecentlyUsedCache0(3);
		
		cache.access(1);
		cache.access(2);
		cache.access(3);
		System.out.println(cache.getCache());
		
		cache.access(2);
		System.out.println(cache.getCache());

		cache.access(4);
		System.out.println(cache.getCache());
	}
}
