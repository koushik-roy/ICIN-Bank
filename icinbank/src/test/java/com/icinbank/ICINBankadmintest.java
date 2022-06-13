package com.icinbank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class ICINBankadmintest {
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
			fname1.sendKeys("GOLAP KANTA");
			
			WebElement lname1 = driver.findElement(By.name("lastName"));
			lname1.sendKeys("DEB");
			
			WebElement phn1 = driver.findElement(By.name("phone"));
			phn1.sendKeys("9953336381");
			
			WebElement eml1 = driver.findElement(By.name("email"));
			eml1.sendKeys("gk_deb1@yahoo.com");
			
			WebElement uname1 = driver.findElement(By.name("username"));
			uname1.sendKeys("gkdeb");
			
			WebElement uPwd1 = driver.findElement(By.name("password"));
			uPwd1.sendKeys("gkdeb");
			
			WebElement btnLogin2 = driver.findElement(By.xpath("//button[contains(text(),'Sign up!')]"));
			btnLogin2.click();
			
		}
	
	 @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	 }

}
