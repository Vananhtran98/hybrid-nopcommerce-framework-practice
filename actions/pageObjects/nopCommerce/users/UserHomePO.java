package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.users.UserHomePageUI;
import pageUIs.nopCommerce.users.UserRegisterPageUI;

public class UserHomePO extends BasePage {

    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Register Page")
    public UserRegisterPO openRegisterLink() {

        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);

    }

    @Step("Verify My Account link is displayed")
    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    @Step("Open Customer Infor Page")
    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }

    @Step("Open Login Page")
    public UserLoginPageObject openLoginPage() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.REGISTER_LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
}
