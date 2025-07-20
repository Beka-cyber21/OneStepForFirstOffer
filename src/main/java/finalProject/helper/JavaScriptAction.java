package finalProject.helper;

import finalProject.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAction {

    // Это объявление переменной js типа JavascriptExecutor в java
    private JavascriptExecutor js;

    // Это конструктор класса JavaScriptActions, который инициализирует поле js,
    //приводя Driver.getDriver() к типу JavaScriptExecutor.
    public JavaScriptAction (){
        this.js= (JavascriptExecutor) Driver.getDriver();
    }

    //метод для клика элемента при помощи js
    public void clickWithJs(WebElement element){
        js.executeScript("arguments[0].click",element);
    }

    //метод для перелистывания страницы при помощи js до определенного объекта
    public void scrollIntoView(WebElement element){
        js.executeScript("argument[0].scrollIntoView(true);",element);
    }

    // метод для перелистывания страницы на определенное количество пикселей
    public void scrollByPixels(int pixels){
        js.executeScript("window.scrollBy(0,"+pixels+");");
    }

    // метод для обводки поля с которым мы работаем
    public void highlightElement(WebElement element){
        js.executeScript("argument[0].style.border='3px solid yellow'"+element);
    }

    // метод возвращает заголовок страницы
    public String getPageTitle(){
        return (String)js.executeScript("return document.title");
    }

    // Метод возвращает весь текст внутри элемента включая дочерние(Анализ DOM)
    public String getTextWithJS(WebElement element){
        return (String) js.executeScript("return arguments[0].textContent;"+element);
    }

    //Метод показывает только видимый текст(UI)
    public String getVisibleText(WebElement element){
        return (String) js.executeScript("return argument[0].innerText",element);
    }

}
