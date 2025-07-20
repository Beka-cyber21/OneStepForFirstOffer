package finalProject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"card mt-4 top-card\"]")
    public List<WebElement> widget;

    @FindBy(xpath = "//div[@class=\"element-list collapse show\"]/ul/li")
    public List<WebElement> accordion;

    public MainPage nameOfWindow(List<WebElement> list) {

        List<String> name = new ArrayList<>();

        for (WebElement nameOfWindows : list) {
            name.add(nameOfWindows.getText());
        }
        for (String windowButton : name) {
            System.out.println(windowButton);
        }
        return this;
    }

    public MainPage selectCase(List<WebElement> list, int index) {
        try {
            webElementActions.scrollToTheElement(list.get(index));
            webElementActions.click(list.get(index));
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Данного индекса нет в листе ");
        }
        return this;
    }


}
