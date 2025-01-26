package Day8;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionHandlingExample {
	
    public static void main(String[] args) {
    	
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        	
        	System.out.println(10/0);
        	return "hello saddam";
        	
        });

        // Handle the exception and provide a fallback value
        CompletableFuture<String> result = future.exceptionally(ex -> "First asynchronous task get exception");

     

        // Print the result (either the original result or the fallback)
        result.thenAccept(System.out::println);
    }
}
