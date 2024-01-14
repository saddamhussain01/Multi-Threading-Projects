package com.thread;

public class ExampleThread implements Runnable{
	
	//Extends thread we can create a Thread Object
	//Implements Runnable we can create a Thread Object
	//Implements Callable we can create a Thread Object

	public static void main(String[] args) {
		
		
		
//		ExampleThread e = new ExampleThread();
		
		// anonymous implementation of the Runnable interface.
		Thread t = new Thread(()->{
			
			System.out.println("hello");
		});
		t.start();
		
		t.setPriority(Thread.MAX_PRIORITY);
		
		int threadPre = t.getPriority();
		
		System.out.println(threadPre);
			
	}

	@Override
	public void run() {
		System.out.println("Independent Path execute in same program");
	}
	
	void display() {
		
		System.out.println("Normal method");
	}
	
	
}
