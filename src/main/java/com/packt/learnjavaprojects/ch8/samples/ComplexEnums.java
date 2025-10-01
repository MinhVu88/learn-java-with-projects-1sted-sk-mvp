// Figure 8.28 
package ch8.samples;

enum WorkDay {
	// enum constants
	MONDAY("9-5"),
	TUESDAY("9-5"),
	wEDNESDAY("9-5"),
	THURSDAY("9-5"),
	FRIDAY("9-5"),
	SATURDAY("10-1") {
		// override the default accessor method getWorkPlace
		public String getWorkPlace() {
			return "Home";
		}
	};

	private String workingHours; // private instance var

	// private constructor
	WorkDay(String workingHours) {
		this.workingHours = workingHours;
	}

	// an accessor method, thru which external classes gain access to the private instance var
	public String getWorkingHours() {
		return this.workingHours;
	}

	public String getWorkPlace() {
		return "Office";
	}
};

public class ComplexEnums {
	public static void main(String[] args) {
		WorkDay monday = WorkDay.MONDAY;

		System.out.println(
			"Monday - wokring hours: " + monday.getWorkingHours() + 
			" | workplace: " + monday.getWorkPlace()
		);

		System.out.println(
			"Saturday - wokring hours: " + WorkDay.SATURDAY.getWorkingHours() +
			" | workplace: " + WorkDay.SATURDAY.getWorkPlace()
		);
	}
}
