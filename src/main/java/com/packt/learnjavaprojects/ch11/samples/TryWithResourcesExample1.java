// Implementing the AutoCloseable interface - pg 308
package ch11.samples;

class SomeResource implements AutoCloseable {
	public void utilize() {
		System.out.println("resource utilized");
	}

	@Override
	public void close() {
		System.out.println("resource closed");
	}
}

public class TryWithResourcesExample1 {
	public static void main(String[] args) {
		try(SomeResource resource = new SomeResource()) {
			resource.utilize();
		}
	}
}
