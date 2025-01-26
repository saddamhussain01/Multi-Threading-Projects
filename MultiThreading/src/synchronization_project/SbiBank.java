package synchronization_project;

public class SbiBank {
	
	private  int balance;
	

	public SbiBank(int balance) {
		this.balance = balance;
	}
	
	//If we write static method that is called Class lock
	//If we write instance method that is called object lock
	synchronized public  void withdraw(int withdrawAmount) {
		this.balance=balance-withdrawAmount;
		System.out.println("After withdraw Remaining balance = " + balance );
	}
	
	
	synchronized public void deposit(int depositAmount) {
		this.balance=balance+depositAmount;
		System.out.println("After deposit the balance = " + balance);
	}

}
