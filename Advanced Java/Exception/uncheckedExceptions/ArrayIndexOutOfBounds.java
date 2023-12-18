public class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        try {
            // Accessing an index beyond the array size
            int value = numbers[10];
            System.out.println("Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Index out of bounds. Please check your array bounds.");
        }
    }
}
