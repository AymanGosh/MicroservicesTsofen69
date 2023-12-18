// Custom checked exception class
class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

public class CustomCheckedException {
    public static void main(String[] args) {
        try {
            throwCheckedException();
        } catch (CustomCheckedException e) {
            System.err.println(e.getMessage());
        }
    }

    // Method that throws custom checked exception
    private static void throwCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException("This is a custom checked exception.");
    }
}
