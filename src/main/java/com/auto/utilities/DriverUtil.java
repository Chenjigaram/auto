package com.auto.utilities;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
    public static long DEFAULT_WAIT = 20;
    protected static WebDriver driver;

    public static WebDriver getDefaultDriver() {
		if (driver != null) {
			return driver;
		}
		driver = Browser.newDriver();
        return driver;
    }


    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector,
                                                            int seconds) {
        By selection = By.cssSelector(selector);
        return (new WebDriverWait(driver, seconds)).until( // ensure element is visible!
                ExpectedConditions.visibilityOfElementLocated(selection));
    }

	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.close();
				driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {} // in case close fails
			driver = null;
		}
	}
}
