
public class SharedResourceExample {
    private static int counter = 0; // Shared resource
    
    public synchronized static void incrementCounter() {
    	counter++;
    }
    
    
    
    
    public static void main(String[] args) {
        // Create two threads that increment the counter concurrently
        Thread thread1 = new Thread(() -> { 
			
        	 for (int i = 0; i < 1000; i++) {
        		 incrementCounter(); // Increment the counter
            }
		 
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
            	incrementCounter(); // Increment the counter
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }
}

