package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_01 extends BaseTest {


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver (browserName);

        homePage = new HomePageObject(driver); // Lần 1

        firstName = "John";
        lastName = "Philip";
        emailAddress = "john" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";

    }

    @Test
    public void User_01_Register() {
        // Action 1
        homePage.openRegisterLink();

        // Thể hiện trực tiếp trên Test Class
        // Nguyên tc thiết kế phần mềm/ framework
        registerPage = new RegisterPageObject(driver);

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
        // Ko có sự kết nối
        registerPage.clickToLogoutLink();
        registerPage.openLoginPage();
        loginPage = new LoginPageObject(driver);

        loginPage.logInToSystem(emailAddress, password);
        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver); // Lần 2

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_MyAccount() {
        homePage.openCustomerInfoPage();

        customerInfoPage = new CustomerInfoPageObject(driver);

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);

    }

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
