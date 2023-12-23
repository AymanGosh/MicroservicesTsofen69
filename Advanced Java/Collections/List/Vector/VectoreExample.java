import java.util.Collections;
import java.util.Vector;

public class VectoreExample {
    public static void main(String[] args) {
        // Create three Vectors with integer elements
        Vector<Integer> vector1 = new Vector<>();
        vector1.add(5);
        vector1.add(2);
        vector1.add(8);

        Vector<Integer> vector2 = new Vector<>();
        vector2.add(3);
        vector2.add(1);
        vector2.add(7);

        Vector<Integer> vector3 = new Vector<>();
        vector3.add(6);
        vector3.add(4);
        vector3.add(9);

        // Combine and sort the elements without using Java 8 Stream API
        Vector<Integer> result = new Vector<>();
        result.addAll(vector1);
        result.addAll(vector2);
        result.addAll(vector3);

        // Sort the elements in ascending order
        Collections.sort(result);

        // Print the sorted result
        System.out.println("Sorted Result: " + result);

        // Accessing elements by index
        System.out.println("Element at index 2: " + result.get(2));

        // Checking if the vector contains a specific element
        System.out.println("Does the vector contain 7? " + result.contains(7));

        // Adding an element at a specific index
        result.add(2, 15);

        // Removing an element by value
        result.remove(Integer.valueOf(4));

        // Printing all elements using an enhanced for loop
        System.out.println("All Elements:");
        for (Integer element : result) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Checking if the vector is empty
        System.out.println("Is the vector empty? " + result.isEmpty());

        // Clearing all elements from the vector
        result.clear();

        // Checking if the vector is empty after clearing
        System.out.println("Is the vector empty after clearing? " + result.isEmpty());
    }
}
