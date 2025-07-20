package finalProject.utilFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader() {

    }

    private static Properties properties;

    static {
        String path = "src/main/resources/app.properties";
        try {
            FileInputStream fis =new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty (String key){return properties.getProperty(key.trim());}
}
