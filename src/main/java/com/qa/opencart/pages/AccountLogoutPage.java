package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLogoutPage {
	
	private WebDriver driver;


	public AccountLogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
    private By accountLogoutText = By.cssSelector("div#content > p");
    
    public String getSuccessfulLogoutText() {
    	return driver.findElement(accountLogoutText).getText();
    }
    
  
}
	
