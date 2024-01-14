import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramework {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(()-> System.out.println("Task  1 is executing"));
		executor.execute(()-> System.out.println("Task  2 is executing"));
		executor.submit(()-> System.out.println("Task  3 is executing"));

	}

}
