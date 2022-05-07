package com.optum.web;

import com.optum.utils.Utility;

import java.util.Properties;

public class Config {

    private static final Properties prop = Utility.readProperty("config.properties");

    public static final String baseUrl = System.getProperty("baseUrl", prop.getProperty("webApplication.Url"));
    public static final String browserName = System.getProperty("browserName", prop.getProperty("browser.Name"));
    public static final String host = System.getProperty("host",  prop.getProperty("host"));
    public static final String browserVersion = System.getProperty("browserVersion", prop.getProperty("browser.Version"));
    public static final String platformName = System.getProperty("platformName", prop.getProperty("sauce.platform"));
    public static final String sauceUserName = System.getProperty("SAUCE_USERNAME", prop.getProperty("sauce.username"));
    public static final String sauceAccessKey = System.getProperty("SAUCE_ACCESS_KEY", prop.getProperty("sauce.accesskey"));
    public static final String sauceUrl = System.getProperty("sauce_url", prop.getProperty("sauce.url"));
    public static final String buildName = System.getProperty("buildName", prop.getProperty("sauce.buildName"));
    public static final String buildVersion = System.getProperty("buildVersion", prop.getProperty("sauce.buildNumber"));



}
