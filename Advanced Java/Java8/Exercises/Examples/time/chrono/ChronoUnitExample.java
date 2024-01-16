package time.chrono;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

class ChronoUnitExample {

	public static void main(String[] args) {
		//between
		LocalDateTime now=LocalDateTime.now();
		LocalDateTime future=now.plus(Period.ofDays(328));
		future.plus(Duration.ofHours(56));
		System.out.println(ChronoUnit.DAYS.between(now,future));
		System.out.println(ChronoUnit.HOURS.between(now,future));
		System.out.println(ChronoUnit.SECONDS.between(now,future));
		System.out.println(ChronoUnit.MILLENNIA.between(now,future));
		//duration
		System.out.println(ChronoUnit.DAYS.getDuration());
		System.out.println(ChronoUnit.DAYS.getDuration().toDays());
		System.out.println(ChronoUnit.HOURS.getDuration());
		System.out.println(ChronoUnit.HOURS.getDuration().toMinutes());
		System.out.println(ChronoUnit.SECONDS.getDuration().toMillis());
		System.out.println(ChronoUnit.SECONDS.getDuration().toNanos());
		System.out.println(ChronoUnit.MILLENNIA.getDuration().toHours());
		System.out.println(ChronoUnit.MILLENNIA.getDuration().toDays());
	}

}
