package com.optum.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class AppLauncher {

    static private AppiumDriver driver;

    static MutableCapabilities capabilities;


    public static void init() throws MalformedURLException {
        mobileDriverLauncher();
    }

    public static AppiumDriver getDriver() {
        return AppLauncher.driver;
    }

    private static void mobileDriverLauncher() throws MalformedURLException {
        capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", Config.platformName);
        capabilities.setCapability("appium:deviceName", Config.deviceName);
        capabilities.setCapability("appium:deviceOrientation", Config.deviceOrientation);
        capabilities.setCapability("appium:platformVersion", Config.platformVersion);
        capabilities.setCapability("appium:automationName", Config.automationName);
        capabilities.setCapability("appium:app", Config.app);
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", Config.build);
        sauceOptions.setCapability("name", Config.buildName);
        capabilities.setCapability("sauce:options", sauceOptions);
        URL url = new URL(Config.sauceUrl);
        driver = new AndroidDriver(url, capabilities);
    }

    public static String get_Title(){
        return getDriver().getTitle();
    }

}
