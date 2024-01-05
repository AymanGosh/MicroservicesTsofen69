package threads;

public class AnonaymosRunnable {
	 public static void main(String args[]) {
	        Thread t1 = new Thread(new Runnable() {
	            public void run() {
	                for (int i = 1; i <= 5; i++) {
	                    System.out.println(Thread.currentThread().getId() + " Value " + i);
	                }
	            }
	        });
	        t1.start();

	        Thread t2 = new Thread(new Runnable() {
	            public void run() {
	                for (int i = 1; i <= 5; i++) {
	                    System.out.println(Thread.currentThread().getId() + " Value " + i);
	                }
	            }
	        });
	        t2.start();
	    }
}
