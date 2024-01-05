package threads;

class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread ID: " + Thread.currentThread().getId() +  "-  the thread name: "+ Thread.currentThread().getName()+  "    Value " + i);
        }
    }
}

public class ExtendThread {
    public static void main(String args[]) {
        MyThread t1 = new MyThread("first");
        t1.start(); // starts a new thread, and calls run() method

        MyThread t2 = new MyThread("second");
        t2.start();
        
        System.out.println("The current Thread is " + Thread.currentThread().getName());
    }
}
