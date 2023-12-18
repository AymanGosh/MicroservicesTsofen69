// Custom exception class
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try {
            int number = getPositiveNumber(-5);
            System.out.println("Positive Number: " + number);
        } catch (NegativeNumberException e) {
            System.err.println(e.getMessage());
        }
    }

    // Method that throws custom exception
    private static int getPositiveNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("Error: Negative numbers are not allowed.");
        }
        return number;
    }
}
