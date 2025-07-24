package finalProject.helper;

import finalProject.driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementActions {

    // инициализация действий пользователя (UI)
    public Actions actions = new Actions(Driver.getDriver());
    // я создал этот объект чтоб в дальнейшем писать меньше кода (я про ожидание появление кнопки или до ее кликабельного состояния.)
    public WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    // метод который, будет ждать пока элемент не будет видимым(ExpectedConditions.visibilityOf)
    public WebElementActions waitElementToBeDisplayed(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    //метод который, будет ждать пока элемент не станет кликабельным (ExpectedConditions.elementToBeClickable)
    public WebElementActions waitElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    // Метод который, ждет пока элемент станет невидимым (например нам нужно подождать до следующего действия исчезновения окна или индикатора загрузки
    // (скорее буду использовать для Assert, но это не точно))
    public WebElementActions waitElementTBeDisappear(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
        return this;
    }

    // Метод объединяет в себе два метода до него (Displayed & Clickable)
    public WebElementActions waitToBeClickableAndDisplayed(WebElement element) {
        waitElementToBeDisplayed(element);
        waitElementToBeClickable(element);
        return this;
    }

    // Метод который, нажимает на элемент при помощи Action
    // (если кликать на прямую через WebElement (будет быстрее)нет гарантии, что элемент будет взаимодействовать)
    public WebElementActions click(WebElement element) {
        scrollToTheElement(element).
                waitToBeClickableAndDisplayed(element);
        actions.click(element).perform();
        return this;
    }

    //Метод который, заполняет текстом блоки для ввода теста и т.д
    public WebElementActions sendKeys(WebElement element, String text) {
        scrollToTheElement(element);
        waitElementToBeDisplayed(element);
        actions.sendKeys(element, text).perform();
        return this;
    }

    // Метод который, очищает потом, заполняет блоки для ввода текста.
    //1) Это метод который сразу взаимодействует с элементом (не имитируя пользователя).
    //2) Это метод, который работает если не сработал первый вариант(второй метод уже имитирует действия пользователя)
    public WebElementActions clearAndSendKeys2(WebElement element, String text) {
        try {
            waitToBeClickableAndDisplayed(element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            actions.moveToElement(element).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(text).perform();
        }
        return this;
    }

    // Этот метод имитирует действия пользователя (делает скролл вниз)
    // полное имитирование пользователя
    public WebElementActions scrollDown() throws InterruptedException {
        for (int i = 0; i <= 5; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
        }
        return this;
    }

    //То же самое что и метод указанный выше, только скрол вверх
    public WebElementActions scrollUp() {
        actions.sendKeys(Keys.PAGE_UP).perform();
        return this;
    }

    //
    public WebElementActions scrollToTheElement(WebElement element) {
        actions.scrollToElement(element).perform();
        return this;
    }

    // Метод который, позволяет написать текст в текст-боксе и нажать на Enter
    public WebElementActions sendKeysWithEnter(WebElement element, String text) {
        actions.sendKeys(element, text);
        actions.sendKeys(Keys.ENTER);
        return this;
    }

    public WebElementActions clickEnterInKeyboard(){
        actions.sendKeys(Keys.ENTER);
        return this ;
    }

    /**
     * Дальше идут boolean методы для Assert(получается они идут для проверок для тестов)
     */

    // метод который, проверяет являются ли видимыми
    public boolean isElementToBeClickable(WebElement element) {
        return element.isDisplayed();
    }

    // Метод для проверки елемента кликабелен или нет
    public boolean isElementClickable(WebElement element) {
        try {
            waitElementToBeClickable(element);
            return element.isDisplayed() && element.isEnabled();
            //Возвращает true если кнопка активна
        } catch (Exception e) {
            return false;
            //возвращает false если кнопка неактивна
        }
    }

    // метод для загрузки файла
    public WebElementActions importFiles(WebElement element, String path) {
        try {
            element.sendKeys(path);
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке файла " + e.getMessage());
        }
        return this;
    }
}

