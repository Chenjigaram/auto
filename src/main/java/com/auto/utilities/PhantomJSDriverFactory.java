package com.auto.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

final class PhantomJSDriverFactory implements WebDriverFactoryConstants {

    private static String SPOOF_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.130 Safari/537.36";

    private PhantomJSDriverFactory() {
    }

    static WebDriver phantomjsDriver() {
        return setupPhantomjsDriver(phantomjsCapabilities());
    }

    private static WebDriver setupPhantomjsDriver(DesiredCapabilities desiredCapabilities) {
        WebDriverManager
                .phantomjs()
                .targetPath(WEB_DRIVER_PATH.getAbsolutePath())
                .forceCache()
                .setup();
        return new PhantomJSDriver(desiredCapabilities);
    }

    private static DesiredCapabilities phantomjsCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setPlatform(Platform.WIN10);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "viewportSize", "1600,1200");
        caps.setCapability("phantomjs.page.viewportSize", "1600,1200");
        //caps.setCapability("phantomjs.page.viewportSize", new Dimension(1600,1200));
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", SPOOF_USER_AGENT);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "User-Agent", SPOOF_USER_AGENT);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_CUSTOMHEADERS_PREFIX + "User-Agent", SPOOF_USER_AGENT);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, cliArgs());
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgs());
        return caps;
    }

    private static String[] cliArgs() {
        return new String[]{
                "--web-security=false",
                "--ssl-protocol=any",
                "--ignore-ssl-errors=true",
              //"--proxy=" + PROXY_URL,
                "--webdriver-loglevel=INFO"
        };
    }

}
