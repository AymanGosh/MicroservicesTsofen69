 import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrList {

	
	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Orange");
        
        
        for (String language : colors) {
            System.out.print( "-" +language);
        }
        System.out.println();
        
        
        colors.add(2, "White");
        colors.add(0 , "Black");
        
        for(int i=0 ; i<colors.size();i++)
        {
        	System.out.print( "-" +colors.get(i));
        }
        System.out.println();
      
        //replace element 
        colors.set(3, null);
        for(int i=0 ; i<colors.size();i++)
        {
        	System.out.print( "-" +colors.get(i));
        }
        
        // Iterating using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) {
            System.err.print(" "+ iterator.next());
        }
        
        System.out.println();
        // Clearing the ArrayList
        colors.clear();
        System.out.println("ArrayList after clearing: " + colors);

        
        // Example array
        String[] array = {"Apple", "Banana", "Orange"};

        // Convert array to ArrayList
        List<String> arrayList = new ArrayList<>(Arrays.asList(array));

        // Display the ArrayList
        System.out.println("ArrayList: " + arrayList);
	}
}
