// Exploring the Date API - pg 341
package ch12.samples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateAPI {
	// Figure 12.21 - pg 344
	private static void demoDatesTimes() {
		System.out.println(
			"LocalDateTime.now() => " + LocalDateTime.now() + 
			" | LocalDateTime.of(LocalDate.now(), LocalTime.now()) => " + 
			LocalDateTime.of(LocalDate.now(), LocalTime.now()) + 
			" | LocalDate.of(2025, 3, 17) => " + LocalDate.of(2025, 3, 17) + 
			" | LocalDate.parse(\"2025-03-17\") => " + LocalDate.parse("2025-03-17") + 
			" | LocalDate.parse(\"2025-03-17\").getDayOfWeek() => " + LocalDate.parse("2025-03-17").getDayOfWeek() +
			" | LocalDate.parse(\"2025-03-17\").withMonth(5) => " + LocalDate.parse("2025-03-17").withMonth(5) +
			" | LocalDate.parse(\"2025-03-17\").withMonth(5).plusYears(1) => " + 
			LocalDate.parse("2025-03-17").withMonth(5).plusYears(1) +
			" | LocalDate.parse(\"2025-03-17\").withMonth(5).plusYears(1).minusDays(5) => " +
			LocalDate.parse("2025-03-17").withMonth(5).plusYears(1).minusDays(5) +
			" | LocalDate.parse(\"2025-03-17\").withMonth(5).plusYears(1).minusDays(5).atTime(13, 45, 10) => " +
			LocalDate.parse("2025-03-17").withMonth(5).plusYears(1).minusDays(5).atTime(13, 45, 10)
		);
	}

	// Figure 12.22 - pg 345
	private static void demoZonedDateTime() {
		System.out.println(
			"LocalDateTime.of(2023, Month.NOVEMBER, 24, 13, 00) => " +
			LocalDateTime.of(2023, Month.NOVEMBER, 24, 13, 00) +
			" | LocalDateTime.of(2023, Month.NOVEMBER, 24, 13, 00).atZone(ZoneId.of(\"Europe/Dublin\")) => " +
			LocalDateTime.of(2023, Month.NOVEMBER, 24, 13, 00).atZone(ZoneId.of("Europe/Dublin")) +
			" | LocalDateTime.of(2023, Month.NOVEMBER, 24, 13, 00).atZone(ZoneId.of(\"Europe/Dublin\")).withZoneSameInstant(ZoneId.of(\"Europe/Paris\")).plusHours(1).plusMinutes(45) => " + 
			LocalDateTime.of(
				2023, 
				Month.NOVEMBER, 
				24, 
				13, 
				00)
				.atZone(ZoneId.of("Europe/Dublin"))
				.withZoneSameInstant(ZoneId.of("Europe/Paris"))
				.plusHours(1)
				.plusMinutes(45) +
				" | " +
				LocalDateTime.of(
				2023, 
				Month.NOVEMBER, 
				24, 
				13, 
				00)
				.atZone(ZoneId.of("Europe/Dublin"))
				.withZoneSameInstant(ZoneId.of("Europe/Paris"))
				.plusHours(1)
				.plusMinutes(45).getHour() + ":" +
				LocalDateTime.of(
				2023, 
				Month.NOVEMBER, 
				24, 
				13, 
				00)
				.atZone(ZoneId.of("Europe/Dublin"))
				.withZoneSameInstant(ZoneId.of("Europe/Paris"))
				.plusHours(1)
				.plusMinutes(45).getMinute()
		);
	}

	// Figure 12.23 - pg 346
	private static void demoPeriodDuration() {
		System.out.println(
			"Period.between(startDate, endDate) => " + 
			Period.between(
				LocalDate.of(1856, 7, 10), 
				LocalDate.of(1943, 1, 7)
			) +
			" | Period.between(startDate, endDate).getYears() => " +
			Period.between(
				LocalDate.of(1856, 7, 10), 
				LocalDate.of(1943, 1, 7)
			).getYears() +
			" | Period.between(startDate, endDate).getMonths() => " +
			Period.between(
				LocalDate.of(1856, 7, 10), 
				LocalDate.of(1943, 1, 7)
			).getMonths() +
			" | Period.between(startDate, endDate).getDays() => " +
			Period.between(
				LocalDate.of(1856, 7, 10), 
				LocalDate.of(1943, 1, 7)
			).getDays() +
			" | Duration.between(localTime0, localTime1) => " +
			Duration.between(
				LocalTime.of(12, 0, 20), 
				LocalTime.of(14, 45, 40)
			)
		);
	}

	// Figure 12.24 - pg 349
	private static void demoPredefinedFormatters() {
		System.out.println(
			"LocalDate.now().format(DateTimeFormatter.ISO_DATE) => " +
			LocalDate.now().format(DateTimeFormatter.ISO_DATE) +
			" | LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) => " +
			LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) +
			" | LocalTime.now().format(DateTimeFormatter.ISO_TIME) => " +
			LocalTime.now().format(DateTimeFormatter.ISO_TIME) +
			" | LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)) => " +
			LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
		);
	}

	// Figure 12.25 - pg 351
	private static void demoCustomFormatters() {
		System.out.println(
			"ZonedDateTime.now() => " + ZonedDateTime.now() +
			" | ZonedDateTime.now().format(DateTimeFormatter.ofPattern(\"yy-MMM-dd E D\")) => " +
			ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yy-MMM-dd E D")) +
			" | ZonedDateTime.now().format(DateTimeFormatter.ofPattern(\"hh:mm:ss a z G\")) => " +
			ZonedDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a z G")) +
			" | ZonedDateTime.now().format(DateTimeFormatter.ofPattern(\"'Year: 'yyyy'. Month: 'MMMM'. Day: 'dd'.'\")) => " +
			ZonedDateTime.now().format(DateTimeFormatter.ofPattern("'Year: 'yyyy'. Month: 'MMMM'. Day: 'dd'.'")) +
			" | LocalDateTime.parse(\"2023-07-10 22:10\", DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm\")) => " +
			LocalDateTime.parse("2023-07-10 22:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
		);
	}

	public static void main(String[] args) {
		demoDatesTimes();
		System.out.println("-----------------------------------------------------------");
		demoZonedDateTime();
		System.out.println("-----------------------------------------------------------");
		demoPeriodDuration();
		System.out.println("-----------------------------------------------------------");
		demoPredefinedFormatters();
		System.out.println("-----------------------------------------------------------");
		demoCustomFormatters();
	}
}
