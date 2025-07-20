import finalProject.driver.Driver;
import finalProject.helper.*;
import finalProject.page.MainPage;
import finalProject.page.demoQA.elements.TextBox;
import finalProject.page.mentorFile.*;
import finalProject.utilFiles.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    /**
     * Инициализации helper пакета
     */
    protected WebElementActions webElementActions;

    protected AlertAction alertAction;

    protected JavaScriptAction jsAction;

    protected BrowserAction browserAction;

    protected WaitActions waitActions;

    protected WebDriver driver = Driver.getDriver();

    /**
     * Инициализация page пакета
     */

    public MainPage mainPage = new MainPage();
    public TextBox textBox = new TextBox();
    public AutorotationPage autorotationPage = new AutorotationPage();
    public CFAReleasedPage cfaReleasedPage = new CFAReleasedPage();
    public NFTPage nftPage = new NFTPage();
    public Sber sber=new Sber();
    public SberPlatform sberPlatform = new SberPlatform();
    public SecondaryMarketPage secondaryMarketPage = new SecondaryMarketPage();


    @BeforeSuite
    public void setUp() {
        webElementActions = new WebElementActions();
        alertAction = new AlertAction();
        jsAction = new JavaScriptAction();
        browserAction = new BrowserAction();
        waitActions = new WaitActions();
    }

    @AfterSuite
    public void tearDown() {
        browserAction.quitBrowser();
    }

    @BeforeClass
    public void beforeClassOpenWindows(){
        waitActions.justWait(2);
        driver.get(ConfigReader.getProperty("dashboardURL"));
    }

}
