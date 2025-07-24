import finalProject.driver.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class SberTest extends BaseTest {

    @BeforeMethod
    public void refreshUrl(){
        if (!Objects.equals(Driver.getDriver().getCurrentUrl(), "https://www.sberbank.ru/ru/legal/services/digital-assets")){
            driver.get("https://www.sberbank.ru/ru/legal/services/digital-assets");
        }
    }

    @Test
    public void checkTextInPlatform() {
        sber.linkForChangePage.click();
        Assert.assertTrue(sberPlatform.checkMainTextIsVisible());
    }

    @Test
    public void checkButtonClickable() {
        sber.clickOnLinkForChange();
        Assert.assertTrue(sberPlatform.checkButtonClickable(sberPlatform.nftButton), "Кнопка NFT не кликабельна");
        Assert.assertTrue(sberPlatform.checkButtonClickable(sberPlatform.secondaryMarketButton), "Кнопка  Вторичный рынок не кликабельна ");
        Assert.assertTrue(sberPlatform.checkButtonClickable(sberPlatform.cfaReleasedButton), "Кнопка ЦФА-Выпускники не кликабельна ");
    }

    @Test
    public void checkTextInNFTPage() {
        sber.clickOnLinkForChange();
        sberPlatform.clickOnEnyButton("NFT");
        Assert.assertTrue(nftPage.visibleOnMainText(),"Текст не виден");
    }

    @Test
    public void checkTextInCFAReleasedPage() {
        sber.clickOnLinkForChange();
        sberPlatform.clickOnEnyButton("ЦФА");
        Assert.assertTrue(cfaReleasedPage.checkOnMainText(),"Текст не виден");
    }

    @Test
    public void checkTextInSecondaryMarkedPage() {
        sber.clickOnLinkForChange();
        sberPlatform.clickOnEnyButton("Вторичный рынок");
        Assert.assertTrue(secondaryMarketPage.checkOnMainText(),"Текст не виден");
    }

}
