// Examining List and ArrayList - pg 339
package ch12.samples;

import java.util.ArrayList;
import java.util.List;

public class ListArrayListDemo {
	// List properties | Figure 12.19 | pg 339
	private static void listElements() {
		List<String> list = new ArrayList<>();
		list.add("J");
    list.add("A");
    list.add("V");
    list.add("A");
    System.out.println(list);
        
		list.add(1,"O");
    list.add(3,"O");
    System.out.println(list);
	}

	// Figure 12.20 - pg 340
	private static void listAPI() {
		List<String> list = new ArrayList<>();
    list.add("Joe"); 
		list.add("Mary"); 
		list.add("Joe");
    System.out.println(
			"list => " + list +
			" | list.contains(\"Mary\") => " + list.contains("Mary") +
			" | list.get(0) => " + list.get(0) +
			" | list.indexOf(2) => " + list.indexOf(2) +
			" | list.indexOf(\"Joe\") => " + list.indexOf("Joe") +
			" | list.remove(\"Joe\") => " + list.remove("Joe") +
			" | list => " + list
		); 
    list.remove(0);
    System.out.println("list.remove(0) | list => " + list);                   
    list.set(0, "Paul");
    System.out.println("list.set(0, \"Paul\") | list => " + list);
	}

	public static void main(String[] args) {
		listElements();
		System.out.println("-----------------------------------------------------------");
		listAPI();
	}
}
