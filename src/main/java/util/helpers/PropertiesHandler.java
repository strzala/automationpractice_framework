package util.helpers;

import util.enums.BrowserType;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
    private static Properties properties;
    public static BrowserType browserParameter;

    public static String baseUri;

    public static void init(){
        browserParameter = BrowserType.CHROME; //BrowserType.valueOf(System.getProperty("browser").toUpperCase());

        properties = new Properties();
        try {
            properties.load(PropertiesHandler.class.getClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseUri = getProperty("baseUri");
    }

    public static String getProperty(String name){
        return properties.getProperty(name);
    }
}
