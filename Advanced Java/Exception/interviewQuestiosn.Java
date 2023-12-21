//Write a Java method that divides two numbers and handles the case where the divisor is zero by throwing a custom exception.


public class DivideNumbers {
    public static double divide(double dividend, double divisor) throws DivisorZeroException {
        if (divisor == 0) {
            throw new DivisorZeroException("Cannot divide by zero");
        }
        return dividend / divisor;
    }
}

// Custom exception for divisor being zero
class DivisorZeroException extends RuntimeException {
    public DivisorZeroException(String message) {
        super(message);
    }
}





//Write a Java method that opens a resource, performs an operation, and ensures that the resource is closed, even if an exception occurs.

import java.io.Closeable;
import java.io.IOException;

public class ResourceExample {
    public static void main(String[] args) {
        try {
            performOperationWithResource();
        } catch (IOException e) {
            System.out.println("Error performing operation: " + e.getMessage());
        }
    }

    public static void performOperationWithResource() throws IOException {
        MyResource resource = new MyResource();
        try {
            // Perform operation with the resource
            resource.doOperation();
        } finally {
            // Ensure the resource is closed
            resource.close();
        }
    }
}

class MyResource implements Closeable {
    public void doOperation() throws IOException {
        // Perform some operation
        if (/* operation fails */) {
            throw new IOException("Operation failed");
        }
    }

    @Override
    public void close() throws IOException {
        // Close the resource
        System.out.println("Closing the resource");
    }
}
