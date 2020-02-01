package com.auto.methods;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SliderMethods extends SelectElementByType implements BaseTest{
	private WebElement element=null;

	public void moveTheSliderRight(String accessType, String accessValue,int xDirection,int yDirection)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessValue)));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(element, xDirection, yDirection).build();
        action.perform();
	}
	public void moveTheSliderLeft(String accessType, String accessValue,int xDirection,int yDirection)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessValue)));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(element, -xDirection, yDirection).build();
        action.perform();
	}
}
