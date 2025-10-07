// Creating and throwing custom exceptions - pg 301
package ch11.samples;

public class InvalidAgeException extends Exception {
	public InvalidAgeException() {
		super();
	}

	public InvalidAgeException(String message) {
		super(message);
	}

	public InvalidAgeException(Exception e) {
		super(e);
	}
}
