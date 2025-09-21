/*
- All of our dinosaurs are unique. Okay, we cloned their DNA, but still. Let’s say they have unique personalities. 
- That’s why the IDs of all our dinosaurs are unique too: they are called dino1, dino2, dino3, and so on. 
- Write a for loop that prints out the IDs of the first 100 dinosaurs in the park.
*/
package ch5.exercises;

public class E5_1 {
	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			System.out.println("dino" + i);
		}
	}
}
