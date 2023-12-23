import java.util.LinkedList;
// not access by index 
//LinkedList is its efficient support for insertions and removals, especially in the middle of the list. 
//However, keep in mind that for scenarios where random access by index is frequent and the list size doesn't change frequently, 
//an ArrayList might be more efficient.
public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList of strings
        LinkedList<String> linkedList = new LinkedList<>();

        // Adding elements to the LinkedList
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        // Displaying the LinkedList
        System.out.println("LinkedList: " + linkedList);

        // Adding elements at specific positions
        linkedList.add(1, "Orange");
        linkedList.addLast("Grapes");

        // Displaying the modified LinkedList
        System.out.println("Modified LinkedList: " + linkedList);

        // Getting the size of the LinkedList
        System.out.println("Size of LinkedList: " + linkedList.size());

        // Checking if an element is present
        System.out.println("Contains 'Banana': " + linkedList.contains("Banana"));

        // Getting elements by index
        System.out.println("Element at index 2: " + linkedList.get(2));

        // Removing elements by index and by value
        linkedList.remove(1);
        linkedList.remove("Cherry");

        // Displaying the LinkedList after removal
        System.out.println("LinkedList after removal: " + linkedList);

        // Clearing all elements
        linkedList.clear();
        System.out.println("LinkedList after clearing: " + linkedList);

        // Adding elements again
        linkedList.add("Mango");
        linkedList.add("Pineapple");

        // Displaying the final LinkedList
        System.out.println("Final LinkedList: " + linkedList);

            // Using an Iterator to iterate over the LinkedList
        System.out.println("Using Iterator:");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            System.out.println(element);
        }

        // Using enhanced for loop to iterate over the LinkedList
        System.out.println("\nUsing Enhanced For Loop:");
        for (int element : linkedList) {
            System.out.println(element);
        }

        // Using forEach method with lambda expression to iterate
        System.out.println("\nUsing forEach with Lambda:");
        linkedList.forEach(element -> System.out.println(element));
    }
}
