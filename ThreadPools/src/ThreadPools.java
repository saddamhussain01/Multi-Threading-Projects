import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {

	public static void main(String[] args) {

		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 5; i++) {
			
			threadPool.execute(() -> {
				int threadId = (int) Thread.currentThread().getId();
				System.out.println("Thread " + threadId + " is executing a task.");
			});
		}

		threadPool.shutdown();
	}

}
