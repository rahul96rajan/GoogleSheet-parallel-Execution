package com.pratise.googleParallel.action.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeThread implements Runnable  {
	public WebDriver driver = new ChromeDriver(); 
	public void run() {
		driver.get("https://github.com/");		
	}	
	
	public void getUrl(String text) {
		driver.navigate().to("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys(text);
	}

}
