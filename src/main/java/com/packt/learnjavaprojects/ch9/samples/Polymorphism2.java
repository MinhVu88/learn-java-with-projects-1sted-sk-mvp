// Figure 9.6
package ch9.samples; 

class Vehicle {
	double price = 100.0;
	static int year = 1969;

	public void move() {
		System.out.println("Vehicle::move()");
	}

	public static void swerve() {
		System.out.println("Vehicle::swerve()");
	}
}

class Car extends Vehicle {
	double price = 20_000.0;
	static int year = 1988;

	@Override
	public void move() {
		System.out.println("Car::move()");
	}

	public static void swerve() {
		System.out.println("Car::swerve()");
	}
}

public class Polymorphism2 {
	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		vehicle.move();

		// NOT RECOMMENDED: avoid at all costs using a reference type to access a static member
		vehicle.swerve();
		System.out.println("price: $" + vehicle.price + " | model year: " + vehicle.year);
	}
}