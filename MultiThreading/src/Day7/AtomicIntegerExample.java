package Day7;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	
    public static void main(String[] args) {
    
    	AtomicInteger atomicInt = new AtomicInteger(0);

        Runnable incrementTask = () -> {
        	
            int newValue = atomicInt.incrementAndGet();
            
            System.out.println("New value: " + newValue);
            
        };

        for (int i = 0; i < 5; i++) {
        	
            new Thread(incrementTask).start();
        }
    }
}
