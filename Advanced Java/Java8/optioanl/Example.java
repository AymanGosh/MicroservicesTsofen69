package optionalEx;

import java.util.Optional;

public class Example {

	public static void main(String[] args) {
		
		 List<Person> people = Arrays.asList( new Person(25, "Max"),
		                new Person(30, "Sami"),
		                new Person(22, "David")
		        );

		        // Find a person by name using Optional
		        String targetName = "Charlie";
		        Optional<Person> optionalPerson = findPersonByName(people, targetName);

		        // If the person is present, print information; otherwise, print a message
		        optionalPerson.ifPresentOrElse(
		                person -> System.out.println("Person found: " + person),
		                () -> System.out.println("Person with name '" + targetName + "' not found.")
		        );
		    }

		    // Method to find a person by name and return an Optional<Person>
		    private static Optional<Person> findPersonByName(List<Person> people, String name) {
		        return people.stream()
		                .filter(person -> person.getName().equals(name))
		                .findFirst();
		    }

		}

