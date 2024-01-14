import java.util.concurrent.CompletableFuture;

public class AllOfExample {
	
    public static void main(String[] args) {
    	
        // Define three asynchronous tasks (fetching data from different sources)
        CompletableFuture<String> task1 = fetchDataAsync("Source 1");
        CompletableFuture<String> task2 = fetchDataAsync("Source 2");
        CompletableFuture<String> task3 = fetchDataAsync("Source 3");

        // Combine the results when all tasks are completed
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);

        // Perform an action when all tasks are completed
        allTasks.thenRun(() -> {
            try {
                // Retrieve results of individual tasks
                String result1 = task1.get();
                String result2 = task2.get();
                String result3 = task3.get();

                // Combine results
                String combinedResult = "Combined Result: " + result1 + ", " + result2 + ", " + result3;

                // Print the combined result
                System.out.println(combinedResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Block the main thread to see the results (for demonstration purposes)
        try {
            allTasks.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simulate fetching data asynchronously
    private static CompletableFuture<String> fetchDataAsync(String source) {
    	
        return CompletableFuture.supplyAsync(() -> {
            // Simulate a time-consuming task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Data from " + source;
        });
    }
}
