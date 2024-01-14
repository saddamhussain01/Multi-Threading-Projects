import java.util.concurrent.CompletableFuture;

public class ThenCombineExample {

	public static void main(String[] args) {
		
		
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()-> 5);
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()-> 10);
		
		CompletableFuture<Integer> combined = future1.thenCombine(future2, (result1,result2)-> result1 * result2 );
		
		combined.thenAccept(result -> {
			System.out.println("combined result is : " + result);
		});
	}

}
