package finalProject.page.demoQA.elements;

import finalProject.helper.randomGenerete.UserGenerate;
import finalProject.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TextBox extends BasePage {

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(xpath = "//div[@id=\"permanentAddress-wrapper\"]/div[2]")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(xpath = "//div[@id=\"output\"]/div/p")
    private List<WebElement> outputText;

    private List<String> createNewUser ;

    private TextBox putInList() {
        createNewUser= new ArrayList<>();
        createNewUser.add(UserGenerate.getFullName());
        createNewUser.add(UserGenerate.getEmail());
        createNewUser.add(UserGenerate.getStreetAddress());
        createNewUser.add(UserGenerate.getCountry());
        return this;
    }

    private TextBox enterToCase() {
        webElementActions.sendKeys(userName, "ehrofwijpkdwap'")
                .sendKeys(userEmail, "nbhdiemd@gmail.com")
                .sendKeys(currentAddress, "erindromeawvpomv")
                .sendKeys(permanentAddress, "dngbudienlw");
        return this;
    }

    private TextBox clickOnSubmit() {
        webElementActions.click(submit);
        return this ;
    }

    public void enterDataInBoxForTest() {
        enterToCase().clickOnSubmit();
    }

    public boolean checkOnText() {
        if (outputText.size()!=createNewUser.size()){
            return false;
        }
        for (int i = 0; i < createNewUser.size(); i++) {
            if (!outputText.get(i).getText().equals(createNewUser.get(i))) {
                return false;
            }
        }
        return true;
    }

    public TextBox createNewUser(){
        webElementActions.sendKeys(userName,UserGenerate.getFullName())
                .click(userEmail)
                .sendKeys(userEmail,UserGenerate.getEmail());
        return this;
    }
}
