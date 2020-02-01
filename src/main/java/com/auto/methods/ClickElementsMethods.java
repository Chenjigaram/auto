package com.auto.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ClickElementsMethods extends SelectElementByType implements BaseTest
{

	private WebElement element=null;
	

	public void click(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		element.click();
	}
	

	public void clickForcefully(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
	}
	

	public void doubleClick(String accessType, String accessValue)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessValue)));

		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
	}
}