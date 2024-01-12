package defaultMethods;

public class CalculatorImpl implements Calculator {
    // Implementation of the abstract method
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Using the static method directly on the interface
        int result = Calculator.multiply(3, 4);
        System.out.println("Multiplication result: " + result);
    }
}