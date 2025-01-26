package Day2;

public class SynchronizedBlockOrMethod {

	private static int counter=0;
	
	public static void main(String[] args) {
		
		
		// Create multiple threads that increment the counter
        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//               synchronized (SynchronizedBlockOrMethod.class) {
//				counter++;
//			}
//            }
        	increment();
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
            	
            	synchronized (SynchronizedBlockOrMethod.class) {  //synchronized block
    				counter++;
            	}
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final Count: " + counter);
    }
	
	public synchronized static void increment() {   //synchronized method
		  for (int i = 0; i < 100000; i++) {    
				counter++;
           }

	}
	

	

}
