// Figure 9.15
package ch9.samples;

final class Death {}

// class Afterlife extends Death {} // can't extend a 'final' class

class Food {
	// 'final' & 'abstract' not allowed together.
	// An abstract method is to be overridden/implemented in a subclass.
	// A final method must not be overridden.
	// final abstract expire();

	final void expire() {}
}

class Pizza extends Food {
	// can't override a final method
	// @Override
	// void expire() {}
}

public class FinalKeyword {
	final int DAYS_PER_WEEK = 7;

	void demo(final String val0, final int val1) {
		// The final local variable val1 cannot be assigned. 
		// It must be blank and not using a compound assignment
		// val1 = val1 + DAYS_PER_WEEK;

		// same error as above
		// val0 = "eyyo wassup dude";

		// but it's ok to access a final object reference
		System.out.println(val0.toUpperCase());

		// can't modify a constant
		// DAYS_PER_WEEK = 8;
	}
}
