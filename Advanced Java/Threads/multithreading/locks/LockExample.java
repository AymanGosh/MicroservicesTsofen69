import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " increments count to: " + count);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

class Incrementer implements Runnable {
    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
        }
    }
}

public class LockExample {
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();

        // Creating two threads that increment the shared counter
        Thread thread1 = new Thread(new Incrementer(sharedCounter), "Thread-1");
        Thread thread2 = new Thread(new Incrementer(sharedCounter), "Thread-2");

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

        // Display the final count
        System.out.println("Final count: " + sharedCounter.getCount());
    }
}
