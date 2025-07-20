package finalProject.page.mentorFile;

import finalProject.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CFAReleasedPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),\"Цифровые финансовые активы\")]")
    private WebElement mainTextOn ;

    public boolean checkOnMainText(){
     return wait.isElementVisible(mainTextOn);
    }
}
