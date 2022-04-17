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
                res = Utility.class.getClassLoader().getResource("drivers/chromedriver.exe");
                break;
        }
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        return absolutePath;
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
