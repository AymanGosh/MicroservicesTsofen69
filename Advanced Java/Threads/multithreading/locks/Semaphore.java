import java.util.concurrent.Semaphore;

class SharedResource {
    private int sharedValue = 0;
    private final Semaphore semaphore = new Semaphore(1);

    public void increment() {
        try {
            semaphore.acquire(); // Acquire a permit
            sharedValue++;
            System.out.println(Thread.currentThread().getName() + " increments shared value to: " + sharedValue);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Release the permit
        }
    }

    public int getSharedValue() {
        return sharedValue;
    }
}

class Incrementer implements Runnable {
    private SharedResource sharedResource;

    public Incrementer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Creating two threads that increment the shared value
        Thread thread1 = new Thread(new Incrementer(sharedResource), "Thread-1");
        Thread thread2 = new Thread(new Incrementer(sharedResource), "Thread-2");

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Display the final shared value
        System.out.println("Final shared value: " + sharedResource.getSharedValue());
    }
}
