package com.auto.methods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AssertionMethods extends SelectElementByType implements BaseTest
{
	private WebElement element=null;
		
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	

	public void checkTitle(String title,boolean testCase) throws TestCaseFailed
	{
		String pageTitle = getPageTitle();
		
		if(testCase)
		{
			if(!pageTitle.equals(title))
				throw new TestCaseFailed("Page Title Not Matched,Given "+title+" Actual Page Title : "+pageTitle);
		}
		else
		{
			if(pageTitle.equals(title))
				throw new TestCaseFailed("Page Title Matched,Given "+title+" Actual Page Title : "+pageTitle);
		}
	}
	

	public void checkPartialTitle(String partialTitle,boolean testCase) throws TestCaseFailed
	{
		String pageTitle = getPageTitle();
		if(testCase)
		{
			if(!pageTitle.contains(partialTitle))
				throw new TestCaseFailed("Partial Page Title Not Present,Given "+partialTitle+" Actual Page Title : "+pageTitle);
		}
		else
		{
			if(pageTitle.contains(partialTitle))
				throw new TestCaseFailed("Partial Page Title Present,Given "+partialTitle+" Actual Page Title : "+pageTitle);
		}
	}


	public String getElementText(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getText();
		
	}
	

	public void checkElementText(String accessType,String actualValue,String accessName,boolean testCase) throws TestCaseFailed
	{
		String elementText = getElementText(accessType, accessName);
		if (testCase)
		{
			if (!elementText.equals(actualValue))
				throw new TestCaseFailed("Given text "+actualValue+",actual text "+elementText+", Text Not Matched");
		}
		else
		{
			if (elementText.equals(actualValue))
				throw new TestCaseFailed("Given text "+actualValue+",actual text "+elementText+", Text  Matched");
		}
	}
	

	public void checkElementPartialText(String accessType,String actualValue,String accessName,boolean testCase) throws TestCaseFailed
	{
		String elementText = getElementText(accessType, accessName);

	    if (testCase)
	    {
	    	if (!elementText.contains(actualValue))
	    		throw new TestCaseFailed("Given text "+actualValue+",actual text "+elementText+", Text Not Matched");
	    }
	    else
	    {
	    	if (elementText.contains(actualValue))
	    		throw new TestCaseFailed("Given text "+actualValue+",actual text "+elementText+", Text Matched");
	    }
	}
	

	public boolean isElementEnabled(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.isEnabled();
	}
	

	public void checkElementEnable(String accessType, String accessName, boolean testCase) throws TestCaseFailed
	{
		boolean result=isElementEnabled(accessType,accessName);
		if(testCase)
		{
			if (!result)
				throw new TestCaseFailed("Element Not Enabled");
		}
		else 
		{ 
			 if(result)
				 throw new TestCaseFailed("Element Enabled");
		}
	}	  
	

	public String getElementAttribute(String accessType,String accessName,String attributeName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getAttribute(attributeName);
	}
	

	public void checkElementAttribute(String accessType, String attributeName, String attributeValue, String accessName, boolean testCase) throws TestCaseFailed
	{
		String attrVal = getElementAttribute(accessType, accessName, attributeName);
		if(testCase)
		{
			if(!attrVal.equals(attributeValue))
				throw new TestCaseFailed("Given Attribute "+attributeName+",actual Attribute "+attrVal+", Attribute Not Matched");
		}
		else 
		{
			if(attrVal.equals(attributeValue))
				throw new TestCaseFailed("Given Attribute "+attributeName+",actual Attribute "+attrVal+", Attribute  Matched");
		}
	}
	

	public boolean isElementDisplayed(String accessType,String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.isDisplayed();
	}
	

	public void checkElementPresence(String accessType,String accessName,boolean testCase) throws TestCaseFailed
	{
		if (testCase)
		{
			if (!isElementDisplayed(accessType, accessName))
				throw new TestCaseFailed("Element Not Present");
		}
		else
		{
			try
			{
				if(isElementDisplayed(accessType, accessName))
					throw new Exception("Present"); //since it is negative test and we found element
			}
			catch(Exception e)
			{
				if(e.getMessage().equals("Present")) //only raise if it present
					throw new TestCaseFailed("Element Present");
			}
		}
	}
	

	public void isCheckboxChecked(String accessType,String accessName,boolean shouldBeChecked) throws TestCaseFailed
	{
		WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if((!checkbox.isSelected()) && shouldBeChecked)
			throw new TestCaseFailed("Checkbox is not checked");
		else if(checkbox.isSelected() && !shouldBeChecked)
			throw new TestCaseFailed("Checkbox is checked");
	}
	

	public void isRadioButtonSelected(String accessType,String accessName,boolean shouldBeSelected) throws TestCaseFailed
	{
		WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if((!radioButton.isSelected()) && shouldBeSelected)
			throw new TestCaseFailed("Radio Button not selected");
		else if(radioButton.isSelected() && !shouldBeSelected)
			throw new TestCaseFailed("Radio Button is selected");
	}


	public void isOptionFromRadioButtonGroupSelected(String accessType,String by,String option,String accessName,boolean shouldBeSelected) throws TestCaseFailed
	{
		List<WebElement> radioButtonGroup = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getelementbytype(accessType, accessName)));
		
		for (WebElement rb : radioButtonGroup) {
			if(by.equals("value"))
			{
				if(rb.getAttribute("value").equals(option))
				{
					if((!rb.isSelected()) && shouldBeSelected)
						throw new TestCaseFailed("Radio Button not selected");
					else if(rb.isSelected() && !shouldBeSelected)
						throw new TestCaseFailed("Radio Button is selected");
				}
			}
			else if(rb.getText().equals(option))
			{
				if((!rb.isSelected()) && shouldBeSelected)
					throw new TestCaseFailed("Radio Button not selected");
				else if(rb.isSelected() && !shouldBeSelected)
					throw new TestCaseFailed("Radio Button is selected");
			}
		}
	}
	

	public String getAlertText()
	{
		return driver.switchTo().alert().getText();
	}
	  

	public void checkAlertText(String text) throws TestCaseFailed
	{
		if(!getAlertText().equals(text))
			throw new TestCaseFailed("Text on alert pop up not matched");
	}
	

	public void isOptionFromDropdownSelected(String accessType,String by,String option,String accessName,boolean shouldBeSelected) throws TestCaseFailed
	{
		Select selectList=null;
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		
		String actualValue="";
		if(by.equals("text"))
			actualValue = selectList.getFirstSelectedOption().getText();
		else
			actualValue = selectList.getFirstSelectedOption().getAttribute("value");
		
		if((!actualValue.equals(option))&&(shouldBeSelected))
			throw new TestCaseFailed("Option Not Selected From Dropwdown");
		else if ((actualValue.equals(option))&&(!shouldBeSelected))
			throw new TestCaseFailed("Option Selected From Dropwdown");
	}

	public void  selectOptionSize(String length , String accessType, String accessName) throws TestCaseFailed
	{
		Select selectList=null;
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		
		selectList = new Select(dropdown);
		int size = selectList.getOptions().size();
		if(!length.equals(""+size)) {
			throw new TestCaseFailed("Expected length : "+length+" got "+size);
		}
		
		
	}

	public void  selectOptionPresent(String value ,boolean needed, String accessType, String accessName) throws TestCaseFailed
	{
		Select selectList=null;
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		boolean valuepresent = false;
		for(WebElement web :selectList.getOptions()) {
			if(web.getText().equals(value))
				valuepresent = true;
		}
		if(needed) {
			if(!valuepresent)
				throw new TestCaseFailed("Given Value "+value+" not found");
		}else {
			if(valuepresent)
				throw new TestCaseFailed("Given Value "+value+" found");
		}
		
	}
	
	public void saveElementText(String accessType, String accessName ,String variableName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		String value = element.getText();
		SavingElementsMethods.putValue(variableName, value);	
	}
	
	public void saveElementTextAttribute(String accessType, String accessName ,String variableName,String attribute)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		String value = element.getAttribute(attribute);
		SavingElementsMethods.putValue(variableName, value);	
	}
	
	public void valueSavingKey(String variableName,String value) {
		SavingElementsMethods.putValue(variableName, value);
	}
	
	public void valueSavingKeyFromMap(String variableName,String value) {
		SavingElementsMethods.putValue(variableName, SavingElementsMethods.getValue(value));
	}
	public void verifyTwoTexts(Boolean testCase,String key1,String key2) throws TestCaseFailed {
		String value1 = SavingElementsMethods.getValue(key1);
		String value2 = SavingElementsMethods.getValue(key2);
	    if (testCase)
	    {
	    	if (!value1.equals(value2))
	    		throw new TestCaseFailed("key1 text "+value1+",key2 text "+value2+", Text Not Matched");
	    }
	    else
	    {
	    	if (value1.equals(value2))
	    		throw new TestCaseFailed("key1 text "+value1+",key2 text "+value2+", Text Matched");
	    }
	}
	public void verifyTwoTextGiven(Boolean testCase,String key1,String value2) throws TestCaseFailed {
		String value1 = SavingElementsMethods.getValue(key1);
	    if (testCase)
	    {
	    	if (!value1.equals(value2))
	    		throw new TestCaseFailed("key1 text "+value1+",key2 text "+value2+", Text Not Matched");
	    }
	    else
	    {
	    	if (value1.equals(value2))
	    		throw new TestCaseFailed("key1 text "+value1+",key2 text "+value2+", Text Matched");
	    }
	}
	
	public void verifyElementTextToKey(Boolean testCase,String accessType, String accessName ,String key) throws TestCaseFailed {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		String value1 = element.getText();
		String value2 = SavingElementsMethods.getValue(key);
	    if (testCase)
	    {
	    	if (!value1.equals(value2))
	    		throw new TestCaseFailed("element text "+value1+",key text "+value2+", Text Not Matched");
	    }
	    else
	    {
	    	if (value1.equals(value2))
	    		throw new TestCaseFailed("element text "+value1+",key text "+value2+", Text Matched");
	    }
	}
	
	public void verifyElementTextAttributeToKey(Boolean testCase,String accessType, String accessName ,String key,String attribute) throws TestCaseFailed {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		String value1 = element.getAttribute(attribute);
		String value2 = SavingElementsMethods.getValue(key);
	    if (testCase)
	    {
	    	if (!value1.equals(value2))
	    		throw new TestCaseFailed("element text with attribute "+ attribute+" "+value1+",key text "+value2+", Text Not Matched");
	    }
	    else
	    {
	    	if (value1.equals(value2))
	    		throw new TestCaseFailed("element text with attribute "+ attribute+" "+value1+",key text "+value2+", Text Matched");
	    }
	}
}
