import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPlatformDigitalAssets extends BaseTest {
    @BeforeMethod
    public void getCFAPage() {
        sber.clickOnLinkForChange();
        sberPlatform.clickOnEnyButton("ЦФА");
    }

    @Test
    public void testPlatformDigitalAssets() {
        cfaReleasedPage.getPAOSber();
        Assert.assertTrue(cfaReleasedPage.getContainsInResult(cfaReleasedPage.resultPlacement, "26"), "Фактический и ожидаемый результат не сходится (Размещение) ");
        Assert.assertTrue(cfaReleasedPage.getContainsInResult(cfaReleasedPage.resultReleaseTookPlace, "52"), "Фактический и ожидаемый результат не сходится (Выпуск состоялся)");
        Assert.assertTrue(cfaReleasedPage.getContainsInResult(cfaReleasedPage.resultIssueCancelled, "83"), "Фактический и ожидаемый результат не сходится (Выпуск погашен)");
    }

//    @Test
//    public void justplay(){
//        cfaReleasedPage.getListEmitents();
//    }
}
