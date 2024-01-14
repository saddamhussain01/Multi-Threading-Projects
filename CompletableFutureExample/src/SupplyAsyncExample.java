import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class SupplyAsyncExample {

	public void task1() throws InterruptedException, ExecutionException {

		// using supplier<T> workload
		CompletableFuture<String> supplyAsyncFutureUsingSupplierWorkload = CompletableFuture.supplyAsync(() -> {

			System.out.println("Thread name : " + Thread.currentThread().getName());
			return "Task is executed";
		});

		System.out.println(supplyAsyncFutureUsingSupplierWorkload.get());

	}

	public void task2() throws InterruptedException, ExecutionException {

		// Using supplier<T> and Executor workload
		// CompletableFuture.supplyAsync(Supplier<T>,Executors)
		CompletableFuture<String> supplyAsyncFutureUsingSupplierAndExecutorWorkload = CompletableFuture
				.supplyAsync(() -> {

					System.out.println("Thread name : " + Thread.currentThread().getName());
					return "Task is executed";
				}, Executors.newFixedThreadPool(1));

		System.out.println(supplyAsyncFutureUsingSupplierAndExecutorWorkload.get());

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		SupplyAsyncExample supplyAsyncFuture = new SupplyAsyncExample();
		supplyAsyncFuture.task1();
		supplyAsyncFuture.task2();

	}

}
