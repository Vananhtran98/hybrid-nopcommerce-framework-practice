package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserHomePageUI;
import pageUIs.users.UserRegisterPageUI;

public class UserHomePO extends BasePage {

    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO openRegisterLink() {

        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);

    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }

    public UserLoginPageObject openLoginPage() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.REGISTER_LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
}
