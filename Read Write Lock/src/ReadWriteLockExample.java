import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
	
    public static void main(String[] args) {
    	
    	
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        

        Runnable readTask = () -> {
        	
            rwLock.readLock().lock();
            
            try {
                System.out.println("Thread is reading the resource.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwLock.readLock().unlock();
            }
        };

        
        Runnable writeTask = () -> {
        	
            rwLock.writeLock().lock();
            try {
                System.out.println("Thread is writing to the resource.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwLock.writeLock().unlock();
            }
        };

        new Thread(readTask).start();
        new Thread(readTask).start();
        new Thread(writeTask).start();
    }
}
