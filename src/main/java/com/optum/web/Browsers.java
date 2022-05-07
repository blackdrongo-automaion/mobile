package com.optum.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Browsers{

    static private WebDriver driver;
    static ChromeOptions chromeoptions;
    static FirefoxOptions firefoxOptions;
    static InternetExplorerOptions ieOptions;

    static EdgeOptions edgeOptions;
    static SafariOptions safariOptions;

    static DesiredCapabilities capabilities;


    public static void init_browser()  {
        switch(Config.host){
            case"localhost":
                pickBrowserForLocalHost();
                break;
            case"sauceLabs":
                pickBrowserForSauceLabs();
                break;
        }
        driver.manage().window().maximize();
    }


    private static void pickBrowserForLocalHost(){
        switch(Config.browserName){
            case"chrome":
                WebDriverManager.chromedriver().setup();
                setChromeDesiredCapabilities();
                driver = new ChromeDriver(chromeoptions);
                break;
            case"firefox":
                WebDriverManager.firefoxdriver().setup();
                setFireFoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case"ie":
                WebDriverManager.iedriver().setup();
                setIEOptions();
                driver = new InternetExplorerDriver(ieOptions);
                break;
            case"edge":
                WebDriverManager.edgedriver().setup();
                setEdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
            case"safari":
                driver = new SafariDriver();
                break;
        }
    }

    private static void pickBrowserForSauceLabs(){
        switch(Config.browserName){
            case"chrome":
                setChromeDesiredCapabilities();
                driver = RemoteWebDriver.builder()
                        .oneOf(chromeoptions)
                        .setCapability("sauce:options", sauceMapper())
                        .address(Config.sauceUrl)
                        .build();
                break;
            case"firefox":
                setFireFoxOptions();
                driver = RemoteWebDriver.builder()
                        .oneOf(firefoxOptions)
                        .setCapability("sauce:options", sauceMapper())
                        .address(Config.sauceUrl)
                        .build();
                break;
            case"ie":
                setIEOptions();
                driver = RemoteWebDriver.builder()
                        .oneOf(ieOptions)
                        .setCapability("sauce:options", sauceMapper())
                        .address(Config.sauceUrl)
                        .build();
                break;
            case "edge":
                setEdgeOptions();
                driver = RemoteWebDriver.builder()
                        .oneOf(edgeOptions)
                        .setCapability("sauce:options", sauceMapper())
                        .address(Config.sauceUrl)
                        .build();
                break;
            case"safari":
                setSafariOptions();
                driver = RemoteWebDriver.builder()
                        .oneOf(safariOptions)
                        .setCapability("sauce:options", sauceMapper())
                        .address(Config.sauceUrl)
                        .build();
                break;

        }
    }
    public static WebDriver getDriver() {
        return Browsers.driver;
    }

    private static void setChromeDesiredCapabilities(){
        chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--disable-extensions");
        Map<String, Object> prefs = new HashMap<>();
        // To Turns off multiple download warning
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // Turns off download prompt
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
        chromeoptions.setExperimentalOption("prefs", prefs);
        capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        chromeoptions.addArguments("test-type");
        chromeoptions.addArguments("disable-popup-blocking");
        chromeoptions.addArguments("disable-infobars");
        chromeoptions.setPlatformName(Config.platformName);
        chromeoptions.setBrowserVersion(Config.browserVersion);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
    }

    public static void setFireFoxOptions(){
        firefoxOptions  = new FirefoxOptions();
        firefoxOptions.setPlatformName(Config.platformName);
        firefoxOptions.setBrowserVersion(Config.browserVersion);
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
    }

    public static void setIEOptions(){
        ieOptions  = new InternetExplorerOptions();
        ieOptions.setPlatformName(Config.platformName);
        ieOptions.setBrowserVersion(Config.browserVersion);
        ieOptions.setAcceptInsecureCerts(true);
        ieOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
    }

    public static void setEdgeOptions(){
        edgeOptions  = new EdgeOptions();
        edgeOptions.setPlatformName(Config.platformName);
        edgeOptions.setBrowserVersion(Config.browserVersion);
        edgeOptions.setAcceptInsecureCerts(true);
        edgeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
    }

    public static void setSafariOptions(){
        safariOptions  = new SafariOptions();
        safariOptions.setPlatformName(Config.platformName);
        safariOptions.setBrowserVersion(Config.browserVersion);
        safariOptions.setAcceptInsecureCerts(true);
        safariOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
    }

    private static Map<String, Object> sauceMapper(){
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", Config.buildName + ": " + Config.buildVersion);
        sauceOptions.put("username", Config.sauceUserName);
        sauceOptions.put("accessKey", Config.sauceAccessKey);
        return sauceOptions;

    }
    public static void OpenUrl(){
        driver.get(Config.baseUrl);
    }

    public static String get_Title(){
        return getDriver().getTitle();
    }

}
