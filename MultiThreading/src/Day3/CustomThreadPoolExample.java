package Day3;

import java.util.concurrent.*;

public class CustomThreadPoolExample {

    public static void main(String[] args) {
    	
        // Create a ThreadPoolExecutor with custom parameters
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                
        		2, // core pool size
                4, // maximum pool size
                30, // keep-alive time for idle threads
                TimeUnit.SECONDS, // time unit for keep-alive
                new LinkedBlockingQueue<>(2), // task queue with a capacity of 2
                new ThreadPoolExecutor.AbortPolicy() // rejection policy
        );

        // Submit tasks to the executor service
        for (int i = 1; i <= 6; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Task " + taskNumber + " is being executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(20000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Shut down the executor service
        executor.shutdown();
    }
}
