import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	
    public static void main(String[] args) throws InterruptedException   {
    	
        int count = 3;
        
        CountDownLatch latch = new CountDownLatch(count);

        Runnable task = () -> {
        	
            System.out.println("Thread is performing a task.");
            
            latch.countDown(); // Signal task completion
        };

        for (int i = 0; i < count; i++) {
            new Thread(task).start();
        }

        latch.await(); // Wait for all tasks to complete
        
        System.out.println("All tasks are completed.");
    }
}
