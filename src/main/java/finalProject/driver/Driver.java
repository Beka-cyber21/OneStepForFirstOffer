package finalProject.driver;

import finalProject.utilFiles.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver driver ;

    public Driver(WebDriver driver) {
    }

    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browserType").toLowerCase()){
                case "chrome":
                driver = ChromeWebDriver.loadChromeDriver();
                break;
                default:
                    throw  new IllegalArgumentException("Unsupported browser type: "+ ConfigReader.getProperty("browserType"));

            }
        }
        return driver ;
    }
}
