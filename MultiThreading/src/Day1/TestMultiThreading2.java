package Day1;

public class TestMultiThreading2 {

	public static void main(String[] args) throws InterruptedException  {

		Runnable r1 = () -> {

			for (int i = 0; i <= 10; i++) {
				System.out.println("Hello Saddam " + Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());

			}
		};	
		
		Runnable r2 = () -> {
			for (int i = 0; i <= 20; i++) {
				System.out.println("Hello Hussain " + Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
			}
		};

		
		Thread t1 = new Thread(r1, "T1");
		Thread t2 = new Thread(r2, "T2");
		t1.start();
		t1.sleep(10000);;
		t2.start();
		
		
		
		// 0 - New 
		// 1 - Runnable  
		// 2 - Blocked
		// 3 - Waiting
		// 4 - Timed Waiting
		// 5 - Terminated

	}

}
