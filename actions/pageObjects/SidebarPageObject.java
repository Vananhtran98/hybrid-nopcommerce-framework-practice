package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPointPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerPage(driver);
    }

    public AddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.ORDER_LINK);
        clickToElement(driver, SidebarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }
}
