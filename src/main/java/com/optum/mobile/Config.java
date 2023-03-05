package com.optum.mobile;

import com.optum.utils.Utility;

import java.util.Properties;

public class Config {

    private static final Properties prop = Utility.readProperty("config.properties");


    public static final String sauceUserName = System.getProperty("SAUCE_USERNAME", prop.getProperty("sauce.username"));
    public static final String sauceAccessKey = System.getProperty("SAUCE_ACCESS_KEY", prop.getProperty("sauce.accesskey"));
    public static final String sauceUrl = System.getProperty("sauce_url", prop.getProperty("sauce.url"));
    public static final String buildName = System.getProperty("buildName", prop.getProperty("sauce.buildName"));
    public static final String build = System.getProperty("build", prop.getProperty("sauce.build"));
    public static final String deviceName = System.getProperty("deviceName", prop.getProperty("sauce.deviceName"));
    public static final String deviceOrientation = System.getProperty("deviceName", prop.getProperty("sauce.deviceOrientation"));
    public static final String platformVersion = System.getProperty("deviceName", prop.getProperty("sauce.platformVersion"));
    public static final String automationName = System.getProperty("deviceName", prop.getProperty("sauce.automationName"));
    public static final String app = System.getProperty("app", prop.getProperty("sauce.app"));
    public static final String platformName = System.getProperty("platformName", prop.getProperty("sauce.platform"));




}
