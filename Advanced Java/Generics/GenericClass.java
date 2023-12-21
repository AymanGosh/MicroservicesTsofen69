public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // Example of a generic method within the generic class
    public static <V, W> Pair<V, W> createPair(V first, W second) {
        return new Pair<>(first, second);
    }

    public static void main(String[] args) {
        // Creating instances of Pair with different types
        Pair<String, Integer> stringIntPair = new Pair<>("Hello", 42);
        Pair<Double, Boolean> doubleBooleanPair = new Pair<>(3.14, true);

        // Accessing values
        String stringVal = stringIntPair.getFirst();
        Integer intVal = stringIntPair.getSecond();
        Double doubleVal = doubleBooleanPair.getFirst();
        Boolean booleanVal = doubleBooleanPair.getSecond();

        // Printing values
        System.out.println("String-Integer Pair: " + stringIntPair);
        System.out.println("Double-Boolean Pair: " + doubleBooleanPair);

        // Using the generic method to create a Pair
        Pair<Character, Long> charLongPair = Pair.createPair('A', 9876543210L);
        System.out.println("Character-Long Pair: " + charLongPair);
    }
}
