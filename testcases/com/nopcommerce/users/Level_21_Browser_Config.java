package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level_21_Browser_Config extends BaseTest {

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver (browserName, url);
    }

    @Test
    public void User_01_MyAccount() {
        registerPage.clickToButtonByText(driver, "Register");

    }

    @Test
    public void User_02_Order() {


    }

    @Test
    public void User_03_Payment() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        // closeBrowserDriver();
    }

    private WebDriver driver;
    private UserRegisterPO registerPage;

}
