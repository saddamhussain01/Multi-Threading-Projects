package Day8;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class RunAsyncExample {

	// using Runnable workload
	public void task1() throws InterruptedException, ExecutionException {

		CompletableFuture<Void> runAsyncFutureUsingRunnableWorkLoad = CompletableFuture.runAsync(() -> {

			System.out.println("Thread Name : " + Thread.currentThread().getName());
			System.out.println("Task 1 is executed");

		});
		runAsyncFutureUsingRunnableWorkLoad.get();
	}

	// using Runnable and Executor workload
	//completablefuture.runAsync(Runnable,Executor)
	public void task2() throws InterruptedException, ExecutionException {

		CompletableFuture<Void> runAsyncFutureUsingRunnableWorkLoad = CompletableFuture.runAsync(() -> {

			System.out.println("Thread Name : " + Thread.currentThread().getName());
			System.out.println("Task 2 is executed");

		},Executors.newFixedThreadPool(1));
		
		runAsyncFutureUsingRunnableWorkLoad.get();

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		RunAsyncExample runAsyncFuture = new RunAsyncExample();
		runAsyncFuture.task1();
		runAsyncFuture.task2();
		
	}

}
