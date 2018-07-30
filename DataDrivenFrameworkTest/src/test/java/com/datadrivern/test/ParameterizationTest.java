package com.datadrivern.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizationTest {

	public static void main(String[] args) {
		
		//web driver code
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//get data from excel
		
	       Xls_Reader reader = new Xls_Reader("C:\\Users\\raghu\\eclipse-workspace\\DataDrivenFrameworkTest"
	       		+ "\\src\\test\\java\\com\\testdata\\DDFSheet.xlsx");
           int rowCount =  reader.getRowCount("RegTestData");
           
           
        //to add a status column    
           reader.addColumn("RegTestData", "status");
	     
	       
	      //parameterization 
	      
	      for(int rowNum = 2; rowNum<=rowCount; rowNum++) {
	    	String firstname =  reader.getCellData("RegTestData", "firstname", rowNum);
	    	System.out.println(firstname);
	    	  
	 		String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
	 		System.out.println(lastname);
	 		
	 		String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
	 		System.out.println(emailaddress);
	 		
	 		String password = reader.getCellData("RegTestData", "password", rowNum);
	 		System.out.println(password);
	 		
	 		
	 		
	 		//enter data
	 		
	 		driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("firstname")).sendKeys(firstname);
			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("lastname")).sendKeys(lastname);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(emailaddress);
			driver.findElement(By.id("PASSWORD")).clear();
			driver.findElement(By.id("PASSWORD")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-prim']")).click();
			
			
			reader.setCellData("RegTestData", "status", rowNum, "Pass");
			
			
	      }
	       
	       
	}

}
