package finalProject.page.mentorFile;

import finalProject.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondaryMarketPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),\"Необходимо авторизоваться\")]")
    private WebElement mainTextOnPage;

    public boolean checkOnMainText(){
       return wait.isElementVisible(mainTextOnPage);
    }
}
