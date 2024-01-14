package com.synchonization;

import com.thread.ATMThread;
import com.thread.GooglePayThread;

public class MainClass {
	
	public static void main(String[] args) {
		
		SbiBank saddamAccount = new SbiBank(7000);
	//	SbiBank raviAccount = new SbiBank(15000);
		
		ATMThread atmThread = new ATMThread(saddamAccount);
		GooglePayThread googlePayThread = new GooglePayThread(saddamAccount);
		
		
		atmThread.setName("ATM");
		googlePayThread.setName("GooglePay");
		
		atmThread.start();
		googlePayThread.start();
		
		
		
		
	}

}
