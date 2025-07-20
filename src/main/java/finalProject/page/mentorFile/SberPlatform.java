package finalProject.page.mentorFile;

import finalProject.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberPlatform extends BasePage {

    @FindBy(xpath = "//div[@class=\"zVMbzSYDNXfymNo8OyBW\"]/span")
    private WebElement mainTextOnPlatform;

    @FindBy(xpath = "//div[contains(text(), 'Выпуски ЦФА')]")
    public WebElement cfaReleasedButton;

    @FindBy(xpath = "//div[contains(text(), 'Вторичный рынок')]")
    public WebElement secondaryMarketButton;

    @FindBy(xpath = "//div[contains(text(), 'NFT')]")
    public  WebElement nftButton;

    public SberPlatform clickOnEnyButton(int i) {
        switch (i) {
            case 1:
                webElementActions.click(cfaReleasedButton);
                break;
            case 2:
                webElementActions.click(secondaryMarketButton);
                break;
            case 3:
                webElementActions.click(nftButton);
                break;
            default:
                throw new IndexOutOfBoundsException("вы ввели не верный индекс");
        }
        return this;
    }

    public boolean checkButtonClickable(WebElement element){
        return wait.isElementClickable(element);
    }

    public boolean checkMainTextIsVisible(){
        return wait.isElementVisible(mainTextOnPlatform);
    }





}
