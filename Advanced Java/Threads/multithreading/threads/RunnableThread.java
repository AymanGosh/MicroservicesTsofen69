package threads;

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread ID: " +Thread.currentThread().getId() + "  -  Value: " + i);
        }
    }
}

public class RunnableThread {
    public static void main(String args[]) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }
}