package com.icinbank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class ICINBanktransfertest {

	@Autowired
	WebDriver driver;

    @BeforeEach
	public void Setup() {
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		
		
		driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:7070/index");
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		
		}		
		
		@Test
		public void LoginFunctions() {
			
			WebElement name = driver.findElement(By.name("username"));
			name.sendKeys("devadeepdeb");
			
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("devadeepdeb");
			
			WebElement btnlgn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
			btnlgn.click();
			
			WebElement h13 = driver.findElement(By.xpath("//a[contains(text(),'Transfer')]"));
			h13.click();
			
			WebElement h14 = driver.findElement(By.xpath("//a[contains(text(),'Between Accounts')]"));
			h14.click();
			
			Select acctType5 = new Select(driver.findElement(By.xpath("//select[@name='transferFrom']")));
			acctType5.selectByVisibleText("Primary");
			
			WebElement acctAmt5 = driver.findElement(By.xpath("//input[@id='amount']"));
			acctAmt5.sendKeys("10");
			
			WebElement cl5 = driver.findElement(By.xpath("//button[contains(text(),'Transfer')]"));
			cl5.click();
			
			//WebElement h15 = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			//h15.click();
			
			//WebElement h16 = driver.findElement(By.xpath("//a[contains(text(),'Primary')]"));
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
		    //executor.executeScript("arguments[0].click();", h16);
			//h16.click();
			
			//WebElement h17 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			//h17.click();
			
			//WebElement h18 = driver.findElement(By.xpath("//a[contains(text(),'Transfer')]"));
			//h18.click();
			
			//WebElement h181 = driver.findElement(By.xpath("//a[contains(text(),'Between Accounts')]"));
			//h181.click();
			
			//Select acctType6 = new Select(driver.findElement(By.xpath("//select[@name='transferFrom']")));
			//acctType6.selectByVisibleText("Savings");
			
			//WebElement acctAmt6 = driver.findElement(By.xpath("//input[@id='amount']"));
			//acctAmt6.sendKeys("10");
			
			//WebElement cl6 = driver.findElement(By.xpath("//button[contains(text(),'Transfer')]"));
			//cl6.click();
			
			//WebElement h19 = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			//h19.click();
			
			//WebElement h20 = driver.findElement(By.xpath("//a[contains(text(),'Savings')]"));
			//h20.click();
			
			//WebElement h21 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			//h21.click();
			
			WebElement h22 = driver.findElement(By.xpath("//a[contains(text(),'Transfer')]"));
			h22.click();
			
			WebElement h23 = driver.findElement(By.xpath("//a[contains(text(),'Add/Edit Recipient')]"));
			h23.click();
			
			WebElement name1 = driver.findElement(By.id("recipientName"));
			name1.sendKeys("Ram");
			
			WebElement em2 = driver.findElement(By.id("recipientEmail"));
			em2.sendKeys("ram@abc.com");
			
			WebElement ph2 = driver.findElement(By.id("recipientPhone"));
			ph2.sendKeys("1234567890");
			
			WebElement addr = driver.findElement(By.id("recipientAccountNumber"));
			addr.sendKeys("123456");
			
			WebElement desc = driver.findElement(By.id("recipientDescription"));
			desc.sendKeys("My Friend");
			
			WebElement cl7 = driver.findElement(By.xpath("//button[contains(text(),'Add/Edit Recipient')]"));
			cl7.click();
			
			WebElement h24 = driver.findElement(By.xpath("//a[contains(text(),'Ram')]"));
			h24.click();
			
			WebElement addr1 = driver.findElement(By.id("recipientAccountNumber"));
			addr1.sendKeys("1234567");
			
			WebElement h25 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			h25.click();
			
			WebElement h26 = driver.findElement(By.xpath("//a[contains(text(),'Transfer')]"));
			h26.click();
			
			WebElement h27 = driver.findElement(By.xpath("//a[contains(text(),'To Someone Else')]"));
			h27.click();
			
			Select acctType7 = new Select(driver.findElement(By.id("recipientName")));
			acctType7.selectByVisibleText("Ram");
			
			Select acctType8 = new Select(driver.findElement(By.id("accountType")));
			acctType8.selectByVisibleText("Savings");
			
			WebElement acctAmt7 = driver.findElement(By.xpath("//input[@id='amount']"));
			acctAmt7.sendKeys("10");
			
			WebElement cl8 = driver.findElement(By.xpath("//button[contains(text(),'Transfer')]"));
			cl8.click();
			
			WebElement h28 = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			h28.click();
			
			WebElement h29 = driver.findElement(By.xpath("//a[contains(text(),'Savings')]"));
			h29.click();
			
			WebElement h30 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			h30.click();
						
		}
	
	 @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	 }

}
