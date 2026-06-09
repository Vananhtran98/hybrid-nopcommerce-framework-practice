package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPageObject;
import pageObjects.nopCommerce.users.UserRegisterPO;

import java.util.Set;

public class Login extends BaseTest {

    @Parameters({"browser", "userUrl"})
    @BeforeTest
    public void beforeTest(String browserName, String url) {
        driver = getBrowserDriver (browserName, url);
        homePage = PageGenerator.getUserHomePage(driver);

        // Data Test
        firstName = "John";
        lastName = "Philip";
        emailAddress = "john" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";

        // New user
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

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        homePage = registerPage.clickToLogoutLink();

        // Login
        loginPage = homePage.openLoginPage();

        loginPage.enterToTextboxByID(driver, "Email", emailAddress);
        loginPage.enterToTextboxByID(driver, "Password", password);

        loginPage.clickToButtonByText(driver, "Log in");
        homePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        // Get Cookies
        nopCommerceCookies = homePage.getAllCookies(driver);

        driver.quit();
    }


    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPageObject loginPage;
    private String firstName, lastName, emailAddress, companyName, password;
    public static Set<Cookie> nopCommerceCookies;

}
