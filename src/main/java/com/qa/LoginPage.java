package com.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(name = "username")
	private WebElement usernameBox;

	@FindBy(name = "password")
	private WebElement passwordBox;
	
	@FindBy(name = "FormsButton2")
	private WebElement login;
	
	public void typeUsername(String username){
		usernameBox.sendKeys(username);
	}
	
	public void typePassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void login() {
		login.submit();
	}
}
