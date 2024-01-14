import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThenApplyExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Executor executor = Executors.newCachedThreadPool();
		
		CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {

			System.out.println(Thread.currentThread().getName());
			return "Hello";

		}).thenApply(name -> {

			System.out.println(Thread.currentThread().getName());
			return name +" welcome";

		}).thenApplyAsync(result -> {
			
			System.out.println(Thread.currentThread().getName());
			return result + " saddam hussain";
		}).thenApplyAsync(result -> {
			
			System.out.println(Thread.currentThread().getName());
			return result + " Easy learning channel";
		},executor);

		System.out.println(helloFuture.get());

	}

}
