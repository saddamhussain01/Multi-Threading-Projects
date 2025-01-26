package Day8;
import java.util.concurrent.CompletableFuture;

public class ThenComposeExample {

	public static void main(String[] args) {
		
		
		//task 1
		CompletableFuture<Integer>  task1 = CompletableFuture.supplyAsync(() -> 10 );
		
		
		//task 2
		CompletableFuture<Integer>  task2 = task1.thenCompose(result -> 
		
				CompletableFuture.supplyAsync(()-> result * 2));
		
		
		task2.thenAccept(finalResult -> {
			System.out.println("Combined Result is : " + finalResult);
		});
				
	}

}
