package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPageObject;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level_09_Switch_Site_Url extends BaseTest {


    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(browserName, this.userUrl);

        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "John";
        lastName = "Philip";
        emailAddress = "john" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";

        adminEmailAddress = "admin@yourstore.com";
        adminPassword = "admin";

        // Precondition
        userRegisterPage = userHomePage.openRegisterLink();

        userRegisterPage.clickToMaleRadio();

        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

        userHomePage = userRegisterPage.clickToLogoutLink();
    }

    @Test
    public void Role_01_User_Site_To_Admin_Site() {
        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.logInToSystem(emailAddress, password);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        // Step để order 1 product nào đó
        // ...

        // Qua trang admin để verify/ approve cái order ở trên vs quyền Admin
        userHomePage.openPageUrl(driver, this.adminUrl);
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        // Login vào trang admin
        adminLoginPage.enterToEmailTextbox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        // Vào trang Order/ Customer/...
        // ...
        adminDashboardPage.openPageUrl(driver, this.userUrl);
        userHomePage = PageGenerator.getUserHomePage(driver);

        // Action các step tiếp theo
        // ...

        userCustomerInfoPO = userHomePage.openCustomerInfoPage();
        Assert.assertTrue(userCustomerInfoPO.isGenderMaleSelected());
        Assert.assertEquals(userCustomerInfoPO.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(userCustomerInfoPO.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(userCustomerInfoPO.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(userCustomerInfoPO.getCompanyTextboxValue(), companyName);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    String homePageUrl;
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private UserCustomerInfoPO userCustomerInfoPO;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;

    private String firstName, lastName, emailAddress, companyName, password;
    private String userUrl, adminUrl, adminEmailAddress, adminPassword;
}


