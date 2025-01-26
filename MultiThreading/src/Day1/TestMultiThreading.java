package Day1;

public class TestMultiThreading {

	public static void main(String[] args) {
		
	/* When a thread creates a new thread, the new thread inherits the priority and daemon status of the creating thread.*/
		
	/*A daemon thread is a background thread that runs continuously and automatically ends when all non-daemon (main) threads finish.*/
		
		System.out.println("Hello Welcome To Easy Learning Channel");
	    System.out.println(Thread.activeCount());
	    System.out.println(Thread.currentThread().getName());
	    System.out.println(Thread.currentThread().getId());
	    System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().isDaemon());
        System.out.println(Thread.currentThread().getThreadGroup());
        Thread.currentThread().setName("Saddam Thread");
        System.out.println(Thread.currentThread().getName());
        
	}

}
