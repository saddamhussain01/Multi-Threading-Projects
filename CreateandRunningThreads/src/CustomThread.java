
public class CustomThread implements Runnable {
	
	
	//using Thread class
	//using Runnable interface
	//using callable interface

	public static void main(String[] args) {
		
	
//		Thread t = new Thread(()->{
//			
//			System.out.println("independent path executing in the same program");
//						
//		});
//		t.start();
		
		CustomThread ct = new CustomThread();
		Thread t = new Thread(ct);
		t.start();
	}

	@Override
	public void run() {
		
		System.out.println("using runnable interface the thread is executing the run method");
		
	}
	
	
	

}
