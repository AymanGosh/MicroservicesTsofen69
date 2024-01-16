package time.chrono;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;

public class ChronoExample {

	public static void main(String[] args) {
		ChronoLocalDate chronoNow=ChronoLocalDate.from(LocalDate.now());
		System.out.println(chronoNow);
		LocalDate yesteday=LocalDate.now().minusDays(1);
		LocalDate tomorrow=LocalDate.now().plusDays(1);
		System.out.println(yesteday.isAfter(chronoNow));
		System.out.println(tomorrow.isAfter(chronoNow));
		System.out.println(yesteday.isBefore(chronoNow));
		System.out.println(tomorrow.isBefore(chronoNow));
	}

}
