package synchronization_project;


public class ATMThread extends Thread{
	
	SbiBank sbiBankObject;
	
	
	public ATMThread(SbiBank sbiBankObject) {
		this.sbiBankObject = sbiBankObject;
	}


	@Override
	public void run() {
		
		sbiBankObject.withdraw(3000);
	}

}
