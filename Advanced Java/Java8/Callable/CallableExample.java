import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // Some computation or task that returns an integer result
        return 42;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submitting a Callable task and obtaining a Future
        Future<Integer> future = executorService.submit(new MyCallable());

        try {
            // Getting the result of the Callable task
            Integer result = future.get();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}