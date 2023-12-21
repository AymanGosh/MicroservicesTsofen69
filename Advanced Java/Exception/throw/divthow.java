public class DivisionExample {

    public static double performDivision(double dividend, double divisor) {
        if (divisor == 0) {
            throw new RuntimeException("Cannot divide by zero");
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        try {
            double result = performDivision(10.0, 2.0);
            System.out.println("Result: " + result);

            // Uncommenting the following line will result in a RuntimeException
            // double invalidResult = performDivision(5.0, 0.0);
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
