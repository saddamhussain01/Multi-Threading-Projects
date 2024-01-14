import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
	
    public static void main(String[] args) {
    	
        AtomicReference<String> atomicRef = new AtomicReference<>("Initial Value");

        Runnable updateTask = () -> {
        	
            String newValue = "Updated Value";
            
            atomicRef.set(newValue);
            
            System.out.println("New value: " + atomicRef.get());
            
        };

        new Thread(updateTask).start();
    }
}
