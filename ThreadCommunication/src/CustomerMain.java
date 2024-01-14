
public class CustomerMain {
	
public static void main(String[] args) {
		
		Customer customer = new Customer(2000);
		
		new Thread() {
			public void run() {
				customer.withdraw(3000);
			}
		}.start();
		
		new Thread(){
			public void run(){
			customer.deposit (2000);
			}
		}.start();
		
	}

}
