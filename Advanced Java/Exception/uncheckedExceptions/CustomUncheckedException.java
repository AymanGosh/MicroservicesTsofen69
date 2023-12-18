// Custom unchecked exception class
class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }
}

public class CustomUncheckedException {
    public static void main(String[] args) {
        try {
            throwUncheckedException();
        } catch (CustomUncheckedException e) {
            System.err.println(e.getMessage());
        }
    }

    // Method that throws custom unchecked exception
    private static void throwUncheckedException() {
        throw new CustomUncheckedException("This is a custom unchecked exception.");
    }
}
