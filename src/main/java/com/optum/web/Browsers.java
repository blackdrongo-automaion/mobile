package com.optum.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.optum.utils.Utility;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Browsers {

    static private WebDriver driver;
    ChromeOptions options;
    Properties prop = Utility.readProperty("config.properties");

    public Browsers init_browser() throws Exception {
        System.setProperty("webdriver.chrome.driver", Utility.get_Path(prop.getProperty("browser.Name")));
        switch(prop.getProperty("browser.Name")){
            case"chrome":
                setChromeDesiredCapabilities();
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                break;
        }
        return this;
    }

    public static WebDriver getDriver() {
        return Browsers.driver;
    }

    private void setChromeDesiredCapabilities(){
        options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        Map<String, Object> prefs = new HashMap<String, Object>();
        // To Turns off multiple download warning
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // Turns off download prompt
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("test-type"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("browserName", prop.getProperty("browser.Name"));
        capabilities.setCapability("version", prop.getProperty("browser.Version"));
    }

    public Browsers OpenUrl(){
        driver.get(prop.getProperty("webApplication.Url"));
        return this;
    }





}
