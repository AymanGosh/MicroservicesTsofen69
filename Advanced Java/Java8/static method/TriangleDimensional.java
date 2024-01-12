

public interface Calculator {
    // Abstract method
    int add(int a, int b);

    // Static method with default implementation
    static int multiply(int a, int b) {
        return a * b;
    }
}