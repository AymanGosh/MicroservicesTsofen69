package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import stream.City;
import stream.Gender;
import stream.Person;

public class Test {
	
	
	
	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			int cityInx = (int) (Math.random() * 8);
			int genderInx = (int) (Math.random() * 2);
			int letterInx = (int) (Math.random() * 26);
			people.add(new Person("!" + (char) ('a' + letterInx) + "!",
					(int) (Math.random() * 121), Gender.values()[genderInx],
					City.values()[cityInx], (char) i + ".St"));
		}
		
	//concurrent is much slower...	
		
	/*	long start=System.nanoTime();
		
		people
		.parallelStream()
		.map(p -> p.getAddress().getCity())
		.collect(
				Collectors.groupingByConcurrent(City::toString,
						Collectors.counting()));
		people
		.stream()
		.map(p -> p.getAddress().getCity())
		.collect(
				Collectors.groupingBy(City::toString,
						Collectors.counting()));
	
		
		System.out.println(people
				.parallelStream()
				.map(p -> p.getAddress().getCity())
				.collect(
						Collectors.groupingByConcurrent(City::toString,
								Collectors.counting())));
		
		System.out.println(System.nanoTime()-start);
		System.out.println();
		
		start=System.nanoTime();
		System.out.println(people
				.stream()
				.map(p -> p.getAddress().getCity())
				.collect(
						Collectors.groupingBy(City::toString,
								Collectors.counting())));
		
		
		*/
		
		long start=System.currentTimeMillis();
		//basic collactive operations
		System.out.println(people.stream().count());
		System.out.println(people.stream().findFirst().get());
		System.out.println(people.stream().findAny().get());
		
		
		//match
		System.out.println(people.stream().allMatch(p->p.getName().startsWith("!")));
		System.out.println(people.stream().allMatch(p->p.getName().startsWith("!h")));
		System.out.println(people.stream().anyMatch(p->p.getName().startsWith("!h")));
		System.out.println(people.stream().anyMatch(p->p.getName().startsWith("!hx")));
		System.out.println(people.stream().allMatch(MaturePredicate::isMature));
		System.out.println(people.stream().anyMatch(MaturePredicate::isMature));
		
		//filter
		System.out.println("Females: "+people.stream().filter(p->p.getGender()==Gender.F).count());
		System.out.println("Males: "+people.stream().filter(p->p.getGender()==Gender.M).count());
		
		
		// map all person ages and reduce to calc avg age
		System.out.println(people.stream().mapToDouble(p -> p.getAge())
				.average().getAsDouble());
		// find the highest age of a male in the list
		System.out.println(people.stream().filter(p->p.getGender()==Gender.M).mapToInt(p -> p.getAge())
				.max().getAsInt());
		
		//foreach
		people.parallelStream().filter(p->p.getAge()<2).forEach(p->System.out.println("Hi I'm "+p.getName()));
		
		
		//simple collection collector
		List<Person> babies= people.stream().filter(p->p.getAge()<2).collect(Collectors.toList());
		System.out.println(babies.size());
		Map<String,Address> babyAddresses=people.stream().filter(p->p.getAge()<2).collect(Collectors.toMap(p->p.getName()+Math.random(), p->p.getAddress()));
		//single result collector
		System.out.println(people.stream().filter(p->p.getAge()<18).collect(Collectors.averagingDouble(p->p.getAge())).doubleValue());
		
		
		//group by
		//group old persons into cities
		Map<City, List<Person>> groups=people.stream().filter(p->p.getAge()==120).collect(Collectors.groupingBy(p->p.getAddress().getCity(),Collectors.toList()));
		System.out.println(groups);
		
		//group old persons into cities
		Map<City, Long> groups2=people.stream().filter(p->p.getAge()==120).collect(Collectors.groupingBy(p->p.getAddress().getCity(),Collectors.counting()));
		System.out.println(groups2);

		
		//partitioning
		//divide stream into false = less than 60 years old, true = older
		Map<Boolean,List<Person>> part=people.stream().filter(p -> p.getAddress().getCity().equals(City.A)).collect(Collectors.partitioningBy(p->p.getAge()>60));
		
		
		//joining
		System.out.println(people.stream().map(Person::getName).collect(Collectors.joining()));
		
		//parallel streams
		
		// map all person ages and reduce to calc avg age
		System.out.println(people.parallelStream().mapToDouble(p -> p.getAge())
				.average().getAsDouble());

		// collect all young persons (age<12) and print details and count
		List<Person> young = people.parallelStream()
				.filter(p -> p.getAge() < 12).collect(Collectors.toList());
		System.out.println(young + " (" + young.size() + ")");

		// how many came from each city - getting a Map as a result
		System.out.println(people
				.parallelStream()
				.map(p -> p.getAddress().getCity())
				.collect(
						Collectors.groupingBy(City::toString,
								Collectors.counting())));
		
		// how many came from each city - getting a ConcurrentMap as a result
		System.out.println(people
				.parallelStream()
				.map(p -> p.getAddress().getCity())
				.collect(
						Collectors.groupingByConcurrent(City::toString,
								Collectors.counting())));

		// Num of Person live in City A
		System.out.println(people.parallelStream()
				.filter(p -> p.getAddress().getCity().equals(City.A)).count());

		// List of Person from City B
		System.out.println(people.parallelStream()
				.filter(p -> p.getAddress().getCity().equals(City.B))
				.collect(Collectors.toList()));

		// Average age of M and F
		System.out.println(people.parallelStream().collect(
				Collectors.groupingBy(Person::getGender,
						Collectors.averagingInt(Person::getAge))));

		// Average age of M and F living in City C
		System.out.println(people
				.parallelStream()
				.filter(p -> p.getAddress().getCity().equals(City.C))
				.collect( 
						Collectors.groupingBy(Person::getGender,
								Collectors.averagingInt(Person::getAge))));

		// collects second letters of each person's name (map - reduce)
		// "" is the initial value, a is what calculated so far, b is current
		// value to fuse into a
		System.out.println(people.parallelStream().map(p -> p.getName())
				.reduce("", (a, b) -> {
					if(a.indexOf(b.charAt(1))==-1)
						a += b.charAt(1);
					return a;			
					}));
					
		System.out.println(System.currentTimeMillis()-start);
	}
	
}
