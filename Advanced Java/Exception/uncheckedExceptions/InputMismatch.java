import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter a valid integer.");
            // Clear the buffer to prevent an infinite loop
            scanner.nextLine();
        } finally {
            scanner.close();
        }
    }
}
