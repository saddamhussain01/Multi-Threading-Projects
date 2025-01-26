package Day5;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        
        // Shared buffer with a capacity of 5
        Queue<Integer> buffer = new LinkedList<>();  
        int capacity = 5;

        // Producer thread
        Thread producerThread = new Thread(() -> {
            int item = 1;
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() == capacity) {
                        try {
                            buffer.wait(); // Wait if the buffer is full
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.add(item);
                    System.out.println("Produced item: " + item);
                    item++;
                    buffer.notify(); // Notify the consumer
                }
                try {
                    Thread.sleep(1000); // Simulate time taken to produce an item
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Consumer thread
        Thread consumerThread = new Thread(() -> {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait(); // Wait if the buffer is empty
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int item = buffer.poll();
                    System.out.println("Consumed item: " + item);
                    buffer.notify(); // Notify the producer
                }
                try {
                    Thread.sleep(1500); // Simulate time taken to consume an item
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        producerThread.start();
        consumerThread.start();
    }
}
