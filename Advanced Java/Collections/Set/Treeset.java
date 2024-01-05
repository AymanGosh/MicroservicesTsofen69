package set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Treeset {
	
	 public static void main(String[] args) {
	        // Creating a TreeSet
	        Set<String> treeSet = new TreeSet<>();

	        // Adding elements to the TreeSet
	        treeSet.add("Apple");
	        treeSet.add("Banana");
	        treeSet.add("Orange");
	        treeSet.add("Apple"); // Duplicate element, won't be added

	        // Displaying the elements (in sorted order)
	        System.out.println("TreeSet: " + treeSet);
	        
	        
	        Iterator<String> iterator = treeSet.iterator();

	        while(iterator.hasNext()){
	          String element = iterator.next();
	        }
	        
	        for(String str : treeSet) {
	            System.out.println(str);
	        }
	    }

}
