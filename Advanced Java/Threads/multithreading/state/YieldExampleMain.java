package state;
//The yield method is used to give a hint to the scheduler that the current thread is willing to yield its current use of a processor. 
class YieldExample extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);

            // Using yield to give the scheduler a hint
            Thread.yield();
        }
    }
}

public class YieldExampleMain {
    public static void main(String args[]) {
        YieldExample t1 = new YieldExample();
        YieldExample t2 = new YieldExample();

        t1.start();
        t2.start();
    }
}
