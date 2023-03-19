package com.optum.mobile;

import com.optum.apiengine.model.requests.RequestBodyData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AppLauncher {

    static private AppiumDriver driver;

    static DesiredCapabilities capabilities;


    public static void init() throws MalformedURLException {
        mobileDriverLauncher();
    }

    public static AppiumDriver getDriver() {
        return AppLauncher.driver;
    }

    private static void mobileDriverLauncher() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(AppLauncher.class.getClassLoader().getResource(Config.filePath ).getFile()));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        URL url = new URL(data(Config.filePath).get("url"));
        driver = new AndroidDriver(url, capabilities);
    }

    public static String get_Title(){
        return getDriver().getTitle();
    }

    public static JsonPath data(String filePath) {
        JsonPath path = new JsonPath(new File(AppLauncher.class.getClassLoader().getResource(filePath ).getFile()));
        return path;
    }

}
