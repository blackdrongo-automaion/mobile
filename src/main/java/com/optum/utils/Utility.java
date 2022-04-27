package com.optum.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

public class Utility {

    public static String get_Path(String filename) throws URISyntaxException {
        URL res = null;
        switch (filename.toLowerCase()) {
            case "chrome":
                res = Utility.class.getClassLoader().getResource(get_driver_path_based_on_os());
                break;
        }
        File file = Paths.get(res.toURI()).toFile();
        return  file.getAbsolutePath();
    }

    public static String get_driver_path_based_on_os(){
        String path = null;
        String os = System.getProperty("os.name");
        switch (os.toLowerCase()){
            case"mac os x":
                path = "drivers/mac/chromedriver";
                break;
            case"windows":
                path = "drivers/win/chromedriver.exe";
                break;
        }
        return path;
    }

    public static Properties readProperty(String FileName) {
        String filepath = "config/"+FileName;
        Properties prop = new Properties();
        try (InputStream input = Utility.class.getClassLoader().getResourceAsStream(filepath)) {
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    }
