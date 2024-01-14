import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedularThreadpool {

	public static void main(String[] args) {
		
		ScheduledExecutorService scedular = Executors.newScheduledThreadPool(2);
		
		Runnable task = () -> System.out.println("task is executed after sometime");
		
		scedular.schedule(task, 5, TimeUnit.SECONDS);
		
		scedular.shutdown();
		
	}

}
