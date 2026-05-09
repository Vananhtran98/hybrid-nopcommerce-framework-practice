package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject openRegisterLink() {

        clickToElement(driver, HomePageUI.REGISTER_LINK);
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);

    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getCustomerPage(driver);
    }
}
