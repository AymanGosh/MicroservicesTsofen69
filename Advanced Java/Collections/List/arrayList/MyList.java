
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;

//Custom ArrayList class extending ArrayList

public class MyList<T extends Comparable<T>> extends ArrayList<T> {

    // Custom method to reverse the elements
    public void reverse() {
        Collections.reverse(this);
    }

    // Custom method to sort the elements
    public void customSort() {
        Collections.sort(this);
    }

    // Custom method to print the elements
    public void printElements() {
        for (T element : this) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyList
        MyList<Integer> myList = new MyList<>();

        // Add elements to the custom ArrayList
        myList.add(5);
        myList.add(2);
        myList.add(8);
        myList.add(1);

        // Print original elements
        System.out.println("Original elements:");
        myList.printElements();

        // Reverse the elements
        myList.reverse();
        System.out.println("\nAfter reversing:");
        myList.printElements();

        // Sort the elements
        myList.customSort();
        System.out.println("\nAfter sorting:");
        myList.printElements();
    }
}