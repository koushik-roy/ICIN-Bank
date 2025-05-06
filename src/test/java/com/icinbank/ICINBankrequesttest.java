package com.icinbank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class ICINBankrequesttest {

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
			
			WebElement h31 = driver.findElement(By.xpath("//a[contains(text(),'Request')]"));
			h31.click();
			
			WebElement h32 = driver.findElement(By.xpath("//a[contains(text(),'Request New Cheque Book')]"));
			h32.click();
			
			Select acctType9 = new Select(driver.findElement(By.id("account")));
			acctType9.selectByVisibleText("Savings");
			
			WebElement desc1 = driver.findElement(By.id("description"));
			desc1.sendKeys("Please issue cheque book on my Savings Account");
			
			WebElement h33 = driver.findElement(By.xpath("//a[contains(text(),'Submit Request')]"));
			h33.click();
			
			WebElement cl9 = driver.findElement(By.xpath("//button[@data-bb-handler='confirm']"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		    executor1.executeScript("arguments[0].click();", cl9);
			
			//WebElement h34 = driver.findElement(By.xpath("//a[contains(text(),'Me ')]"));
			//h34.click();
			
			//WebElement h35 = driver.findElement(By.xpath("//a[contains(text(),'Profile')]"));
			//h35.click();
			
			//WebElement h36 = driver.findElement(By.xpath("//a[contains(text(),'Me ')]"));
			//h36.click();
			
			//WebElement h37 = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			//h37.click();
			
		}
	
	 @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	 }

}
