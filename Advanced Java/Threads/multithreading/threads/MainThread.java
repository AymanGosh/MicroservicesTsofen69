package threads;

public class MainThread {
	// the main thread is the default and primary thread that is executed when a program starts.
	//This main thread is responsible for the execution of the main program and is typically where the program's 
	//entry point is located.
	//The main thread runs first because it is designed to execute the code specified in the main function or method.
	// It serves as the starting point for the program's execution 
	
	public static void main(String[] args) {
        // Code executed by the main thread

        // Getting the reference to the main thread
        Thread mainThread = Thread.currentThread();

        // Displaying information about the main thread
        System.out.println("Main Thread ID: " + mainThread.getId());
        System.out.println("Main Thread Name: " + mainThread.getName());
        System.out.println("Main Thread Priority: " + mainThread.getPriority());

        // Modifying the main thread properties
        mainThread.setName("MyMainThread");
        mainThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Updated Main Thread Name: " + mainThread.getName());
        System.out.println("Updated Main Thread Priority: " + mainThread.getPriority());

        // Simulating some work in the main thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
