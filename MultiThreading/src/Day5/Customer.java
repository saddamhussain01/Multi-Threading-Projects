package Day5;

public class Customer {
	
	int amount;

	public Customer(int amount) {
		super();
		this.amount = amount;
	}

 
	public synchronized void withdraw(int amount) {
		
		System.out.println("Cheking balance to withdraw " + amount);

		if (this.amount < amount) {
			System.out.println("Current balance is " + this.amount + " which is less then withdraw amount, waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.amount = this.amount - amount;
		System.out.println("Amount:" + amount + " withdrawn from your account. Available balance " + this.amount);
	}

	
	
	public synchronized void deposit(int amount) {
		
		System.out.println("Depositing amount " + amount + ".....");
		
		
		this.amount = this.amount + amount;

		System.out.println("Amount:" + amount + " credited in your account. Available balance: " + this.amount);
		notify();
	}

}