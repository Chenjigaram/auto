package com.auto.utilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

final class SaucelabsDriverFactory implements WebDriverFactoryConstants {

    private static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private SaucelabsDriverFactory() {
    }

    static RemoteWebDriver saucelabsDriver() {
        String URLlie = "http://" + URLProperties.get("saucelabs.username") + ":" + URLProperties.get("saucelabs.password").trim() + "@localhost:4445/wd/hub";
        RemoteWebDriver remoteWebDriver;
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "latest");
        LOG.info("Saucelabs caps set " + URLlie);
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(URLlie), caps);
        } catch (MalformedURLException e) {
            LOG.info("Saucelabs URL not correct" + URLlie);
            throw new RuntimeException(e);
        }
        return remoteWebDriver;
    }
}

