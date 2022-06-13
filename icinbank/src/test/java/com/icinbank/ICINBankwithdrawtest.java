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

public class ICINBankwithdrawtest {
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
			
			WebElement h4 = driver.findElement(By.xpath("//*[contains(text(),'Go to Withdrawal')]"));
			//WebElement h4 = driver.findElement(By.xpath("//a[@href='/account/withdraw']/div/span[@class='pull-left']"));
			h4.click();
			
			Select acctType2 = new Select(driver.findElement(By.id("accountType")));
			acctType2.selectByVisibleText("Primary");
			
			WebElement acctAmt2 = driver.findElement(By.xpath("//input[@id='amount']"));
			acctAmt2.sendKeys("20");
			
			WebElement cl2 = driver.findElement(By.xpath("//button[contains(text(),'Withdraw')]"));
			cl2.click();
			
			WebElement h5 = driver.findElement(By.xpath("//a[contains(@href,'/account/primaryAccount')]/div/span[contains(text(),'View Details')]"));
			h5.click();
			
			WebElement h6 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			h6.click();
			
			WebElement h10 = driver.findElement(By.xpath("//*[contains(text(),'Go to Withdrawal')]"));
			h10.click();
			
			//Select acctType4 = new Select(driver.findElement(By.xpath("//select[@name='accountType']")));
			Select acctType4 = new Select(driver.findElement(By.id("accountType")));
			acctType4.selectByVisibleText("Savings");
			
			WebElement acctAmt4 = driver.findElement(By.xpath("//input[@id='amount']"));
			acctAmt4.sendKeys("40");
			
			WebElement cl4 = driver.findElement(By.xpath("//button[contains(text(),'Withdraw')]"));
			cl4.click();
			
			WebElement h11 = driver.findElement(By.xpath("//a[contains(@href,'/account/savingsAccount')]/div/span[contains(text(),'View Details')]"));
			h11.click();
			
			WebElement h12 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			h12.click();
			
					
		}
	
	 @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	 }


}
