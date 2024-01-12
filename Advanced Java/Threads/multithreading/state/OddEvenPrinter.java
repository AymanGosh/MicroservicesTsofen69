package createThread;

class NumberPrinter implements Runnable {
    private static final Object lock = new Object();
    private static int number = 1;

    private boolean isEven;

    public NumberPrinter(boolean isEven) {
        this.isEven = isEven;
    }

    @Override
    public void run() {
        while (number <= 10) {
            synchronized (lock) {
                // Wait for the other thread to finish printing
                while ((number % 2 == 0 && !isEven) || (number % 2 != 0 && isEven)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Print the current number
                System.out.println(Thread.currentThread().getName() + ": " + number);

                // Increment the number and notify the waiting thread
                number++;
                lock.notifyAll();
            }

            // Introduce some delay for better visualization
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class OddEvenPrinter {
    public static void main(String[] args) {
        // Create instances of NumberPrinter for odd and even numbers
        NumberPrinter oddPrinter = new NumberPrinter(false);
        NumberPrinter evenPrinter = new NumberPrinter(true);

        // Create threads for odd and even number printing
        Thread oddThread = new Thread(oddPrinter, "OddThread");
        Thread evenThread = new Thread(evenPrinter, "EvenThread");

        // Start the threads
        oddThread.start();
        evenThread.start();

        try {
            // Wait for both threads to finish
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Printing complete.");
    }
}
