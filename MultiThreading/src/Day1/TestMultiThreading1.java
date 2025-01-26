package Day1;

public class TestMultiThreading1 {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("T1");
		e1.start();
		
		Manager m1 = new Manager();
		Thread t1 = new Thread(m1, "T2");
		t1.start();
		

	}

}


class Employee extends Thread{
	
	
	public Employee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Hello Saddam " + Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
	}
	
}


class Manager implements Runnable{
	
	

	@Override
	public void run() {
		System.out.println("Hello Hussain " + Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
	}
	
}

