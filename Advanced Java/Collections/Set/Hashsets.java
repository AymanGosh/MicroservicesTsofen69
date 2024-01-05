package set;

import java.util.HashSet;
//the order is determined by the hash codes of the elements and the internal structure of the underlying hash table.
//When you add an element to a HashSet, the hashCode() method of the element is called to obtain a hash code.
//The hash code is an integer that represents the object in a way that should minimize collisions (different objects producing the same hash code). 
//The HashSet then uses this hash code to determine where to store the element in its internal data structure.
public class Hashsets {
	public static void main(String[] args) {
        // Create a empty hash set
		HashSet<String> hasgset = new HashSet<String>();
  // use add() method to add values in the hash set
         hasgset.add("Red");
         hasgset.add("Green");
         hasgset.add("Black");
         hasgset.add("White");
         hasgset.add("Pink");
         hasgset.add("Yellow");
   System.out.println("Original Hash Set: " + hasgset);
   System.out.println("Size of the Hash Set: " + hasgset.size());
  }
}
