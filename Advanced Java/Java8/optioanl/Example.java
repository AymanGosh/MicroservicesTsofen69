package optionalEx;

import java.util.Optional;

public class Example {

	public static void main(String[] args) {
		
		Optional<String> eValue=Optional.empty();
		Optional<String> nValue=Optional.ofNullable(null);
		Optional<String> value=Optional.of("OptionalData");
		
		System.out.println(value.get());
		System.out.println(nValue.orElse("else None"));
		System.out.println(eValue.orElse("else Empty"));
		//Supplier
		System.out.println(value.orElseGet(()->"else-get ???"));
		System.out.println(nValue.orElseGet(()->"else-get None"));
		System.out.println(eValue.orElseGet(()->"else-get Empty"));
		
		System.out.println(value.isPresent());
		System.out.println(nValue.isPresent());
		System.out.println(eValue.isPresent());
		
		//Consumer
		value.ifPresent((String s)->System.out.println(s+" is in the house"));


		// Creating an Optional with a non-null value
		Optional<String> optionalWithValue = Optional.of("Hello, Java 8!");

		// Creating an empty Optional
		Optional<String> optionalEmpty = Optional.empty();

		// Checking if an Optional has a value
		if (optionalWithValue.isPresent()) {
			System.out.println("Value is present: " + optionalWithValue.get());
		} else {
			System.out.println("Value is not present");
		}

		// Using ifPresent to perform an action if a value is present
		optionalWithValue.ifPresent(value -> System.out.println("Value is present: " + value));

		// Providing a default value if the Optional is empty
		String result = optionalEmpty.orElse("Default Value");
		System.out.println("Result: " + result);

		// Using map to transform the value if present
		Optional<String> transformedOptional = optionalWithValue.map(s -> s + " - Transformed");
		transformedOptional.ifPresent(value -> System.out.println("Transformed Value: " + value));

		}

}