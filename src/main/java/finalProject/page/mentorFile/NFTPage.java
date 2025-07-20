package finalProject.page.mentorFile;

import finalProject.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NFTPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),\"NFT-маркетинг\")]")
    private WebElement mainTextOfNftPage;

    @FindBy(xpath = "//span[contains(text(),\"Войти на платформу\")]")
    private WebElement logInToThePlatform ;

    public boolean visibleOnMainText() {
        return wait.isElementVisible(mainTextOfNftPage);
    }
}
