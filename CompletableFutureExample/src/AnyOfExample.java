import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AnyOfExample {
	
    public static void main(String[] args) {
    	
    	//first asynchronous task
    	CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
    	   
    		try {
    	        TimeUnit.SECONDS.sleep(5);
    	    } catch (InterruptedException e) {
    	       throw new IllegalStateException(e);
    	    }
    	    return "Result of Future 1";
    	});
    	
    	//second asynchronous task
    	CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
     	   
    		try {
    	        TimeUnit.SECONDS.sleep(10);
    	    } catch (InterruptedException e) {
    	       throw new IllegalStateException(e);
    	    }
    	    return "Result of Future 2";
    	});
    	
    	
    	//third asynchronous task
    	CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
      	   
    		try {
    	        TimeUnit.SECONDS.sleep(15);
    	    } catch (InterruptedException e) {
    	       throw new IllegalStateException(e);
    	    }
    	    return "Result of Future 3";
    	});

 
    	CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1,future2,future3);

    	try {
			System.out.println(anyOfFuture.get());  
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
