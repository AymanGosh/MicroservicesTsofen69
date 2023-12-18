


public class CatchRuntimeExceptionExample {
    public static void main(String[] args) {
        try {
            // Code that may throw exceptions
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Caught ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Caught Exception: " + e.getMessage());
        }
    }

    private static int divideNumbers(int numerator, int denominator) {
        return numerator / denominator;
    }
}



/ ...
} catch (Exception e) {
    System.err.println("Caught Exception: " + e.getMessage());
} catch (ArithmeticException e) {
    System.err.println("Caught ArithmeticException: " + e.getMessage());
// ...
