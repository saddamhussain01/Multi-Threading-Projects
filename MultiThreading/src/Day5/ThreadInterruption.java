package Day5;

public class ThreadInterruption {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(()-> {
			
			try {
				System.out.println("Thread is start");
				
				System.out.println("helo");
				System.out.println("helo");
				System.out.println("helo");
				System.out.println("helo");
				System.out.println("helo");
				
				Thread.sleep(5000);
				
				System.out.println("Hi");
				System.out.println("Hi");
				System.out.println("Hi");
				System.out.println("Hi");
				System.out.println("Hi");
				
				
				
			} catch (InterruptedException e) {
			System.out.println("Thread is terminated and clean up the resources");
			}
			
			
		});
		
		
		t1.start();
		
		try {
			Thread.sleep(2000);
			t1.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
