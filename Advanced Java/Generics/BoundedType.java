public class BoundedTypeGenericExample {

    // Bounded type generic method to calculate the sum of numeric elements in a list
    public static <T extends Number> double calculateSum(List<T> elements) {
        double sum = 0.0;
        for (T element : elements) {
            sum += element.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        // Example usage with Integer values
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        double sumOfIntegers = calculateSum(integerList);
        System.out.println("Sum of Integers: " + sumOfIntegers);

        // Example usage with Double values
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5);
        double sumOfDoubles = calculateSum(doubleList);
        System.out.println("Sum of Doubles: " + sumOfDoubles);

        // Uncommenting the following line will result in a compilation error
        // List<String> stringList = Arrays.asList("one", "two", "three");
        // double sumOfStringLengths = calculateSum(stringList);
    }
}
