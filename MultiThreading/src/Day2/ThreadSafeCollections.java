package Day2;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCollections {

    public static void main(String[] args) {

        // Using ConcurrentHashMap for thread-safe operations
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("orange", 0);

        // Create multiple threads that increment the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.compute("Apple", (key, value) -> value + 1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.compute("Apple", (key, value) -> value + 1);
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
        System.out.println("Final Count: " + map);
    }
}
