

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parallel {
    public static void main(String[] args) {
        // Create three ArrayLists with integer elements
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(8);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        list2.add(7);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(4);
        list3.add(9);

        // Combine and sort the elements in parallel
        List<Integer> result = Stream.of(list1, list2, list3)
                .parallel() // Perform operations in parallel
                .flatMap(List::stream) // Flatten the lists into a single stream of elements.
                .sorted() // Sort the elements
                .collect(Collectors.toList()); // Collect the result into a new list

        // Print the sorted result
        System.out.println("Sorted Result: " + result);



        //2nd option : 
          // Combine and sort the elements without using Java 8 Stream API
        List<Integer> result2 = new ArrayList<>();
        result2.addAll(list1);
        result2.addAll(list2);
        result2.addAll(list3);

        // Sort the elements in ascending order
        Collections.sort(result2);

        // Print the sorted result
        System.out.println("Sorted Result: " + result2);
    }
}
