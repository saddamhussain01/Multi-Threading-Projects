import java.util.concurrent.CompletableFuture;

public class CompletableFutureHandleExample {
    public static void main(String[] args) {
    	
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        	
        	System.out.println(10/0);
        	return "hello saddam";
        });

        // Handle both the result and the exception
        CompletableFuture<String> result = future.handle((res, ex) -> {
            if (ex != null) {
                return "Fallback Value"; // Recover from the exception
            } else {
                return res.toUpperCase(); // Process the result
            }
        });

        // Print the result (either the original result or the fallback)
        result.thenAccept(System.out::println);
    }
}
