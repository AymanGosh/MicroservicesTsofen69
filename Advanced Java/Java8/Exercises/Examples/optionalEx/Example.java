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

	}

}
