package com.auto.methods;

import com.auto.utilities.URLProperties;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class NavigateMethods extends SelectElementByType implements BaseTest
{
	private WebElement element=null;
	private String old_win = null;
	private String lastWinHandle;

	public void navigateTo(String url) 
	{
		driver.get(url);
	}

	

	public void navigate(String direction)
	{
		if (direction.equals("back"))
			driver.navigate().back();
		else
			driver.navigate().forward();
	}
	
	public void closeDriver()
	{
		driver.close();
	}
	

	public Keys getKey()
	{
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("win"))
			return Keys.CONTROL;
		else if (os.contains("nux") || os.contains("nix"))
			return Keys.CONTROL;
		else if (os.contains("mac"))
			return Keys.COMMAND;
		else
			return null;
	}
	

	public void zoomInOut(String inOut)
	{
		WebElement Sel=  wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype("tagName","html")));
		if(inOut.equals("ADD"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.ADD));
		else if(inOut.equals("SUBTRACT"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.SUBTRACT));
		else if(inOut.equals("reset"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.NUMPAD0));
	}
	

	public void zoomInOutTillElementDisplay(String accessType,String inOut,String accessName)
	{
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		while(true)
		{
			if (element.isDisplayed())
				break;
			else
				action.keyDown(getKey()).sendKeys(inOut).keyUp(getKey()).perform();
		}
	}
	

	public void resizeBrowser(int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width,height));
	}
	

	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	

	public void hoverOverElement(String accessType, String accessName)
	{
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		action.moveToElement(element).perform();
	}

	public void scrollToElement(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}
	

	public void scrollPage(String to) throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		if (to.equals("end"))
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
            executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}
	

    public void switchToNewWindow()
    {
    	old_win = driver.getWindowHandle();
    	for(String winHandle : driver.getWindowHandles())
    		lastWinHandle = winHandle;
    	driver.switchTo().window(lastWinHandle);
    }
    

    public void switchToOldWindow()
    {
    	driver.switchTo().window(old_win);
    }
    

    public void switchToWindowByTitle(String windowTitle) throws Exception
    {
    	//System.out.println("++"+windowTitle+"++");
    	old_win = driver.getWindowHandle();
    	boolean winFound = false;
    	for(String winHandle : driver.getWindowHandles())
    	{
    		String str = driver.switchTo().window(winHandle).getTitle();
    		//System.out.println("**"+str+"**");
    		if (str.equals(windowTitle))
    		{
    			winFound = true;
    			break;
    		}
    	}
    	if (!winFound)
    		throw new Exception("Window having title "+windowTitle+" not found");
    }


    public void closeNewWindow()
    {
    	driver.close();
    }
    

    public void switchFrame(String accessType, String accessName)
    {
    	if(accessType.equalsIgnoreCase("index"))
    		driver.switchTo().frame(accessName);
    	else
    	{
    		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    		driver.switchTo().frame(element);
    	}
    }
    
    public void switchToDefaultContent()
    {
    	driver.switchTo().defaultContent();
    }
}
