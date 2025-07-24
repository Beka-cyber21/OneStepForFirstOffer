package finalProject.page.mentorFile;

import finalProject.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sber extends BasePage {

    @FindBy(xpath = "//div[@class='MlchtUI-Cover__Children']/a[contains(text(), 'Перейти на платформу')]")
  public WebElement linkForChangePage;

    public void clickOnLinkForChange(){
        webElementActions.click(linkForChangePage);

    }

}
