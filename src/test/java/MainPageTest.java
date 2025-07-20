
import finalProject.utilFiles.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest{

    @Test
    public void clickWindows(){
        mainPage.selectCase(mainPage.widget,1);
        Assert.assertTrue(waitActions.doesUrlContains("forms"),"URL не содержит \"forms\"");
    }
}
