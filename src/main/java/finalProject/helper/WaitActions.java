package finalProject.helper;

import finalProject.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitActions {

    private final WebDriver driver ;

    private final WebDriverWait wait;

    public WaitActions() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Универсальный метод-обёртка для булевых ожиданий
    private <T> boolean waitSafely(Function<WebDriver,T>conditions){
        try {
            wait.until(conditions);
            return true ;
        }catch (TimeoutException e){
            return false ;
        }
    }

    public void justWait(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // метод ждет пока элемент, становится видимым
    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // метод ждет пока элемент, становится кликабельным
    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // метод ждет пока элемент, становится не видимым
    public void waitUntilInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // метод ждет пока элемент, становится не видимым
    public void waitUntilPresent(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // метод ждет пока в элементе, не будет указанного текста
    public void waitUntilTextPresent(WebElement element,String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    // метод ждет пока не появится Alert
    public void waitUntilAlertIsPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }


    // метод ждет пока в URL не появится фрагмент URL
    public void waitUntilContains(String fragment){
        wait.until(ExpectedConditions.urlContains(fragment));
    }

    /**
     *
     * Boolean версии (Для Assert проверок )
     *
     */

    // метод ждет пока элемент, становится видимым
    public boolean isElementVisible(WebElement element){
        return waitSafely(ExpectedConditions.visibilityOf(element));
    }

    // метод ждет пока элемент, становится кликабельным
    public boolean isElementClickable(WebElement element){
        return waitSafely(ExpectedConditions.elementToBeClickable(element));
    }

    // метод ждет пока элемент, становится не видимым
    public boolean isElementInvisible(WebElement element){
        return waitSafely(ExpectedConditions.invisibilityOf(element));
    }

    // метод ждет пока элемент, становится не видимым
    public boolean isElementPresent(By locator){
        return waitSafely(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // метод ждет пока в элементе, не будет указанного текста
    public boolean isTextPresentInElement(WebElement element, String text){
        return waitSafely(ExpectedConditions.textToBePresentInElement(element,text));
    }

    // метод ждет пока не появится Alert
    public boolean isAlertPresent(){
        return waitSafely(ExpectedConditions.alertIsPresent());
    }

    // метод ждет пока в URL не появится фрагмент URL
    public boolean doesUrlContains(String fragment){
        return waitSafely(ExpectedConditions.urlContains(fragment));
    }


}
