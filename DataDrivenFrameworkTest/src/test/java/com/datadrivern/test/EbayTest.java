package com.datadrivern.test;

import java.util.Iterator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import com.test.utility.TestUtil;

public class EbayTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
//web driver code
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

    }
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
		
	}

	
	@Test(dataProvider= "getTestData")
	public void ebayRegPageTest(String firstname, String lastname, String emailaddress, String password) {
		//enter data
 		
 		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(emailaddress);
		driver.findElement(By.id("PASSWORD")).clear();
		driver.findElement(By.id("PASSWORD")).sendKeys(password);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
}