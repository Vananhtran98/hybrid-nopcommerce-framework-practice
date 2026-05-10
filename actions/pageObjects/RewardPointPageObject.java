package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.RewardPointPageUI;

public class RewardPointPageObject extends SidebarPageObject {
    private WebDriver driver;

    public RewardPointPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
