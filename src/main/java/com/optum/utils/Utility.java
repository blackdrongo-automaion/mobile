package com.optum.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

public class Utility {

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
