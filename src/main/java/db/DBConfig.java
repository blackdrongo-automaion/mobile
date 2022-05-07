package db;

import com.optum.utils.Utility;

import java.util.Properties;

public class DBConfig {
    private static final Properties prop = Utility.readProperty("db.properties");


    public static final String dbConfig = System.getProperty("dbConfig", prop.getProperty("db.config"));
    public static final String dbHostUrl = System.getProperty("dbHostUrl", prop.getProperty("db.hostUrl"));
    public static final String userName = System.getProperty("dbHostUrl", prop.getProperty("db.userName"));
    public static final String password = System.getProperty("dbHostUrl", prop.getProperty("db.password"));
}
