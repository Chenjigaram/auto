package com.auto.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


final class IEDriverFactory implements WebDriverFactoryConstants {

    private static final String IE_DRIVER_VERSION = "3.13";
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private IEDriverFactory() { }

    static WebDriver IEdriver() {
    	LOG.info("Running in IE");
    	return setupChromeDriver();
    }

    private static WebDriver setupChromeDriver() {
        WebDriverManager
                .iedriver()
                .version(IE_DRIVER_VERSION)
                .targetPath(WEB_DRIVER_PATH.getAbsolutePath())
                .forceCache()
                .setup();
        return new InternetExplorerDriver();
    }

}
