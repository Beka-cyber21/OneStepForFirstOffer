package finalProject.helper;

import finalProject.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertAction {

    private WebDriver driver;
    private WebDriverWait wait ;

    // я точно не понял для чего создал этот метод
    public AlertAction() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // этот фрагмент кода переносит внимание на окно alert
    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    //проверяет перейти ли внимание на окно alert
    public boolean isAlertPresent() {
        try {
        driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    //метод, который выбирает "ок" в окне Alert
    public void acceptAlert (){
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            getAlert().accept();
        }catch (TimeoutException e){
            System.out.println("Alert не появился есть ошибка :" + e);
        }
    }

    //метод, который выбирает "dismiss" в окне Alert
    public void dismissAlert(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            getAlert().dismiss();
        }catch (TimeoutException e){
            System.out.println("Alert не появился есть ошибка :" + e);
        }
    }
    // метод для заполнения текст кейса Alert
    public void sendKeys(String text){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            getAlert().sendKeys(text);
        }catch (TimeoutException e){
            System.out.println("Alert не появился есть ошибка :" + e);
        }
    }



}
