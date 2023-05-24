package tests.day18_testNGReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.security.Key;

public class C01_RaporluAmazonSearchTesti extends TestBaseRapor {

    @Test
    public void test1(){

        extentTest = extentReports.createTest("amazon Arama Testi",
                "kullanici istedigi kelimeyi kullanabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        extentTest.info("kullanici ana sayfaya gider");

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        extentTest.info("arama kutusunsa belirlenen aranacak kelimeyi yazar ve aratir");


        String actualSonucYAzisi = amazonPage.aramaSonucuElementi.getText();
        String expectedIcerik = ConfigReader.getProperty("amazonExpectedIcerik");

        Assert.assertTrue(actualSonucYAzisi.contains(expectedIcerik));

        extentTest.pass("belielenen aranacak kelime aratildiginda, arama sonocunda expected icerik oldugu test edildi");

        Driver.closeDriver();

    }
}
