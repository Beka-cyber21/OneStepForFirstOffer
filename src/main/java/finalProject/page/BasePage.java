package finalProject.page;

import finalProject.driver.Driver;
import finalProject.helper.JavaScriptAction;
import finalProject.helper.WaitActions;
import finalProject.helper.WebElementActions;
import finalProject.helper.randomGenerete.UserGenerate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    protected WaitActions wait ;

    protected WebElementActions webElementActions ;

    protected JavaScriptAction jsAction;

    public BasePage() {
        this.driver=Driver.getDriver();
        this.wait= new WaitActions();
        this.webElementActions= new WebElementActions();
        this.jsAction = new JavaScriptAction();
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
