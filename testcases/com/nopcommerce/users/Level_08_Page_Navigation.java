package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.users.UserAddressPageObject;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserOrderPO;
import pageObjects.users.UserRewardPointPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPO;

public class Level_08_Page_Navigation extends BaseTest {


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
        registerPage = homePage.openRegisterLink();

        customerInfoPage = new UserCustomerInfoPO(driver); // page A -> C

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

    @Test
    public void User_04_Switch_Page() {
        // Customer Infor -> Address
        addressPage = customerInfoPage.openAddressPage(driver);
        // ...

        // Address -> Reward Point
        rewardPointPage = addressPage.openRewardPointPage(driver);
        // ...

        // Reward Point -> Order
        orderPage = rewardPointPage.openOrderPage(driver);
        // ...

        // Order -> Address
        addressPage = orderPage.openAddressPage(driver);

        // Address -> Customer Infor
        customerInfoPage = addressPage.openCustomerInfoPage(driver);

        rewardPointPage = addressPage.openRewardPointPage(driver);

        addressPage = rewardPointPage.openAddressPage(driver);

        // page A chuyển qua page B
        // Cái hàm để mở page B sẽ nằm trong page A
        // Cần khởi tạo page B lên và gán lại cho page B để chạy tiếp

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
