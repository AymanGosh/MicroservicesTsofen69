package set;

import java.util.LinkedHashSet;
import java.util.Set;

public class Linkedhashset {
	public static void main(String[] args) {
        // Creating a LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Adding elements to the LinkedHashSet
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Apple"); // Duplicate element, won't be added

        // Displaying the elements (in insertion order)
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }

}
