package com.pratise.googleParallel.action.actions;

public class TestChromeThreadTwo {
	public static void main(String[] args) {
		ChromeThread chromeObj = new ChromeThread();
		Thread chr = new Thread(chromeObj);
		chr.start();
	}
}
