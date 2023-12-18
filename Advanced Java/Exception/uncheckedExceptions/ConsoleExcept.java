import java.util.Scanner;

public class ConsoleExcept {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int a;
			int b;
			a = scanner.nextInt();
			b = scanner.nextInt();
			System.out.println("result of Sum: " + (a + b));
		}

	}
}