package com.saucelabs;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucelabs.InventoryPageObject;
import pageObjects.saucelabs.LoginPageObject;
import pageObjects.saucelabs.PageGenerator;

public class Level_22_Sort extends BaseTest {

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver (browserName, url);

        loginPage = PageGenerator.getLoginPage(driver);
        inventoryPage = loginPage.logInToApplication("standard_user", "secret_sauce");
    }

    //@Test
    public void Sort_01_Name() {
        inventoryPage.selectSortDropDown("Name (A to Z)");
        verifyTrue(inventoryPage.isNameSortAscending());

        inventoryPage.selectSortDropDown("Name (Z to A)");
        verifyTrue(inventoryPage.isNameSortDescending());

    }

    @Test
    public void Sort_02_Price() {

        inventoryPage.selectSortDropDown("Price (low to high)");
        verifyTrue(inventoryPage.isPriceSortAscending());

        inventoryPage.selectSortDropDown("Price (high to low)");
        verifyTrue(inventoryPage.isPriceSortDescending());

    }

    @Test
    public void Sort_03_Date() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private InventoryPageObject inventoryPage;
}
