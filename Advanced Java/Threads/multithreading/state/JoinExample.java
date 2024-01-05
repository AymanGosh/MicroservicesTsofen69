package state;

class JoinExample {
    public static void main(String args[]) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getId() + " Value " + i);
            }
        });

        t1.start();

        try {
            t1.join(); // Wait for t1 to complete before moving on
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread continues...");
    }
}
