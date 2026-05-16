package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.users.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class Level_15_ExtentReport extends BaseTest {
    String browserName;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver (browserName);
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;

        firstName = "John";
        lastName = "Philip";
        emailAddress = "john" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";

    }

    @Test
    public void User_01_Register(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "User_01_Register");
        ExtentManager.getTest().log(Status.INFO, "NewCustomer - Step 01: Open 'New Customer' page");

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 01: Open Register page");
        registerPage = homePage.openRegisterLink();

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 03: Enter to Firstname textbox with value " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 04: Enter to Lastname textbox with value " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 05: Enter to Email Address textbox with value " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 06: Enter to Company textbox with value " + companyName);
        registerPage.enterToCompanyTextbox(companyName);

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 07: Enter to Password textbox with value " + password);
        registerPage.enterToPasswordTextbox(password);

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 08: Enter to Confirm Password textbox with value " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 09: Click to Register button");
        registerPage.clickToRegisterButton();

        
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 10: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

    }

    @Test
    public void User_02_Login(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "User_02_Login");

        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.openLoginPage();

        homePage = loginPage.logInToSystem(emailAddress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_MyAccount(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "User_03_MyAccount");
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
