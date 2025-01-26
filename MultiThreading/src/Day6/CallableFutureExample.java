package Day6;
import java.util.concurrent.*;

public class CallableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Callable<Integer> task = () -> {
			Thread.sleep(2000);
			return 42;
		};

		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<Integer> futureResult = executor.submit(task);

		executor.shutdown();

		try {
			int result = futureResult.get();
			System.out.println("Result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
