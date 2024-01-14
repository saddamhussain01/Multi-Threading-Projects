
public class CriticalSectionExample {

	private static int counter = 0; // Shared resource

	public static void main(String[] args) {

		// Create two threads that increment the counter concurrently

		Thread t1 = new Thread(() -> {

			for (int i = 0; i < 1000; i++) {

				synchronized (CriticalSectionExample.class) {

					counter++;
				}
			}
		});
		
		
		Thread t2 = new Thread(() -> {

			for (int i = 0; i < 1000; i++) {

				synchronized (CriticalSectionExample.class) {

					counter++;
				}
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		System.out.println("Final Counter value = " + counter );

	}

}
