// LinkedList, PriorityQueue, ArrayDeque, BlockingQueue, LinkedBlockingQueue & FixedSizeQueue (custom queue)
package ch13.samples;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Task {
	String name;
	int priority;  
	
	Task(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	@Override
	public String toString() { 
		return this.name + " (#" + this.priority + ")"; 
	}
}

class FixedSizeQueue<E> extends LinkedList<E> {
	private final int maxSize;

	FixedSizeQueue(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public boolean offer(E element) {
		if(size() >= this.maxSize) {
			System.out.println("Queue full -> " + element + " rejected");
			return false;
		}

		return super.offer(element);
	}
}

class BreadthFirstSearchGraph {
	public static void bfs(Map<Integer, List<Integer>> graph, int start) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.offer(start);
		visited.add(start);

		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for(int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
				if(!visited.contains(neighbor)) {
					queue.offer(neighbor);
					visited.add(neighbor);
				}
			}
		}
	}
}

class Producer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for(int i = 1; i <= 5; i++) {
				this.queue.put(i);
				System.out.println("produced -> " + i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}		
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while(true) {
				int value = this.queue.take();
				System.out.println("consumed -> " + value);
			}
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> orders = new LinkedList<>();

		orders.offer("Latte");
    orders.offer("Espresso");
    orders.offer("Cappuccino");

		System.out.println(
			"orders -> " + orders + 
			" | serving -> " + orders.poll() + 
			" | next in line -> " + orders.peek() +
			" | serving -> " + orders.poll() +
			" | remaining -> " + orders
		);

		if(orders.offer("Mocha")) {
			System.out.println("current orders -> " + orders);
		}

		while(!orders.isEmpty()) {
			System.out.println("serving -> " + orders.poll());
		}

		System.out.println("current orders -> " + orders);

		System.out.println("-----------------------------------------------------------");

		Queue<Task> tasks0 = new PriorityQueue<>((t0, t1) -> t0.priority - t1.priority);

		tasks0.offer(new Task("t-0", new Random().nextInt(4 - 1) + 1));
    tasks0.offer(new Task("t-1", new Random().nextInt(4 - 1) + 1));
    tasks0.offer(new Task("t-2", new Random().nextInt(4 - 1) + 1));

		while(!tasks0.isEmpty()) {
			System.out.println("processing task -> " + tasks0.poll());
		}

		System.out.println("-----------------------------------------------------------");

		Deque<Task> tasks1 = new ArrayDeque<>();

		tasks1.offer(new Task("t-3", new Random().nextInt(4 - 1) + 1));
    tasks1.offer(new Task("t-4", new Random().nextInt(4 - 1) + 1));
    tasks1.offer(new Task("t-5", new Random().nextInt(4 - 1) + 1));
		System.out.println("tasks1 -> " + tasks1 + " | tasks1.poll() -> " + tasks1.poll());
		
		tasks1.push(new Task("t-6", new Random().nextInt(4 - 1) + 1));
		System.out.println("tasks1 -> " + tasks1 + " | tasks1.pop() -> " + tasks1.pop());

		System.out.println("-----------------------------------------------------------");
		
		Queue<String> fixedQueue = new FixedSizeQueue<>(2);

		fixedQueue.offer("doc #1");
		fixedQueue.offer("doc #2");
		System.out.println("fixedQueue -> " + fixedQueue);

		if(fixedQueue.offer("doc #3")) {
			System.out.println("fixedQueue -> " + fixedQueue);
		}

		System.out.println("fixedQueue.poll() -> " + fixedQueue.poll());

		if(fixedQueue.offer("doc #3")) {
			System.out.println("fixedQueue -> " + fixedQueue);
		}

		System.out.println("-----------------------------------------------------------");

		Map<Integer, List<Integer>> graph = new HashMap<>();

		graph.put(1, Arrays.asList(2, 3));
		graph.put(2, Arrays.asList(4, 5));
		graph.put(3, Arrays.asList(6, 7));

		BreadthFirstSearchGraph.bfs(graph, 1);

		System.out.println("\n-----------------------------------------------------------");

		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);

		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}
