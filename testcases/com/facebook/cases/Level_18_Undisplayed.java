package com.facebook.cases;

import commons.BaseTest;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGenerator;

@Feature("User")
public class Level_18_Undisplayed extends BaseTest {
    String browserName;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver (browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
    }

    @Test
    public void User_01_Element_Undisplayed() {
        loginPage.clickToNewAccountButton();
        loginPage.sleepInSecond(2);

        loginPage.enterToEmailAddressTextbox("tranthivananh1711998@gmail.com");
        loginPage.sleepInSecond(3);

        // Case 1 - Verify Confirm Email textbox is displayed (visible)
        Assert.assertTrue(loginPage.isConfirmEmailTextboxDisplayed());

        // Case 2 - Verify Confirm Email textbox is not displayed (present)
        loginPage.enterToEmailAddressTextbox("");
        loginPage.sleepInSecond(3);
        Assert.assertFalse(loginPage.isConfirmEmailTextboxDisplayed());

        // Case 3 - Verify Confirm Email textbox is not displayed (non-present)
        loginPage.clickToCloseIcon();
        loginPage.sleepInSecond(2);
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUnDisplayed());

        // findElement should not be used to look for non-present elements
        // use findElements(By) and assert zero length response instead.

    }

    @Test
    public void User_02_Element_Undisplayed() {
        loginPage.clickToNewAccountButton();
        loginPage.sleepInSecond(2);

        loginPage.enterToEmailAddressTextbox("tranthivananh1711998@gmail.com");
        loginPage.sleepInSecond(3);

        // Case 1 - Verify Confirm Email textbox is displayed (visible)
        Assert.assertFalse(loginPage.isConfirmEmailTextboxUnDisplayed());

        // Case 2 - Verify Confirm Email textbox is not displayed (present)
        loginPage.enterToEmailAddressTextbox("");
        loginPage.sleepInSecond(3);
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUnDisplayed());

        // Case 3 - Verify Confirm Email textbox is not displayed (non-present)
        loginPage.clickToCloseIcon();
        loginPage.sleepInSecond(2);
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUnDisplayed());

        // findElement should not be used to look for non-present elements
        // use findElements(By) and assert zero length response instead.

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private LoginPO loginPage;
}
