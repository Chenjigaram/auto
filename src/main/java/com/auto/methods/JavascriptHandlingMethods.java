package com.auto.methods;


import com.auto.utilities.DriverUtil;
import org.openqa.selenium.WebDriver;

public class JavascriptHandlingMethods implements BaseTest {
	protected WebDriver driver = DriverUtil.getDefaultDriver();

	public void handleAlert(String decision)
	{
		if(decision.equals("accept"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}
}
