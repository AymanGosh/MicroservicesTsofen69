public class ThrowExample {
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.err.println("Caught an InvalidAgeException: " + e.getMessage());
        }
    }

    // Custom exception class
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    // Method that throws a custom exception
    private static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        } else {
            System.out.println("Age is valid.");
        }
    }
}
