package finalProject.page.mentorFile;

import finalProject.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;

public class AutorotationPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), \"Добро пожаловать!\")]")
    private WebElement welcomeText;

    @FindBy(xpath = "//span[contains(text(), \"Для физических лиц\")]")
    private WebElement forIndividuals;

    @FindBy(xpath = "//span[contains(text(), \"Для юридических лиц\")]")
    private WebElement forLegalEntities;

    @FindBy(xpath = "//div[@id=\"rc-tabs-1-panel-individuals\"]/div/span")
    private WebElement helperText;

    @FindBy(xpath = "//span[contains(text(), \"Войти по Сбер ID\")]")
    private WebElement logInSberId;

    @FindBy(xpath = "//span[contains(text(), \"Войти по СберБизнес ID\")]")
    private WebElement loginInSberBuisinies;

    @FindBy(xpath = "//span[contains(text(), \"Если отсутствует \")]")
    private WebElement littleTextOnLogInPage;

    @FindBy(xpath = "//span/a")
    private WebElement linkForLogOnWallet;

    @FindBy(xpath = "//button/span[contains(text(),\"Создать или восстановить\")]")
    private WebElement buttonForCreateWallet;

    @FindBy(xpath = "//label/span[2]/span[contains(text(),\"Создать новый кошелёк\")]")
    private WebElement checkClickButton;

    @FindBy(id="walletName")
    private WebElement walletName;

    @FindBy(id="walletDescription")
    private WebElement walletDescription;

    @FindBy(xpath = "//div[@class=\"ant-result-title\"]")
    private WebElement antResultTitle;


}
