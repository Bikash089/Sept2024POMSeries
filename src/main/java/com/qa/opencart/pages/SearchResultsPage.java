package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By productResults = By.cssSelector("div.product-thumb");
	private By myAccount = By.xpath("//ul[@class='list-unstyled']//a[normalize-space()='My Account']");
	
	
	public int getProductResultsCount() {	
		int resultCount = eleUtil.waitForElementsPresence(productResults, AppConstants.DEFAULT_TIME_OUT).size();
		System.out.println("product results count ==>"+ resultCount);
		return resultCount;
		
	}
	
	public ProductInfoPage selectProduct(String productName){
		System.out.println("product name: "+ productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
	
	public HomePage ClickOnMyAccount() {
		eleUtil.waitForElementVisible(myAccount, AppConstants.SHORT_TIME_OUT).click();
		return new HomePage(driver);
	}

}