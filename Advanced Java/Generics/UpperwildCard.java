public class GenericWildcards {

    // Generic method with wildcard for upper-bounded list
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5);

        System.out.println("Sum of Integers: " + sumOfList(integerList));
        System.out.println("Sum of Doubles: " + sumOfList(doubleList));
    }
}
