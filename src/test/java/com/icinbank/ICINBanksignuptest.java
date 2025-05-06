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

public class ICINBanksignuptest {
	
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
		public void Signup() {
			
			
			//WebElement loginLink1 = driver.findElement(By.xpath("//a[@href='/signup']"));
			WebElement loginLink1 = driver.findElement(By.xpath("//*[@class='form-group ']"));
			loginLink1.click();
			
			WebElement fname1 = driver.findElement(By.name("firstName"));
			fname1.sendKeys("DEVADEEP");
			
			WebElement lname1 = driver.findElement(By.name("lastName"));
			lname1.sendKeys("DEB");
			
			WebElement phn1 = driver.findElement(By.name("phone"));
			phn1.sendKeys("8860573008");
			
			WebElement eml1 = driver.findElement(By.name("email"));
			eml1.sendKeys("devadeep.deb@gmail.com");
			
			WebElement uname1 = driver.findElement(By.name("username"));
			uname1.sendKeys("devadeepdeb");
			
			WebElement uPwd1 = driver.findElement(By.name("password"));
			uPwd1.sendKeys("devadeepdeb");
			
			WebElement btnLogin2 = driver.findElement(By.xpath("//button[contains(text(),'Sign up!')]"));
			btnLogin2.click();
			
		}
		
		
		@Test
		public void LoginFunctions() {
			
			WebElement name = driver.findElement(By.name("username"));
			name.sendKeys("devadeepdeb");
			
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("devadeepdeb");
			
			WebElement btnlgn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
			btnlgn.click();
			
			WebElement h1 = driver.findElement(By.xpath("//*[contains(text(),'Go to Deposit')]"));
			//WebElement h1 = driver.findElement(By.xpath("//a[@href='/account/deposit']/div/span[@class='pull-left']"));
			h1.click();
			
			Select acctType1 = new Select(driver.findElement(By.id("accountType")));
			acctType1.selectByVisibleText("Primary");
			
			WebElement acctAmt1 = driver.findElement(By.xpath("//input[@id='amount']"));
			acctAmt1.sendKeys("100");
			
			WebElement cl1 = driver.findElement(By.xpath("//button[contains(text(),'Deposit')]"));
			cl1.click();
			
			WebElement h2 = driver.findElement(By.xpath("//a[contains(@href,'/account/primaryAccount')]/div/span[contains(text(),'View Details')]"));
			h2.click();
			
			WebElement h3 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			h3.click();
			
			//driver.navigate().back();
			
			
			WebElement h7 = driver.findElement(By.xpath("//*[contains(text(),'Go to Deposit')]"));
			h7.click();
			
			//Select acctType3 = new Select(driver.findElement(By.xpath("//select[@name='accountType']")));
			Select acctType3 = new Select(driver.findElement(By.id("accountType")));
			acctType3.selectByVisibleText("Savings");
			
			WebElement acctAmt3 = driver.findElement(By.xpath("//input[@id='amount']"));
			acctAmt3.sendKeys("200");
			
			WebElement cl3 = driver.findElement(By.xpath("//button[contains(text(),'Deposit')]"));
			cl3.click();
			
			WebElement h8 = driver.findElement(By.xpath("//a[contains(@href,'/account/savingsAccount')]/div/span[contains(text(),'View Details')]"));
			h8.click();
			
			WebElement h9 = driver.findElement(By.xpath("//a[contains(@href,'/ICINBank')]"));
			h9.click();
			
		}
	
	 @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	 }

}
