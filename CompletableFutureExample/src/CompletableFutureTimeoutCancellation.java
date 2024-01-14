import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTimeoutCancellation {
	
    public static void main(String[] args) {
    	
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        	
            // Simulate a long-running task
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task completed successfully";
        });

        
        try {
            // Set a timeout of 3 seconds
            String result = future.get(3, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
        	
            // Handle timeout or cancellation
            System.out.println("Task timed out or canceled");
            // Cancel the CompletableFuture
            future.cancel(true);
        }
    }
}
