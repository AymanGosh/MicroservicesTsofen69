//"buckets" refers to the slots or compartments in which elements are stored. 
//The HashMap class uses an array to store elements, 
//and each element is stored in a specific bucket based on its hash code.

//Hash Code and Bucket Calculation:
//1 . When you insert a key-value pair into a HashMap, the key's hashCode() method is called to obtain a hash code.
//2. The hash code is then processed to determine the index (or bucket) where the key-value pair should be stored.


//Storing Elements in Buckets:
//The calculated index corresponds to a specific bucket in the internal array.
//If multiple keys happen to have the same index (a collision), these keys will share the same bucket.
//To handle collisions, each bucket is often implemented as a linked list or some other data structure 
//that allows multiple elements with the same index to be stored together.



import java.util.HashMap;
import java.util.Map;

public class HashMapBucketsExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> hashMap = new HashMap<>();

        // Adding key-value pairs to the HashMap
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Four", 4);

        // Accessing elements to indirectly observe buckets
        accessHashMap(hashMap, "One");
        accessHashMap(hashMap, "Two");
        accessHashMap(hashMap, "Three");
        accessHashMap(hashMap, "Four");
    }

    // A method to access elements in the HashMap and observe buckets
    private static void accessHashMap(Map<String, Integer> hashMap, String key) {
        int hashCode = key.hashCode();
        int index = calculateBucketIndex(hashCode, hashMap.size());

        System.out.println("Key: " + key);
        System.out.println("Hash Code: " + hashCode);
        System.out.println("Bucket Index: " + index);
        System.out.println("Value: " + hashMap.get(key));
        System.out.println("-----");
    }

    // A simple method to calculate a bucket index based on the hash code and size
    private static int calculateBucketIndex(int hashCode, int arraySize) {
        return hashCode % arraySize;
    }
}
