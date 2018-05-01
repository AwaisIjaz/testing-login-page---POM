package com.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAUserPage {
	
	@FindBy(name = "username")
	private WebElement usernameBox;
	
	@FindBy(name = "password")
	private WebElement passwordBox;
	
	@FindBy(name = "FormsButton2")
	private WebElement save;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginPageButton;
	
	public void createsUsername(String username) {
		usernameBox.sendKeys(username);
	}
	
	public void createsPassword(String password) {
		passwordBox.sendKeys(password);	
	}
	
	public void saveDetails() {
		save.submit();
	}
	
	public void directToLoginPage() {
		loginPageButton.click();
	}
}