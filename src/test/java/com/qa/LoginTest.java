package com.qa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LoginTest 
{
    WebDriver driver = null;
	
    @Before
	public void method() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
    @Test
    public void loginTest() {
    	driver.get("http://thedemosite.co.uk/");
    	
    	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.directToAddUserPage();	
		
		AddAUserPage addUserPage = PageFactory.initElements(driver, AddAUserPage.class);
		addUserPage.createsUsername("hello");
		addUserPage.createsPassword("password");
		addUserPage.saveDetails();
		addUserPage.directToLoginPage();
    
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.typeUsername("hello");
		loginPage.typePassword("password");
		loginPage.login();
		
		WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", checkElement.getText());
    }
    
    public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.close();
    }
}
