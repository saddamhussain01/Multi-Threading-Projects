import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
	
    public static void main(String[] args) {
    	
        Queue<Integer> buffer = new LinkedList<>();
        
        int capacity = 5;

        Thread producerThread = new Thread(() -> {
        	
            int item = 1;
            
            while (true) {
                try {
                    synchronized (buffer) {
                        while (buffer.size() == capacity) {
                            buffer.wait();
                        }
                        buffer.add(item);
                        System.out.println("Produced item: " + item);
                        item++;
                        buffer.notifyAll();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (true) {
                try {
                    synchronized (buffer) {
                        while (buffer.isEmpty()) {
                            buffer.wait();
                        }
                        int item = buffer.poll();
                        System.out.println("Consumed item: " + item);
                        buffer.notifyAll();
                    }
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        // Sleep for some time to allow the threads to run
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
