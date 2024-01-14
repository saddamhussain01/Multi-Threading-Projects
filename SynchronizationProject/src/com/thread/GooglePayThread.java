package com.thread;

import com.synchonization.SbiBank;

public class GooglePayThread extends Thread {

	SbiBank sbiBankObject;

	public GooglePayThread(SbiBank sbiBankObject) {

		this.sbiBankObject = sbiBankObject;
	}

	@Override
	public void run() {

		sbiBankObject.deposit(12000);
	}

}
