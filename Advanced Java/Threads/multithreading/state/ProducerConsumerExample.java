package state;

class SharedResource {
    boolean flag = false;

    synchronized void produce() {
        if (flag) {
            try {
                wait(); // Wait for the consumer to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producing...");
        flag = true;
        notify(); // Notify the consumer that the product is ready
    }

    synchronized void consume() {
        if (!flag) {
            try {
                wait(); // Wait for the producer to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consuming...");
        flag = false;
        notify(); // Notify the producer that the consumption is done
    }
}

public class ProducerConsumerExample {
    public static void main(String args[]) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.produce();
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.consume();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
