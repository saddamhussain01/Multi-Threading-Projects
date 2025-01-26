package Day8;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException  {

		ExecutorService executors = Executors.newFixedThreadPool(5);
		

		Future<List<Integer>> future1 = executors.submit(() -> {

			System.out.println("Thread: " + Thread.currentThread().getName());
			//System.out.println(10 / 0);

			Thread.sleep(10000);
			return Arrays.asList(1, 2, 3, 4, 5);

		});

		List<Integer> list = future1.get();
		System.out.println(list);

	    
		
		System.out.println("===================================================");
		
		executors.execute(() -> {

			System.out.println("Thread: " + Thread.currentThread().getName());
			//System.out.println(10 / 0);

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Arrays.asList(1, 2, 3, 4, 5));

		});
		
	}

}
