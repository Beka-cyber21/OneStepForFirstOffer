package finalProject.helper;

import finalProject.driver.Driver;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserAction {
     // Final означает что ссылка не может быть изменена после инициализации в конструкторе
    private WebDriver driver;

    // Конструктор для класса BrowserAction
    public BrowserAction() {
        this.driver = Driver.getDriver();
    }

    public void getUrl(String URL){
        driver.navigate().to(URL);
    }

    // Обновление страницы
    public void refreshPage() {
        driver.navigate().refresh();
    }

    //Возвращает на предыдущую страницу в браузере (аналог кнопки "Назад")
    public void goBack() {
        driver.navigate().back();
    }

    //Метод для перехода на следующую страницу
    public void goForward() {
        driver.navigate().forward();
    }

    // Метод для создания листа для вкладок в браузере
    public List<String> getAllWindowHandles() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    // Метод для переключения между вкладками
    public void switchToWindow(int index) {
        List<String> windows = getAllWindowHandles();
        if (index < windows.size()) {
            driver.switchTo().window(windows.get(index));
        } else {
            System.out.println("Нет такой вкладки " + index);
        }
    }

    // Метод для закрытия окна
    public void closeCurrentWindow(){
        driver.close();
    }

    //метод для открытия окна на полный размер
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    // Метод для расширения окна (С указыванием размера)
    public void setWindowsSize (int width, int height){
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(width,height));
    }

    //Метод для закрытия браузера и все окна, завершает сессию

    public void quitBrowser(){
        if (driver!=null){
            // закрывает ВСЕ окна и останавливает драйвер
            driver.quit();
            // очищаем ссылку (для избежания NPE)
            driver = null;
        }
    }
}
