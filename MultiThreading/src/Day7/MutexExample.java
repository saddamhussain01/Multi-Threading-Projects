package Day7;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
	
    public static void main(String[] args) {
    	
        Lock mutex = new ReentrantLock();

        Runnable task = () -> {
        	
            mutex.lock();
            
            try {
                System.out.println("Thread is accessing the shared resource.");
                // Critical section: Only one thread can access here at a time
            } finally {
                mutex.unlock();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
