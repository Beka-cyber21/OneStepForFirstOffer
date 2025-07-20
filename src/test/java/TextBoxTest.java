import finalProject.page.demoQA.elements.TextBox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @BeforeMethod
    public void openMyTextBoxUrl() {
        mainPage.selectCase(mainPage.widget, 0);
        mainPage.selectCase(mainPage.accordion, 0);
    }


    @Test
    public void checkTextInCheckBox() {
        textBox.enterDataInBoxForTest();
    }
    @Test
    public void checkTextInCheckBox01() {
        textBox.createNewUser();
    }
}
