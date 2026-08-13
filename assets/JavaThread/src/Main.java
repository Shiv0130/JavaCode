////My code
//class MyRunnable {
//
//    public void run(){
//        @Override
//       for(int i =1;i<=5;i++){
//           try{
//               Thread.sleep(1000);
//           }
//           catch (InterruptedException e){
//               System.out.println("Something went wrong");
//
//           }
//       }
//
//    }
//}
//
//class Worker extends MyRunnable{
//    public void run(){
//        @Override
//        for(int i =1;i<=5;i++){
//            try{
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e){
//                System.out.println("Something went wrong");
//
//            }
//        }
//
//    }
//}
//}
//
//public class Main {
//    public static void main(String[] args) {
//
//        Worker worker = new Worker();
//        Thread thread = new Thread();
//        thread.start();
//
//
//    }
//}

//CORRECT CODE
// Worker class that extends Thread
class Worker extends Thread {
    private String message;
    private int iterations;

    // Constructor to accept message and iteration count
    public Worker(String message, int iterations) {
        this.message = message;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        System.out.println("Worker thread started: " + Thread.currentThread().getName());

        for (int i = 1; i <= iterations; i++) {
            System.out.println(message + " - Iteration " + i + " [" + Thread.currentThread().getName() + "]");

            try {
                // Sleep for 1 second between messages
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Worker thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Restore interrupt status
                break;
            }
        }

        System.out.println("Worker thread completed: " + Thread.currentThread().getName());
    }
}

// TaskManager class that implements Runnable
class TaskManager implements Runnable {
    private int limit;

    // Constructor to accept the limit for sum calculation
    public TaskManager(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        System.out.println("TaskManager thread started: " + Thread.currentThread().getName());

        long sum = 0;

        // Sum all even numbers from 1 to limit
        for (int i = 2; i <= limit; i += 2) {
            sum += i;
        }

        System.out.println("TaskManager Result: Sum of even numbers from 1 to " + limit + " = " + sum);
        System.out.println("TaskManager thread completed: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread started: " + Thread.currentThread().getName());

        try {
            // Create two Worker threads with different messages and iterations
            Worker worker1 = new Worker("Hello from Worker 1", 5);
            Worker worker2 = new Worker("Greetings from Worker 2", 3);

            // Create TaskManager thread to compute sum of even numbers
            TaskManager taskManager = new TaskManager(1000);
            Thread taskThread = new Thread(taskManager, "TaskManager-Thread");

            // Start all threads
            System.out.println("\n--- Starting all threads ---");
            worker1.start();
            worker2.start();
            taskThread.start();

            System.out.println("All threads have been started and are running concurrently...\n");

            // Use join() to wait for all threads to complete
            System.out.println("Main thread waiting for all threads to complete...");

            worker1.join();
            System.out.println("Worker 1 has finished");

            worker2.join();
            System.out.println("Worker 2 has finished");

            taskThread.join();
            System.out.println("TaskManager has finished");

            System.out.println("\n--- All threads completed ---");
            System.out.println("Main thread ending: " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}