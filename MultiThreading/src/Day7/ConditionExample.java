package Day7;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
	
    public static void main(String[] args) {
    	
        ReentrantLock lock = new ReentrantLock();
        
        Condition condition = lock.newCondition();
        

        Runnable waitingTask = () -> {
            lock.lock();
            try {
                System.out.println("Thread is waiting.");
                condition.await(); // Wait until signaled
                System.out.println("Thread is awake.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };

        Runnable signalingTask = () -> {
            lock.lock();
            try {
                System.out.println("Thread is signaling.");
                condition.signal(); // Signal waiting threads
            } finally {
                lock.unlock();
            }
        };

        Thread waitingThread = new Thread(waitingTask);
        
        Thread signalingThread = new Thread(signalingTask);

        waitingThread.start();
        signalingThread.start();
    }
}
