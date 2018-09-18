package com.pratise.googleParallel.action.actions;

public class TestChromeThread {	
	
	public static void main(String[] args) {
		ChromeThread chromeObj = new ChromeThread();
		Thread C = new Thread(chromeObj,"Chrome Thread");
		C.start();

		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		chromeObj.getUrl("rahul");
	}
}
