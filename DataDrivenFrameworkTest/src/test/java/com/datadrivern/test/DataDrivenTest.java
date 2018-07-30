package com.datadrivern.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		//get data from excel
		
       Xls_Reader reader = new Xls_Reader("C:\\Users\\raghu\\eclipse-workspace\\DataDrivenFrameworkTest"
       		+ "\\src\\test\\java\\com\\testdata\\DDFSheet.xlsx");
		
		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);
	
		String lastname = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);
		
		String emailaddress = reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailaddress);
		
		String password = reader.getCellData("RegTestData", "password", 2);
		System.out.println(password);
		
		//web driver code
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("email")).sendKeys(emailaddress);
		driver.findElement(By.id("PASSWORD")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-prim']")).click();

	}

}
