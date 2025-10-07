// Figure 9.14
package ch9.samples;

abstract class Job {
	abstract void start();
}

// when a non-abstract class extends an abstract class, it must implement the abstract class's abstract methods.
// class Retail extends Job {}

// when an abstract class extends another abstract class, 
// the abstract superclass's abstract methods don't have to be implemented immediately
abstract class Teaching extends Job {}

class Engineering extends Job {
	@Override
	void start() {
		System.out.println("Engineering::start()");
	}
}

public class AbstractKeyword {
	public static void main(String[] args) {
		// Job job = new Job(); // Can't instantiate an abstract class
		Job job = new Engineering();
		job.start();
	}
}
