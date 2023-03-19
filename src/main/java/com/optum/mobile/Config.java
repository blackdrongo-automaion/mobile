package com.optum.mobile;

import com.optum.utils.Utility;

import java.util.Properties;

public class Config {

    private static final Properties prop = Utility.readProperty("config.properties");


    public static final String filePath = System.getProperty("SAUCE_USERNAME", prop.getProperty("filepath"));






}
