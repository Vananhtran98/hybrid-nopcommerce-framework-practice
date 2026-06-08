package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Level_19_Pattern_Object extends BaseTest {

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver (browserName, url);
        homePage = PageGenerator.getUserHomePage(driver);

        firstName = "John";
        lastName = "Philip";
        emailAddress = "john" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";

    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.openRegisterLink();

        registerPage.clickToRadioByID(driver, "gender-male");

        registerPage.enterToTextboxByID(driver, "FirstName", firstName);
        registerPage.enterToTextboxByID(driver,"LastName", lastName);
        registerPage.enterToTextboxByID(driver,"Email", emailAddress);
        registerPage.enterToTextboxByID(driver,"Company", companyName);
        registerPage.clickToCheckboxByID(driver, "NewsLetterSubscriptions_0__IsActive");
        registerPage.enterToTextboxByID(driver,"Password", password);
        registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);

        registerPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

    }

    @Test
    public void User_02_Login() {
        homePage = registerPage.clickToLogoutLink();
        loginPage = homePage.openLoginPage();

        loginPage.enterToTextboxByID(driver, "Email", emailAddress);
        loginPage.enterToTextboxByID(driver, "Password", password);

        loginPage.clickToButtonByText(driver, "Log in");
        homePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homePage.openCustomerInfoPage();

        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver, "gender-male"));

        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company"), companyName);

        Assert.assertTrue(customerInfoPage.isCheckboxByIDSelected(driver, "NewsLetterSubscriptions_0__IsActive"));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPageObject loginPage;

    private UserCustomerInfoPO customerInfoPage;
    private String firstName, lastName, emailAddress, companyName, password;

}
