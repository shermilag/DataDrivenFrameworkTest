package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"env", "browser", "url","emailid"})
	public void yahooLoginTest(String env, String browser, String url, String emailid) {
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browser.equals("firefox"))
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Drivers\\geckodriver.exe");
	   
	    driver.get(url);
		
	    driver.findElement(By.id("login-username")).clear();
	    driver.findElement(By.id("login-username")).sendKeys(emailid);
	   
	    driver.findElement(By.id("login-signin")).click();
	    
	 
		
	}

}
