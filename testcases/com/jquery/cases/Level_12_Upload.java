package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level_12_Upload extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);

        hoian = "Hoi An.jpg";
        hagiang = "Ha Giang.jpg";
        phuquoc = "Phu Quoc.jpg";

    }

    @Test
    public void Table_01_Upload() {

        // Có thể upload 1 lần 1 file => dùng 1 hàm
        // Có thể upload 1 lần nhiều file => dùng 1 hàm
        homePage.uploadMultipleFiles(driver, hoian, hagiang, phuquoc);
        homePage.sleepInSecond(3);

        // Verify load file lên
        Assert.assertTrue(homePage.isFileLoadedByName(hoian));
        Assert.assertTrue(homePage.isFileLoadedByName(hagiang));
        Assert.assertTrue(homePage.isFileLoadedByName(phuquoc));

        // Click Upload button tại từng file
        homePage.clickToUploadButton(driver);

        // Có thể verify 1 file/ nhiều file được upload xong
        Assert.assertTrue(homePage.isFileUploadedByName(hoian));
        Assert.assertTrue(homePage.isFileUploadedByName(hagiang));
        Assert.assertTrue(homePage.isFileUploadedByName(phuquoc));





    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePO homePage;
    private String hagiang, hoian, phuquoc;
}
