public class GenericMethodExample {

   // Generic method to find the maximum of two elements
   public static T extends ComparableT T findMax(T first, T second) {
       return (first.compareTo(second)  0)  first  second;
   }

   public static void main(String[] args) {
        //Example usage with Integer values
       Integer maxInt = findMax(5, 10);
       System.out.println(Maximum Integer  + maxInt);

        //Example usage with Double values
       Double maxDouble = findMax(3.14, 2.71);
       System.out.println(Maximum Double  + maxDouble);

       // Example usage with String values
       String maxString = findMax(apple, orange);
       System.out.println(Maximum String  + maxString);
   }
}
