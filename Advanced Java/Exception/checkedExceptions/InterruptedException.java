public class InterruptedException {
    public static void main(String[] args) {
        try {
            // Attempting to interrupt a sleeping thread
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException: " + e.getMessage());
        }
    }
}
