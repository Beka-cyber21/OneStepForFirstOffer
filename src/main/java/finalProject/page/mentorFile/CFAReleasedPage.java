package finalProject.page.mentorFile;

import finalProject.page.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CFAReleasedPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),\"Цифровые финансовые активы\")]")
    private WebElement mainTextOn ;

    @FindBy(xpath = "//div[@id=\"plasma-uniq-id-13\"]")
    private WebElement chooseEmitet;

    @FindBy(xpath = "//input[@id=\"plasma-uniq-id-470\"]")
    private WebElement searchEmitet;

    @FindBy(xpath = "//ul/li/div[2]/div/div/div/div/div/span")
    private List<WebElement>dropdownSelectEmitent ;

    @FindBy(xpath = "//div[@id=\"plasma-uniq-id-473\"]/div/div/button[1]/div/div")
    public WebElement resultPlacement;

    @FindBy(xpath = "//div[@id=\"plasma-uniq-id-473\"]/div/div/button[2]/div/div")
    public WebElement resultReleaseTookPlace;

    @FindBy(xpath = "//div[@id=\"plasma-uniq-id-473\"]/div/div/button[3]/div/div")
    public WebElement resultIssueCancelled;

    public boolean checkOnMainText(){
        return wait.isElementVisible(mainTextOn);
    }

    public CFAReleasedPage getListEmitents(){
        webElementActions.click(chooseEmitet);
//
//        List<String> cartoonsName = new ArrayList<>();
//        for (WebElement carton : dropdownSelectEmitent) {
//            cartoonsName.add(carton.getText());
//        }
//        for (String name : cartoonsName) {
//            System.out.println(name);
//        }
        try {
            if (dropdownSelectEmitent.isEmpty()){
                System.out.println("Опции не найдены");
            }else{
                System.out.println("Опций найдено :"+ dropdownSelectEmitent.size());
                for (WebElement option : dropdownSelectEmitent){
                    System.out.println(option.getText());
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("Dropdown не появился");
        }
       return this;
    }

    public CFAReleasedPage chooseOneOfElement(String nameOnEmitent){
        webElementActions.click(chooseEmitet);
        for (WebElement option : dropdownSelectEmitent) {
            if (option.getText().contains(nameOnEmitent)){
                jsAction.clickWithJs(option);
                break;
            }
        }
        return this ;
    }

    public CFAReleasedPage getPAOSber(){
        chooseOneOfElement("ПАО СБЕРБАНК");
        webElementActions.sendKeysWithEnter(searchEmitet,"ПАО СБЕРБАНК");
        return this ;
    }

    public boolean getContainsInResult(WebElement element,String result){
        return element.getText().contains(result);
    }


}
