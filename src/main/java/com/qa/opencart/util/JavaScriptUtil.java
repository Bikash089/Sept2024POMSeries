package com.qa.opencart.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	//document, history --all are javascript object
	public String getPageTitleUsingJS() {
		return js.executeScript("return document.title").toString(); 
	}
	
	public String getPageURLUsingJS() {
		return js.executeScript("return document.URL").toString();
	}
	
	public void refreshBrowserByJS() {
		js.executeScript("history.go(0)");
	}
	public void navigateToBackPageByJS() {
		js.executeScript("history.go(0)");
	}
	public void navigateToForwardPageByJS() {
		js.executeScript("history.go(0)");
	}
	public void generateJSAlert(String message) {
	   js.executeScript("alert('" + message + "')");
	}
	public String getPageInnerText() {
		return js.executeScript("return document.documentElement.innerText").toString(); //return text of entire page element
	}
	public void scrollPageDown() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");		
	}
	public void scrollPageUp() {
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");		
	}
	
	public void scrollPageDown(String height) {
        js.executeScript("window.scrollTo(0,'" + height + "')");		
	}
	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);//If argument(element) is one, it will pass through arguments[0]
	}
	
	public void drawBorder(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	//Normal click not working --> use Action click --> JS Click(Going to DOM and clicking)
	//Realtime user not going to use, Its not user based action rather directly taking action from DOM
	public void clickElementByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element); 
	}
	
	public void sendKeysByJSUsingId(String id, String value) {
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
	
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");//Grey
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);//Green
			changeColor(bgcolor, element);//Grey
		}
	}

	private void changeColor(String color, WebElement element) {
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
}
