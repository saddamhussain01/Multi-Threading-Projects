import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	
    public static void main(String[] args) {
    	
        int parties = 3;
        
        CyclicBarrier barrier = new CyclicBarrier(parties, () -> System.out.println("Barrier reached"));

        Runnable task = () -> {
        	
            try {
            	
                System.out.println("Thread is waiting at the barrier.");
                
                barrier.await(); // Wait for all threads to reach the barrier
            
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            
            System.out.println("Thread is continuing after the barrier.");
        };

        for (int i = 0; i < parties; i++) {
            new Thread(task).start();
        }
    }
}
