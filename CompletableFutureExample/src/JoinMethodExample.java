import java.util.concurrent.CompletableFuture;

public class JoinMethodExample {
	
	public static void main(String[] args) {
		
        // Simulate fetching data asynchronously
        CompletableFuture<String> fetchData = CompletableFuture.supplyAsync(() -> {
        	
            // Simulate a time-consuming task
            try {
                Thread.sleep(3000);
             
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data from the server after 3 seconds";
        });

        // When the data is available, print it
        fetchData.thenAccept(data -> {
            System.out.println("Received: " + data);
        });
        

        // Continue with other tasks while waiting for data
        System.out.println("Doing other work...");

        // Wait for the CompletableFuture to complete (for demonstration purposes)
        fetchData.join();
    }

}
