package com.auto.utilities;

import java.io.File;

public interface WebDriverFactoryConstants {
    File WEB_DRIVER_PATH = new File(System.getProperty("user.dir") + "/webdriver");
    File BROWSER_PATH = new File(System.getProperty("user.dir") + "/browser");
}