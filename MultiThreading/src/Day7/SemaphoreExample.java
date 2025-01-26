package Day7;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(2); // Allow 2 threads at a time

		Runnable task = () -> {
			
			try {
				
				semaphore.acquire(); // Acquire a permit
				
				// Critical section: Limited number of threads can access
				System.out.println("Thread is accessing the shared resource.");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release(); // Release the permit
			}
			
			
		};
		
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		Thread thread3 = new Thread(task);
		Thread thread4 = new Thread(task);
		Thread thread5 = new Thread(task);
	

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
	}
}
