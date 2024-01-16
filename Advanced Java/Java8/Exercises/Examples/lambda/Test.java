package lambda;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
	public static void main(String[] args) {

		Runnable r = () -> System.out.println("Hi!");

		new Thread(r).start();

		new Thread(() -> System.out.println("Hi There!")).start();

		Future<Integer> f = Executors.newSingleThreadScheduledExecutor()
				.submit(() -> {
					int result = 0;
					for (int i = 0; i < 10; i++) {
						result += (int) (Math.random() * 100);
					}
					return result;
				});
		try {
			System.out.println(f.get());
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
