
public class WithoutThreadPool extends Thread{

	@Override
	public void run() {
		System.out.println("without thread pool");
	}
	
	
	
	public static void main(String[] args) {
		
		WithoutThreadPool t1 = new WithoutThreadPool();
		t1.start();
		WithoutThreadPool t2 = new WithoutThreadPool();
		t2.start();
		WithoutThreadPool t3 = new WithoutThreadPool();
		t3.start();
		WithoutThreadPool t4 = new WithoutThreadPool();
		t4.start();
	}

}
