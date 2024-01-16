package time;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;

public class Example {

	public static void main(String[] args) {
		//local date and time
		Clock clock=Clock.systemUTC();
		System.out.println(clock.millis());
		System.out.println(clock.instant());
		System.out.println();
		
		//zone id
		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.println(ZoneId.systemDefault());
		System.out.println();
		
		//local date & time
		LocalDate ld=LocalDate.now();
		System.out.println(ld);
		LocalTime lt=LocalTime.now();
		System.out.println(lt);
		LocalTime ltc=LocalTime.now(clock);
		System.out.println(ltc);
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		
		//plus - minus
		LocalDate yesteday=LocalDate.now().minusDays(1);
		LocalDate tomorrow=LocalDate.now().plusDays(1);
		System.out.println("yesterday: "+yesteday);
		System.out.println("tomorrow: "+tomorrow);
		System.out.println();
		
		//period & duration
		Period fiveDays=Period.ofDays(5);
		Duration fewNanos=Duration.ofNanos(29999911);
		System.out.println(ltc.plus(fewNanos));
		System.out.println(ld.plus(fiveDays));
		System.out.println(fewNanos.toMillis());
		System.out.println(fewNanos.toMinutes());
		
		
		
		

	}

}
