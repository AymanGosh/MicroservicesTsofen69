import java.util.HashMap;
import java.util.Map;
//data structure that uses a hash function to map data to an index or key, 
//allowing for efficient data retrieval. 
//One common example of a hash data structure is a hash table,


public class HashMapExample {
     public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> hashMap = new HashMap<>();

        // Adding key-value pairs to the HashMap
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Four", 4);

        // Displaying the original HashMap
        System.out.println("Original HashMap: " + hashMap);

        // Accessing values using keys
        int value = hashMap.get("Two");
        System.out.println("Value associated with 'Two': " + value);

        // Updating a value
        hashMap.put("Three", 33);
        System.out.println("Updated HashMap: " + hashMap);

        // Checking if a key is present
        boolean containsKey = hashMap.containsKey("Five");
        System.out.println("Contains key 'Five': " + containsKey);

        // Checking if a value is present
        boolean containsValue = hashMap.containsValue(4);
        System.out.println("Contains value '4': " + containsValue);

        // Removing a key-value pair
        hashMap.remove("One");
        System.out.println("HashMap after removing 'One': " + hashMap);

        // Iterating through the keys
        System.out.println("Keys in HashMap:");
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }

        // Iterating through the values
        System.out.println("Values in HashMap:");
        for (int val : hashMap.values()) {
            System.out.println(val);
        }

        // Iterating through the entries
        System.out.println("Entries in HashMap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Clearing the HashMap
        hashMap.clear();
        System.out.println("HashMap after clearing: " + hashMap);
    }
