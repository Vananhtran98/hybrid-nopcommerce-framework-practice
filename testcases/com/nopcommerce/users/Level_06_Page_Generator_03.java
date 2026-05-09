package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level_06_Page_Generator_03 extends BaseTest {


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver (browserName);

        homePage = PageGenerator.getHomePage(driver);

        firstName = "John";
        lastName = "Philip";
        emailAddress = "john" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";

    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.openRegisterLink();

        customerInfoPage = new CustomerInfoPageObject(driver); // page A -> C

        registerPage.clickToMaleRadio();

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLogoutLink();
        loginPage = registerPage.openLoginPage();

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
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;

    private String firstName, lastName, emailAddress, companyName, password;

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
