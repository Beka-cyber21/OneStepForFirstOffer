package finalProject.driver;

import finalProject.utilFiles.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static finalProject.utilFiles.ConfigReader.getProperty;

public class ChromeWebDriver {
//    public static WebDriver loadChromeDriver() {
//        WebDriverManager.chromedriver().setup();

    private static WebDriver driver;

    public static WebDriver loadChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu"); // Важно для headless
            options.addArguments("--window-size=1920,1080"); // Обязательно для headless

            // Новый headless режим для Chrome >=109
            if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
                options.addArguments("--headless=new");
            }

            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}



