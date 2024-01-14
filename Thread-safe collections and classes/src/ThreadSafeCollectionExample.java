import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCollectionExample {
	
    public static void main(String[] args) {
       
    	// Create a thread-safe ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Add key-value pairs to the map
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 8);

        // Create multiple threads to concurrently access and modify the map
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("apple", map.get("apple") + 1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("banana", map.get("banana") + 1);
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for the threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final contents of the map
        System.out.println("Final Map: " + map);
    }
}
