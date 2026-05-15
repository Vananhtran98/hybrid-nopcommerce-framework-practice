package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Level_14_Log4J extends BaseTest {


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver (browserName);

        homePage = PageGenerator.getUserHomePage(driver);

        firstName = "John";
        lastName = "Philip";
        emailAddress = "john" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";

    }

    @Test
    public void User_01_Register() {
        log.info("User_01_Register - STEP 01: Open Register page");
        registerPage = homePage.openRegisterLink();

        log.info("User_01_Register - STEP 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register - STEP 03: Enter to Firstname textbox with value " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("User_01_Register - STEP 04: Enter to Lastname textbox with value " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        log.info("User_01_Register - STEP 05: Enter to Email Address textbox with value " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_01_Register - STEP 06: Enter to Company textbox with value " + companyName);
        registerPage.enterToCompanyTextbox(companyName);

        log.info("User_01_Register - STEP 07: Enter to Password textbox with value " + password);
        registerPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - STEP 08: Enter to Confirm Password textbox with value " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("User_01_Register - STEP 09: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - STEP 10: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        log.info("User_01_Register - STEP 11: Click to Logout link");
        homePage = registerPage.clickToLogoutLink();

    }

    @Test
    public void User_02_Login() {
        loginPage = homePage.openLoginPage();

        homePage = loginPage.logInToSystem(emailAddress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homePage.openCustomerInfoPage();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);
    }

    String homePageUrl;
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPageObject loginPage;

    private UserCustomerInfoPO customerInfoPage;
    private UserAddressPageObject addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    private String firstName, lastName, emailAddress, companyName, password;

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
