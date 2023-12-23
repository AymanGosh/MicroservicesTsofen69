

import java.util.Vector;

public class TaskManager {
    private Vector<String> taskList = new Vector<>();

    // Method to add a task to the task list
    public void addTask(String task) {
        taskList.add(task);
    }

    // Method to get the number of tasks in the task list
    public int getTaskCount() {
        return taskList.size();
    }

    // Method to remove a task from the task list
    public void removeTask(String task) {
        taskList.remove(task);
    }

    // Method to print all tasks
    public void printTasks() {
        for (String task : taskList) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Adding tasks from multiple threads
        Thread thread1 = new Thread(() -> taskManager.addTask("Task 1"));
        Thread thread2 = new Thread(() -> taskManager.addTask("Task 2"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing tasks
        System.out.println("All Tasks:");
        taskManager.printTasks();

        // Removing a task
        taskManager.removeTask("Task 1");

        // Printing tasks after removal
        System.out.println("\nTasks after removal:");
        taskManager.printTasks();
    }
    
   // Overall Flow:
    	//Two threads add tasks concurrently to the taskList.
    	//The main thread waits for the addition threads to complete.
    	//All tasks are printed.
    	//One task is removed.
    	//The tasks are printed again after removal.
}
