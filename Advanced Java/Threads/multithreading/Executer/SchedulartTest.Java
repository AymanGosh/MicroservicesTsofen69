import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledTask implements Runnable {
    private String name;

    public ScheduledTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + " is running on thread " + Thread.currentThread().getName());
    }
}

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        // Create a scheduled executor with a single-threaded pool
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // Schedule a task to run after an initial delay of 2 seconds and then every 3 seconds
        Runnable task = new ScheduledTask("RepeatingTask");
        scheduledExecutorService.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);

        // Schedule a task to run after an initial delay of 5 seconds and then every 5 seconds
        Runnable anotherTask = new ScheduledTask("FixedDelayTask");
        scheduledExecutorService.scheduleWithFixedDelay(anotherTask, 5, 5, TimeUnit.SECONDS);

        // Sleep for a while to observe the scheduled tasks
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Shutdown the scheduled executor service
        scheduledExecutorService.shutdown();
    }
}
